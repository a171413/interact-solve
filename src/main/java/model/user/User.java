package model.user;

import model.Default;
import model.status.Status;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class User extends Default {
    public final static String currentUserKey = "currentUser";

    private String name;
    private String mail;
    private String pass;
    private Boolean isWorking;
    private Integer statusesId;
    //statusの値はそれぞれ以下の状態を表す
    //0. 部屋にいないor手続きしてない
    //1. 話しかけてください
    //2. 相談に乗ってください
    //3. 話しかけないでください
    private Status nowStatus;

    //新規登録時コンストラクタ
    public User(
            Integer id,
            String name,
            String mail,
            String pass,
            Boolean isWorking,
            Integer statusesId,
            Timestamp createdAt,
            Timestamp updatedAt,
            Status nowStatus
    ){
        super(id, createdAt, updatedAt);
        //親クラスのコンストラクタを呼び出す
        this.name = name;
        this.mail = mail;
        this.pass= pass;
        this.isWorking = isWorking;
        this.statusesId = statusesId;
        this.nowStatus = nowStatus;
    }

    //setメソッド
    public void setName(String name) { this.name = name; }
    public void setMail(String mail) { this.mail = mail; }
    public void setPass(String pass) { this.pass = pass; }
    public void setIsWorking(Boolean isWorking) { this.isWorking = isWorking; }
    public void setStatusesId(Integer statusesId) { this.statusesId = statusesId; }
    public void setNowStatus(Status nowStatus) { this.nowStatus = nowStatus; }

    //getメソッド
    public String getName() { return this.name; }
    public String getMail() { return this.mail; }
    public String getPass() { return this.pass; }
    public Boolean getIsWorking() { return this.isWorking; }
    public Integer getStatusesId() { return this.statusesId; }
    public Status getNowStatus() { return this.nowStatus; }

    //controller/User/SignUpUser.javaからの呼び出し
    public void insertUser(){
        this.hashPassword();
        Repository.insertUser(this);
    }

    //User認証の機構
    public boolean authenticateUser(HttpServletRequest request) {
        //Mailをもとにユーザーが存在するか調べる
        User persistedUser = Repository.selectUserByMail(this.mail);
        if (persistedUser == null) {    //Mailをもつユーザーがいなければ
            return false;
        }
        //ここからはMailをもつユーザーがいればの話
        this.hashPassword();    //入力されたパスワードをハッシュ化
        if (this.pass.equals(persistedUser.pass)) { //ハッシュ化したものとDBのパスワードが一致すれば
            //ログインしているかどうかの情報を切り替える
            if(!persistedUser.isWorking) {
                persistedUser.isWorking = true;
                Repository.switchIsWorking(persistedUser);
            }
            HttpSession session = request.getSession(); //セッションを作って
            session.setAttribute(currentUserKey, persistedUser);    //セッションスコープにユーザー情報保存
            return true;
        } else {    //パスワードが違ったらfalseを返す
            return false;
        }
    }

    //ハッシュ化
    public void hashPassword(){
        this.pass=getHash(this.mail,this.pass);
    }

    private String getHash(String mail, String password) {
        final String HASH_ALGORITHM = "SHA-256";
        final int STRETCH_COUNT = 1024;
        final String FIXED_SALT = "vBjRGHZ6awqJL9JDQuNftAzaPSnHszQN";

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(HASH_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String salt = mail + FIXED_SALT;
        messageDigest.update(salt.getBytes());
        byte[] hashed = messageDigest.digest(password.getBytes());

        for (int i = 0; i < STRETCH_COUNT; i++) {
            hashed = messageDigest.digest(hashed);
        }
        return getHexString(hashed);
    }

    private String getHexString(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            stringBuffer.append(Integer.toHexString((bytes[i] >> 4) & 0x0f));
            stringBuffer.append(Integer.toHexString(bytes[i] & 0x0f));
        }
        return stringBuffer.toString();
    }

    public static User getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (User) session.getAttribute(currentUserKey);
    }

    //セッションスコープからcurrentUserKeyを取り除く
    public static void logoutUser(HttpServletRequest request) {
        HttpSession session = request.getSession();

        User currentUser = (User) session.getAttribute(currentUserKey);
        if(currentUser.isWorking) {
            currentUser.isWorking = false;
            Repository.switchIsWorking(currentUser);
        }
        Repository.changeStatus(currentUser.getId(), 1);

        session.removeAttribute(currentUserKey);
    }
}
