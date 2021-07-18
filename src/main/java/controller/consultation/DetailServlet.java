package controller.consultation;

import model.consultation.Consultation;
import model.reply.Reply;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/consultation/detail")
public class DetailServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //requestオブジェクトの文字エンコーディング
        request.setCharacterEncoding("UTF-8");

        Integer id = Integer.parseInt(request.getParameter("id"));

        Consultation consultation = Consultation.selectConsultationById(id);
        if (consultation!=null){

            ArrayList<Reply> replies = Reply.selectRepliesByConsultationsId(id);

            request.setAttribute("consultation", consultation);
            request.setAttribute("replies", replies);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/consultation/detail.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("/consultation/index");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //requestオブジェクトの文字エンコーディング
        request.setCharacterEncoding("UTF-8");

    }
}
