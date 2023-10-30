package com.patikadev.Model;

import com.patikadev.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Answer {
    private int id;
    private int quiz_id;
    private int stu_id;
    private String answer;
    private String comment;

    public Answer(int id, int quiz_id, int stu_id, String answer, String comment) {
        this.id = id;
        this.quiz_id = quiz_id;
        this.stu_id = stu_id;
        this.answer = answer;
        this.comment = comment;
    }

    public Answer() {
    }
    public static boolean add(int quiz_id,int stu_id,String answer,String comment){
        String query="INSERT INTO answer (quiz_id , stu_id , answer , comment) VALUES (?,?,?,?)";

        try {
            PreparedStatement pr= DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,quiz_id);
            pr.setInt(2,stu_id);
            pr.setString(3,answer);
            pr.setString(4,comment);
            return pr.executeUpdate() !=-1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
