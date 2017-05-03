package com.gaigai.webzeroc2.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2017/4/28.
 */
public class PropsUtil {
    private static final Logger logger = LoggerFactory.getLogger(PropsUtil.class);

    public static Properties loadProperties(String fileName){
        Properties properties = null;
        InputStream is = null;
        try{
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (is == null){
                throw new FileNotFoundException("属性文件：" + fileName + "没有找到，请确认路径是否在正确");
            }
            properties = new Properties();
            properties.load(is);
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            logger.error("加载配置文件错误:" + fileName, e);
        } catch (IOException e) {
//            e.printStackTrace();
            logger.error("加载配置文件错误:" + fileName, e);
        }finally {
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
//                    e.printStackTrace();
                    logger.error("关闭文件发生了异常。。" , e);
                }
            }
        }
        return properties;
    }

    /**
     * 获取字符串类型值 默认为空
     * @param props
     * @param key
     * @return
     */
    public static String getString(Properties props, String key){
        return getString(props, key, "");
    }

    /**
     * 可以指定默认值的获取参数
     * @param props
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(Properties props, String key, String defaultValue) {
        String value = defaultValue;
        if (props.containsKey(key)){
            value = props.getProperty(key);
        }
        return value;
    }
}
