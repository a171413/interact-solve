package controller.user;

import model.question.Question;
import model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.Objects;

@WebServlet("/user/forget")
public class ForgetPassword extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user/forget.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String mail = request.getParameter("mail");
        Date birthday = Date.valueOf(request.getParameter("birthday"));

        User user = User.selectUserByMail(mail);

        if(Objects.isNull(user) || !user.getBirthday().equals(birthday)) {  //メアドまたは誕生日が一致しない時
            request.setAttribute("userIsNull", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user/forget.jsp");
            dispatcher.forward(request, response);
        }

        user = new User(
                user.getId(),
                null,
                user.getMail(),
                null,
                user.getBirthday(),
                user.getAnswer(),
                null,
                null,
                user.getQuestionId()
        );

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        //userIDから質問内容を取得
        Question question = Question.getQuestion(user.getQuestionId());
        request.setAttribute("question", question);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user/resetPassword.jsp");
        dispatcher.forward(request, response);
    }
}
