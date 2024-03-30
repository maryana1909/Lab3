package com.company.servlet;

import com.company.dao.CustomerDAO;
import com.company.entity.Customer;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddCustomerServlet extends HttpServlet {
    @EJB
    private CustomerDAO customerDAO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Customer customer = new Customer();
        customer.setName(req.getParameter("name"));
        customer.setEmail(req.getParameter("email"));
        customer.setCity(req.getParameter("city"));
        customerDAO.add(customer);
        resp.sendRedirect(getServletContext().getContextPath());
    }
}
