package com.gaigai.webzeroc2.service;

import com.gaigai.webzeroc2.model.Customer;
import com.gaigai.webzeroc2.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2017/4/28.
 */
public class CustomerServiceJDBCExample {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceJDBCExample.class);
    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    public static final String JDBC_DRIVER = "jdbc.driver";

    public static final String JDBC_URL = "jdbc.url";

    public static final String JDBC_USERNAME = "jdbc.username";

    public static final String JDBC_PASSWORD = "jdbc.password";


    public static final String DB_CONFIG_PROPERTIES = "db-config.properties";

    static{
        Properties properties = PropsUtil.loadProperties(DB_CONFIG_PROPERTIES);
        DRIVER = properties.getProperty(JDBC_DRIVER);
        URL = properties.getProperty(JDBC_URL);
        USERNAME = properties.getProperty(JDBC_USERNAME);
        PASSWORD = properties.getProperty(JDBC_PASSWORD);
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            logger.error("数据库驱动未找到异常。。。", e);
        }

    }

    /**
     * 查询所有的客户信息
     * @param keyword
     * @return
     */
    public List<Customer> getCustomerList(String keyword){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL,  USERNAME, PASSWORD);
            String sql = "SELECT id, name, contact, telephone, email, remark FROM customer";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Customer> customers = new ArrayList<>();
            while (resultSet.next()){
                Customer customer = new Customer();
                customer.setId(resultSet.getLong("id"));
                customer.setName(resultSet.getString("name"));
                customer.setContact(resultSet.getString("contact"));
                customer.setTelephone(resultSet.getString("telephone"));
                customer.setEmail(resultSet.getString("email"));
                customer.setRemark(resultSet.getString("remark"));
                customers.add(customer);
            }
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("数据库执行异常", e);
        }finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    logger.error("数据库连接关闭时异常", e );
                }
            }
        }
        return null;
    }

    public Customer getCustomer(long id){
        return  null;
    }

    public boolean createCustomer(Map<String, Object> fieldMap){
        return false;
    }

    public boolean editCustomer(Map<String, Object> fieldMap){
        return false;
    }

    public boolean deleteCustomer(long id){
        return false;
    }
}
