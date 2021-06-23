package controller.status;

import model.status.Status;
import model.user.Repository;
import model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/status/change")
public class ChangeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //requestオブジェクトの文字エンコーディング
        request.setCharacterEncoding("UTF-8");

        //statusをどの向きに変えたいかを取得
        Integer hope = Integer.parseInt(request.getParameter("hope"));

        RequestDispatcher dispatcher;
        if (hope==1){
            ArrayList<User> isWorkingUsers = Repository.selectUsersIsWorkingNotActive();
            request.setAttribute("isWorkingUsers", isWorkingUsers);

            ArrayList<Status> statuses = model.status.Repository.indexStatuses();
            request.setAttribute("statuses", statuses);

            dispatcher = request.getRequestDispatcher("/WEB-INF/status/active.jsp");
        } else {
            ArrayList<User> activeUsers = Repository.selectActiveUsers();
            request.setAttribute("activeUsers", activeUsers);

            dispatcher = request.getRequestDispatcher("/WEB-INF/status/inactive.jsp");
        }
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //requestオブジェクトの文字エンコーディング
        request.setCharacterEncoding("UTF-8");

        Integer usersId = Integer.parseInt(request.getParameter("usersId"));
        Integer statuesId = Integer.parseInt(request.getParameter("statusesId"));

        Repository.changeStatus(usersId, statuesId);

        response.sendRedirect("/status/index");
    }
}
