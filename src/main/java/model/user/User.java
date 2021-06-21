package model.user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;

public class User {

    private Integer id;
    private String name;
    private String mail;
    private String pass;
    private Boolean isWorking;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    //新規登録時コンストラクタ
    public User(
            Integer id,
            String name,
            String mail,
            String pass,
            Boolean isWorking,
            Timestamp createdAt,
            Timestamp updatedAt
    ){
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.pass= pass;
        this.isWorking = isWorking;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    //setメソッド
    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setMail(String mail) { this.mail = mail; }
    public void setPass(String pass) { this.pass = pass; }
    public void setIsWorking(Boolean isWorking) { this.isWorking = isWorking; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
    public void setUpdatedAt(Timestamp updatedAt) { this.updatedAt = updatedAt; }

    //getメソッド
    public Integer getId() { return this.id; }
    public String getName() { return this.name; }
    public String getMail() { return this.mail; }
    public String getPass() { return this.pass; }
    public Boolean getIsWorking() { return this.isWorking; }
    public Date getCreatedAt() { return this.createdAt; }
    public Date getUpdatedAt() { return this.updatedAt; }

    //controller/User/SignUpUser.javaからの呼び出し
    public void insertUser(){
        this.hashPassword();
        Repository.insertUser(this);
    }

    public void hashPassword(){
        this.pass=getHash(this.mail,this.pass);
    }

    private String getHash(String email, String password) {
        final String HASH_ALGORITHM = "SHA-256";
        final int STRETCH_COUNT = 1024;
        final String FIXED_SALT = "vBjRGHZ6awqJL9JDQuNftAzaPSnHszQN";

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(HASH_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String salt = email + FIXED_SALT;
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
}
