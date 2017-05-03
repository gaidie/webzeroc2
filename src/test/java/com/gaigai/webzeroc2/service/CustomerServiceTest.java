package com.gaigai.webzeroc2.service;

import com.gaigai.webzeroc2.model.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/4/28.
 */
public class CustomerServiceTest {

    private final CustomerService customerService;

    public CustomerServiceTest(){
        customerService = new CustomerService();
    }

    /**
     * 初始化数据量连接
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getCustomerList() throws Exception {
        List<Customer> customerList = customerService.getCustomerList();
        assertEquals(2, customerList.size());
    }

    @Test
    public void getCustomer() throws Exception {

    }

    @Test
    public void createCustomer() throws Exception {

    }

    @Test
    public void editCustomer() throws Exception {

    }

    @Test
    public void deleteCustomer() throws Exception {

    }
}