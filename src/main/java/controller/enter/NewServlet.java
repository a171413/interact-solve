package controller.enter;

import model.enter.Enter;
import model.enter.Repository;
import model.status.Status;
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

@WebServlet("/enter/new")
public class NewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //requestオブジェクトの文字エンコーディング
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");
        if(Repository.checkEnter(user)){ //入室してたらお悩み一覧に飛ばす
            response.sendRedirect("/enter/change");
        }

        else{
            request.setCharacterEncoding("UTF-8");

            ArrayList<Status> statuses = model.status.Repository.indexStatuses();
            request.setAttribute("statuses", statuses);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/enter/new.jsp");
            dispatcher.forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //requestオブジェクトの文字エンコーディング
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");
        Integer statuesId = Integer.parseInt(request.getParameter("statusesId"));

        Enter enter = new Enter(
                null,
                user.getId(),
                statuesId,
                null,
                null
        );

        Repository.insertEnter(enter);

        response.sendRedirect("/users");
    }
}
