package controllers;

import DAO.DataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/productDelete")
public class DeleteProduct extends HttpServlet {
    private DataBase dao;
    @Override
    public void init() throws ServletException {
        dao = new DataBase();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          dao.deleteProduct(Integer.parseInt(req.getParameter("productID")));


    }
}
