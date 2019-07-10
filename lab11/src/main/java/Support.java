import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet ("/support")
public class Support extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        out.print("<html><head><title>Test</title></head><body>");
        out.print("<form method='post'>");
        out.print(" Name: <input name='name' type='text'> ");
        out.print("Email Address: <input name='email' type='text'> ");
        out.print("problem : <input type='text'> ");
        out.print(" problem description: <textarea></textarea > ");
        out.print(" <input type='submit'  value='help'> ");
        out.print("</form>");
        out.print("</body></html>");
}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = req.getServletContext();
        String email = sc.getInitParameter("support-email");
        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int random = rand.nextInt(2000);
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        out.print("<html><head><title>Test</title></head><body>");
        out.print("Thank you!");
        out.print(req.getParameter("name"));
        out.print("for contacting us. We should receive reply from us with in 24 hrs in your email address");
        out.print(req.getParameter("email"));
        out.print(". Let us know in our support email ");
        out.print(email);
        out.print("if you don’t receive reply within 24 hrs. Please be sure to attach your reference");
        out.print(random);
        out.print("in your email");
        out.print("</body></html>");

    }
}
