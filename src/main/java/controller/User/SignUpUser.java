package controller.User;

import model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/signup")
public class SignUpUser extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //signupにGETリクエストがきたら/WEB-INF/user/sighUp.jspへ
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user/signUp.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //signupにPOSTリクエストがきたら＝リクエストパラメータが送信されたら
        //requestオブジェクトの文字エンコーディング
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String mail = request.getParameter("mail");
        String pass = request.getParameter("pass");

        //requestオブジェクトから登録情報の取り出し
        User user = new User(
                null,
                name,
                mail,
                pass,
                false,
                null,
                null
        );

        user.insertUser();

        //リクエストスコープにインスタンスを保存
        //"user"という名前でuserインスタンスを保存
        request.setAttribute("user",user);

        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user/new.jsp");
        dispatcher.forward(request, response);

    }
}
