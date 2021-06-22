package controller.consultation;

import model.consultation.Consultation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/consultations/index")
public class IndexServlet extends HttpServlet {
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Consultation> consultations = Consultation.selectConsultations();
        request.setAttribute("consultations", consultations);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/consultation/index.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
