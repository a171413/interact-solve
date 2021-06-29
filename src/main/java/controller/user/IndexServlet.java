package controller.user;

import model.consultation.Consultation;
import model.consultation.Repository;
import model.status.Status;
import model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/users")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ログインに成功→マイページに行くので自分の悩みを取得しrequestオブジェクトに保存
        ArrayList<Consultation> myConsultations = Repository.selectConsultationsByUserId(model.user.Repository.getCurrentUser(request).getId());
        request.setAttribute("myConsultations", myConsultations);

        ArrayList<Integer> enters = model.enter.Repository.indexEnters();
        request.setAttribute("enters", enters);

        ArrayList<Status> statuses = model.status.Repository.indexStatuses();
        request.setAttribute("statuses", statuses);

        //フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user/index.jsp");
        dispatcher.forward(request, response);
    }
}
