package controller.user;

import model.question.Question;
import model.question.Repository;
import model.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

@WebServlet("/user/signup")
public class SignUpUser extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //秘密の質問一覧を取得・セット
        ArrayList<Question> questions = Repository.indexQuestions();
        request.setAttribute("questions", questions);

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
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String answer = request.getParameter("answer");
        Integer questionId = Integer.parseInt(request.getParameter("question"));

        //requestオブジェクトから登録情報の取り出し
        User user = new User(
                null,
                name,
                mail,
                pass,
                birthday,
                answer,
                null,
                null,
                questionId
        );

        user.insertUser();

        //リクエストスコープにインスタンスを保存
        //"user"という名前でuserインスタンスを保存
        request.setAttribute("user",user);

        //登録が完了したらログイン画面にリダイレクト
        response.sendRedirect("/sessions/new");
    }
}
