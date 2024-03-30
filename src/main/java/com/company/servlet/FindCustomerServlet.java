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
import java.util.Collections;

@WebServlet("/find")
public class FindCustomerServlet extends HttpServlet {
    @EJB
    private CustomerDAO customerDAO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("reset") != null) {
            resp.sendRedirect(getServletContext().getContextPath() + "/");
        } else {
            String id = req.getParameter("id");
            if(id != null) {
                Customer customer = customerDAO.get(Long.parseLong(id));
                req.setAttribute("customerList", Collections.singletonList(customer));
            }
            else
                req.setAttribute("customerList", null);
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
