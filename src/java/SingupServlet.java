import com.sun.xml.ws.transport.tcp.server.tomcat.grizzly10.HttpRedirector;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SingupServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        String email = req.getParameter("email");
        String uname = req.getParameter("username");
        String pass = req.getParameter("password");
        
        boolean valid = (uname != null) && uname.matches("[A-Za-z0-9_]+");
        boolean pvalid = pass.matches("(?=.*[a-z])(?=.*\\\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40}");
        
        EmailCheck obj = new EmailCheck();
        
        if (obj.isValid(email)) {
            
            out.println("email correct");
            if (valid) {
                out.println("<br/>uname correct");
                if (pvalid) {
                    out.println("<br/>password correct");
                    res.sendRedirect("formup.html");
                } else {
                    out.println("<br/>password incorrect");
                    res.sendRedirect("Signup.html");
                }
            } else {
                out.println("<br/>uname incorrect");
            }
            
        } else {
            out.println("Error please try again \n E-mail error");
        }
        
        
        
        /*int val = obj.validate(pass);
        if (val == 1) {
                out.println("password correct");
        } else {
            out.println("Error please try again \n Password error");
        }*/
    }
}