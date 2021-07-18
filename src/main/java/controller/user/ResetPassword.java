package controller.user;

import model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/user/resetPassword")
public class ResetPassword extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user/updatePassword.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String answer = request.getParameter("answer");
        String pass = request.getParameter("pass");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (Objects.nonNull(user) && user.getAnswer().equals(answer)) {
            user.setPass(pass);
            user.updatePassword();
            response.sendRedirect("/users");
        } else {
            request.setAttribute("couldNotUpdate", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user/forget.jsp");
            dispatcher.forward(request, response);
        }
    }
}
