package com.patikadev.Model;

import com.patikadev.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Quiz {
    private int id;
    private int cont_id;
    private String question;

    private Content content;

    public Quiz() {
    }

    public Quiz(int id, int cont_id, String question) {
        this.id = id;
        this.cont_id = cont_id;
        this.question = question;
        this.content=Content.getList().get(cont_id);

    }
    //+getlist  +add +update +delete


    public static boolean update(int id, int contID,String question){
        String query="UPDATE quiz SET cont_id = ? , question = ? WHERE id = ?";

        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,contID);
            pr.setString(2,question);
            pr.setInt(3,id);
            return pr.executeUpdate()!= -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static boolean delete(int id){
        String query="DELETE FROM quiz WHERE id = ?";
        try {
            PreparedStatement pr= DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            return pr.executeUpdate() !=-1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean add(int contID,String question){
        String query="INSERT INTO quiz (cont_id , question) VALUES (?,?)";


        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,contID);
            pr.setString(2,question);
            return pr.executeUpdate() !=-1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<Quiz> quizList(){
        ArrayList<Quiz> quizArrayList=new ArrayList<>();
        String query="SELECT * FROM quiz";
        try {
            Statement st= DBConnector.getInstance().createStatement();
            ResultSet rs=st.executeQuery(query);
            Quiz obj;
            while (rs.next()){
            obj=new Quiz();
            obj.setId(rs.getInt("id"));
            obj.setCont_id(rs.getInt("cont_id"));
            obj.setQuestion(rs.getString("question"));
            quizArrayList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return quizArrayList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCont_id() {
        return cont_id;
    }

    public void setCont_id(int cont_id) {
        this.cont_id = cont_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
