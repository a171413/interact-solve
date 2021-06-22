package controller.user;


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
import java.util.ArrayList;

@WebServlet("/users/detail")
public class DetailServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer usersId = Integer.parseInt(request.getParameter("usersId"));
        String usersName = request.getParameter("usersName");

        ArrayList<Consultation> consultations = Consultation.selectConsultationsByUserId(usersId);
        request.setAttribute("userName", usersName);
        request.setAttribute("consultations", consultations);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user/detail.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
