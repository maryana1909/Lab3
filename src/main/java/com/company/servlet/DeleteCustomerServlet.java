package com.company.servlet;

import com.company.dao.CustomerDAO;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/remove")
public class DeleteCustomerServlet extends HttpServlet {
    @EJB
    private CustomerDAO customerDAO;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("remove_id"));
        customerDAO.removeById(id);
        resp.sendRedirect(getServletContext().getContextPath() + "/");
    }
}
