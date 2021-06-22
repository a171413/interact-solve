package controller.reply;

import model.consultation.Consultation;
import model.reply.Reply;
import model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/replies/new")
public class NewServlet extends HttpServlet {
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/consultation/new.jsp");
//        dispatcher.forward(request, response);
    }
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //requestオブジェクトの文字エンコーディング
        request.setCharacterEncoding("UTF-8");

        String content = request.getParameter("content");
        Integer consultations_id = Integer.parseInt(request.getParameter("consultations_id"));

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");

        Reply reply = new Reply(
                null,
                content,
                null,
                null,
                consultations_id,
                user.getId(),
                null
        );

        reply.insertReply();

        //登録が完了したらリダイレクト;
        response.sendRedirect("/consultations/detail?id=" + consultations_id);
    }
}
