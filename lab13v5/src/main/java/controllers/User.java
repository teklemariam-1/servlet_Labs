package controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/admin/login")
public class User extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        System.out.println("de Get login servlet");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        out.print("<html><head><title>Test</title></head><body>");
        out.print("<form method='Post' action='login' >");
        out.print(" controllers.User Name: <input name='name' type='text'> ");
        out.print("Password: <input name='password' type='password'> ");

        out.print(" <input type='submit'  value='login'> ");
        out.print("</form>");
        out.print("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println("sesion registration");
        session.setAttribute("username",(req.getParameter("name")));
        session.setAttribute(("password"),(req.getParameter("password")));
//        System.out.println("userName is" + session.getAttribute("username"));
//        System.out.println("userName is from param" + req.getParameter("name"));
      //  System.out.println("password is from param" + req.getParameter("password"));
        System.out.println("do Post login servlet");
        RequestDispatcher dispatcher = req.getRequestDispatcher("welcome");
      // System.out.println(req.getMethod());
        dispatcher.forward(req,resp);
    }
}
