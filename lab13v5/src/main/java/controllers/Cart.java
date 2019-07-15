package controllers;

import DAO.DataBase;
import Model.Product;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/cart")
public class Cart extends HttpServlet {

    private DataBase dao;
    Gson mapper = new Gson();
    List<Product> cartProducts = new ArrayList<Product>();
    @Override
    public void init() throws ServletException {
        dao = new DataBase();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        System.out.println("cart get entered");
        int id = Integer.parseInt(req.getParameter("productID"));
         for(Product pr:cartProducts){

             if(pr.getId()==id){
                 cartProducts.remove(pr);
                 System.out.println("Product removed");
             }
         }
        System.out.println(cartProducts.size());
        session.setAttribute("cartSize",cartProducts.size());
        session.setAttribute("cartProducts",cartProducts);

       ;out.print( mapper.toJson(cartProducts.size()));



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();

        int id = Integer.parseInt(req.getParameter("productID"));

        Product product = dao.getProductById(id);
           cartProducts.add(product);
           // getting the number of products
          int cartSize = cartProducts.size();
            session.setAttribute("cartSize",cartSize);
           session.setAttribute("cartProducts",cartProducts);
           System.out.println("cart entered");

          String json1 = mapper.toJson(product);
          String json2 = mapper.toJson(cartSize);
        String bothJson = "["+json1+","+json2+"]"; //Put both objects in an array of 2 elements
        out.write(bothJson);
       // out.print(mapper.toJson(product));
    }
}
