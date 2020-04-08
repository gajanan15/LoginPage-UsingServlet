import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = {"/loginServlet"},
        initParams = {
                @WebInitParam(name = "userName",value = "Gajanan"),
                @WebInitParam(name = "password",value = "gajanan@123")
        }
)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("userPassword");

        String userId = getServletConfig().getInitParameter("userName");
        String passwordID = getServletConfig().getInitParameter("password");

        if(userId.equals(userName) && passwordID.equals(password)){
            request.setAttribute("userName",userName);
            request.getRequestDispatcher("loginSuccess.jsp").forward(request,response);
        }else {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/loginPage.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Either UserName Or Password Is Wrong.</font>");
            requestDispatcher.include(request,response);
        }
    }
}
