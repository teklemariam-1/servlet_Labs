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
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ProductController
 */
@WebServlet({"/product", ""})
public class ProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DataBase dao;
    Gson mapper = new Gson();

    @Override
    public void init() throws ServletException {
        dao = new DataBase();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("products", dao.getAllProducts());
        RequestDispatcher view = request.getRequestDispatcher("product.jsp");
        view.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
       // String jsonSting = request.getParameter("product");

        // Mapping to Java Object
        Product product = mapper.fromJson(request.getParameter("product"), Product.class);
        product.setId(dao.genId());

        // Add to Data Base
        dao.addProduct(product);
         request.setAttribute("product",product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("productList");
            dispatcher.forward(request,response);

        for(Product p:dao.getAllProducts()){
            System.out.println(p.getName());
        }
       // out.print(mapper.toJson(product));
          // saving image part

//        // Getting File data
//        Part part = request.getPart("imageData");
//
//        // Getting Application Path
//        String appPath = request.getServletContext().getRealPath("");
//
//        // File path where all files will be stored
//        String imagePath = appPath + "images";
//
//        //Get Image Name
//        String imageName = part.getSubmittedFileName();
//
//
//        // Creates the file directory if it does not exists
//        File fileDir = new File(imagePath);
//        if (!fileDir.exists()) {
//            fileDir.mkdirs();
//        }
//
//        part.write(imagePath + File.separator + imageName);
//
//       String imageURL= "<img src=\"images/"+imageName+"\">";
//
    }

}
