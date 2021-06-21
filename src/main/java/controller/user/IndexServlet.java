package controller.user;

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
//        ArrayList<User> users = User.indexUsers();
//        request.setAttribute("users",users);

        //ログインが成功したらフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user/index.jsp");
        dispatcher.forward(request, response);
    }
}
