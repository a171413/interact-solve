package controller.consultation;

import model.consultation.Consultation;
import model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/consultations/new")
public class NewServlet extends HttpServlet {
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/consultation/new.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //requestオブジェクトの文字エンコーディング
        request.setCharacterEncoding("UTF-8");

        String title = request.getParameter("title");
        String detail = request.getParameter("detail");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");

        Consultation consultation = new Consultation(
                null,
                title,
                detail,
                false,
                null,
                null,
                user.getId(),
                null
        );

        consultation.insertConsultation();

        //登録が完了したらリダイレクト;
        response.sendRedirect("/consultations/index");
    }
}
