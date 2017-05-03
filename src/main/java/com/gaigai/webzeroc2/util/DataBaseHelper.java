package com.gaigai.webzeroc2.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by Administrator on 2017/5/2.
 */
public class DataBaseHelper {

    private static final Logger logger = LoggerFactory.getLogger(DataBaseHelper.class);
    private static final String DB_CONFIG_FILENAME = "db-config.properties";

    private static final ThreadLocal<Connection> CONNECTION_HOLDER;

    private static final QueryRunner QUERY_RUNNER = new QueryRunner();

    private static final BasicDataSource DATA_SOURCE;

    private static String DRIVER = null;
    private static String URL = null;
    private static String USERNAME = null;
    private static String PASSWORD = null;

    public static final String JDBC_DRIVER = "jdbc.driver";

    public static final String JDBC_URL = "jdbc.url";

    public static final String JDBC_USERNAME = "jdbc.username";

    public static final String JDBC_PASSWORD = "jdbc.password";

    static {
        CONNECTION_HOLDER = new ThreadLocal<Connection>();
        Properties properties = PropsUtil.loadProperties(DB_CONFIG_FILENAME);
        DRIVER = PropsUtil.getString(properties, JDBC_DRIVER);
        URL = PropsUtil.getString(properties, JDBC_URL);
        USERNAME = PropsUtil.getString(properties, JDBC_USERNAME);
        PASSWORD = PropsUtil.getString(properties, JDBC_PASSWORD);

        DATA_SOURCE = new BasicDataSource();
        DATA_SOURCE.setDriverClassName(DRIVER);
        DATA_SOURCE.setUrl(URL);
        DATA_SOURCE.setUsername(USERNAME);
        DATA_SOURCE.setPassword(PASSWORD);
    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection() {
        Connection connection = CONNECTION_HOLDER.get();
        if (connection == null) {
            try {
//                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                connection = DATA_SOURCE.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
                logger.error("获取数据库连接异常", e);
                throw new RuntimeException(e);
            }finally {
                CONNECTION_HOLDER.set(connection);
            }
        }
        return connection;
    }

    public static void executeSqlFile(String filePath){
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        try{
            String sql;
            while ((sql = bufferedReader.readLine()) != null){
                executeUpdate(sql);
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("执行SQL文件异常", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 关闭数据库连接
     */
    public static void closeConnection() {
        Connection connection = CONNECTION_HOLDER.get();
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                logger.error("数据库连接关闭异常", e);
                throw new RuntimeException(e);
            }finally {
                CONNECTION_HOLDER.remove();
            }
        }

    }

    /**
     * 查询实体列表
     *
     * @param entityClass
     * @param sql
     * @param params
     * @param <T>
     * @return
     */
    public static <T> List<T> queryEntityList(Class<T> entityClass, String sql, Object... params) {
        List<T> entityList;
        try {
            Connection connection = getConnection();
            entityList = QUERY_RUNNER.query(connection, sql, new BeanListHandler<T>(entityClass), params);
        } catch (SQLException e) {
//            e.printStackTrace();
            logger.error("查询列表信息出现异常", e);
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
        return entityList;
    }

    /**
     * 查询单个实体
     * @param entityClass
     * @param sql
     * @param params
     * @param <T>
     * @return
     */
    public static <T> T queryEntity(Class<T> entityClass, String sql, Object... params){
        T entity;
        try {
            Connection connection = getConnection();
            entity = QUERY_RUNNER.query(connection, sql, new BeanHandler<T>(entityClass), params);
            // BeanHandler 多态的一种表现形式
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("查询实体bean出现异常", e);
            throw new RuntimeException(e);
        }finally {
            closeConnection();
        }
        return entity;
    }

    /**
     * 多表查询 返回集合
     * @param sql
     * @param params
     * @return
     */
    public static List<Map<String, Object>> executeQuery(String sql, Object... params){
        List<Map<String, Object>> list = null;
        try {
            Connection connection = getConnection();
            list = QUERY_RUNNER.query(connection, sql, new MapListHandler(), params);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("数据库查询出现异常", e);
            throw new RuntimeException(e);
        }finally {
            closeConnection();
        }
        return list;
    }

    /**
     * 更新语句
     * @param sql
     * @param params
     * @return
     */
    public static int executeUpdate(String sql, Object... params){
        int rows =0;
        try {
            Connection connection = getConnection();
            rows = QUERY_RUNNER.update(connection, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("数据库查询出现异常", e);
            throw new RuntimeException(e);
        }finally {
            closeConnection();
        }
        return rows;
    }

    public static <T> boolean insertEntity(Class<T> entityClass, Map<String, Object> fieldMap){
        if (CollectionUtil.isEmpty(fieldMap)){
            logger.error("不能插入空对象。。。");
            return false;
        }
        String sql = "INSERT INTO " + getTableName(entityClass);
        StringBuilder columns = new StringBuilder("(");
        StringBuilder values = new StringBuilder(" (");
        for (String fieldName : fieldMap.keySet()){
            columns.append(fieldName).append(", ");
            values.append("?, ");
        }
        columns.replace(columns.lastIndexOf(", "), columns.length(), ")");
        values.replace(values.lastIndexOf(", "), values.length(), ")");
        sql += columns + " VALUES " + values;
        Object[] params = fieldMap.values().toArray();
        return executeUpdate(sql, params) == 1;
    }

    /**
     * 更新
     * @param entityClass
     * @param id
     * @param fieldMap
     * @param <T>
     * @return
     */
    public static <T> boolean updateEntity(Class<T> entityClass,long id, Map<String, Object> fieldMap){
        if (CollectionUtil.isEmpty(fieldMap)){
            logger.error("不能更新空对象。。。");
            return false;
        }
        String sql = "UPDATE " + getTableName(entityClass) + " SET ";
        StringBuilder colums = new StringBuilder();
        for (String field: fieldMap.keySet()){
            colums.append(field).append(" = ?, ");
        }
        sql += colums.substring(0, colums.lastIndexOf(", ")) + "WHERE id = ?";
        List<Object> paramList = new ArrayList<>();
        paramList.addAll(fieldMap.values());
        paramList.add(id);
        Object[] params = paramList.toArray();
        return executeUpdate(sql, params) == 1;

    }

    /**
     * 删除实体
     * @param entityClass
     * @param id
     * @param <T>
     * @return
     */
    public static <T> boolean deleteEntity(Class<?> entityClass, long id){
        String sql = "DELETE FROM " + getTableName(entityClass) + "WHERE id = ?";
        return executeUpdate(sql, id) == 1;
    }

    public static  String getTableName(Class<?> entityClass) {
        return entityClass.getSimpleName();
    }

}
