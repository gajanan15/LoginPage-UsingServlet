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
        urlPatterns = {"/loginServlet"}
)
public class LoginServlet extends HttpServlet {

    static String VALID_NAME_PATTERN = "^[A-Z]{1}[a-z]{2,}$";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");


        if (userName.matches(VALID_NAME_PATTERN) && userPassword.equals("gajanan")) {
            request.setAttribute("userName", userName);
            request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/loginPage.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Either UserName Or Password Is Wrong.</font>");
            requestDispatcher.include(request, response);
        }
    }
}
