package com.gaigai.webzeroc2.controller;

import com.gaigai.webzeroc2.model.Customer;
import com.gaigai.webzeroc2.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/4/28.
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {

    public static final String WEB_INF_VIEW_CUSTOMER_JSP = "/WEB-INF/view/customer.jsp";

    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        customerService = new CustomerService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = customerService.getCustomerList();
        request.setAttribute("customers", customers);
        request.getRequestDispatcher(WEB_INF_VIEW_CUSTOMER_JSP).forward(request, response);
    }
}
