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
    static String VALID_PASSWORD_PATTERN = "^((?=[^@|#|&|%|$]*[@|&|#|%|$][^@|#|&|%|$]*$)(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9#@$?]{8,})$";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");

        boolean validName = (userName != null) && userName.matches(VALID_NAME_PATTERN);
        boolean pass = (userPassword != null) && userPassword.matches(VALID_PASSWORD_PATTERN);

        if (validName && pass) {
            request.setAttribute("userName", userName);
            request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/loginPage.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Enter Valid UserName Or Password.</font>");
            requestDispatcher.include(request, response);
        }
    }
}
