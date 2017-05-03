package com.gaigai.webzeroc2.service;

import com.gaigai.webzeroc2.model.Customer;
import com.gaigai.webzeroc2.util.DataBaseHelper;
import com.gaigai.webzeroc2.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.*;

/**
 * Created by Administrator on 2017/4/28.
 */
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    /**
     * 查询所有的客户信息
     *
     * @return
     */
    public List<Customer> getCustomerList() {
        String sql = "SELECT id, name, contact, telephone, email, remark FROM customer";
        List<Customer> customers = DataBaseHelper.queryEntityList(Customer.class,sql);
        return customers;
    }

    public Customer getCustomer(long id) {
        String sql = "SELECT id, name, contact, telephone, email, remark FROM customer";
        return DataBaseHelper.queryEntity(Customer.class, sql, id);
    }

    public boolean createCustomer(Map<String, Object> fieldMap) {
        return DataBaseHelper.insertEntity(Customer.class, fieldMap);
    }


    public boolean editCustomer(long id,Map<String, Object> fieldMap) {
        return DataBaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    public boolean deleteCustomer(long id) {
        return DataBaseHelper.deleteEntity(Customer.class, id);
    }
}
