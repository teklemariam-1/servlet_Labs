package controllers;

import Model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/checkout")
public class Checkout extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        List<Product> products =(List<Product>) session.getAttribute("cartProducts");
        int totalPrice = 0;

        for(Product pr:products) {

             totalPrice = totalPrice + Integer.parseInt(pr.getPrice());
        }
              session.setAttribute("totalPrice",totalPrice);
        System.out.println("cart get entered");
        System.out.println(totalPrice);

        RequestDispatcher dispatcher = req.getRequestDispatcher("checkout.jsp");
        dispatcher.forward(req,resp);

    }
}
