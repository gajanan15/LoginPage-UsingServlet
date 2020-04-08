import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet(
        description = "Registration Page",
        urlPatterns = "/registrationServletPage"
)
public class RegistrationServlet extends HttpServlet {
    static String VALID_NAME_PATTERN = "^[A-Z]{1}[a-z]{2,}$";
    static String VALID_PASSWORD_WITH_ATLEAST_ONE_UPPER_CASE_PATTERN = "^(?=.*[A-Z])[a-zA-Z0-9]{8,}$";
    static String VALID_PASSWORD_WITH_ATLEAST_ONE_NUMERIC_NUMBER = "^(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{8,}$";
    static String VALID_PASSWORD_PATTERN = "^((?=[^@|#|&|%|$]*[@|&|#|%|$][^@|#|&|%|$]*$)(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9#@$?]{8,})$";
    static String VALID_MOBILE_NUMBER_PATTERN = "^([1-9]{1}[0-9]{9})$";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String userPassword = request.getParameter("userPassword");
        String mobileNo = request.getParameter("number");
        String gender = request.getParameter("gender");

        if (!(Pattern.matches(VALID_NAME_PATTERN, name)) || !(Pattern.matches(VALID_PASSWORD_PATTERN, userPassword)) || !(Pattern.matches(VALID_MOBILE_NUMBER_PATTERN, mobileNo))) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/registrationPage.jsp");
            PrintWriter out = response.getWriter();
            if (!(Pattern.matches(VALID_NAME_PATTERN, name)))
                out.println("<font color=red>First Letter Should Be Capital and Minimum 3 Character Should Be Enter.</font>");
            else if (!(Pattern.matches(VALID_PASSWORD_WITH_ATLEAST_ONE_UPPER_CASE_PATTERN, userPassword)))
                out.println("<font color=red>Enter Minimum 1 UpperCase Character.</font>");
            else if (!(Pattern.matches(VALID_PASSWORD_WITH_ATLEAST_ONE_NUMERIC_NUMBER, userPassword)))
                out.println("<font color=red>Enter minimum 1 Numeric Number</font>");
            else if (!(Pattern.matches(VALID_PASSWORD_PATTERN, userPassword)))
                out.println("<font color=red>Password Should Exactly 1 Special Character.</font>");
            else
                out.println("<font color=red>Enter 10 Digit Mobile Number.</font>");
            requestDispatcher.include(request, response);
        } else {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("userName", name);
            httpSession.setAttribute("password", userPassword);
            httpSession.setAttribute("email", email);
            httpSession.setAttribute("mobileNo", mobileNo);
            request.getRequestDispatcher("registrationSuccess.jsp").forward(request, response);
        }
    }
}
