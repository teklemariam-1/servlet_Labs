package controllers;

import DAO.DataBase;
import Model.Product;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/productList")
public class ProductList extends HttpServlet {

    private DataBase dao;

    Gson mapper = new Gson();
    @Override
    public void init() throws ServletException {
        dao = new DataBase();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("inside product List");

        req.setAttribute("products", dao.getAllProducts());

        RequestDispatcher view = req.getRequestDispatcher("productList.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        dao.addProduct((Product)(req.getAttribute("product")));
        out.print(mapper.toJson(req.getAttribute("product")));
    }
}
