package com.patikadev.Model;

import com.patikadev.Helper.DBConnector;
import com.patikadev.Helper.Helper;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Content {
    private int id;
    private String title;
    private String clarify;
    private String youtubeLink;
    private int educator_id;
    private int course_id;

    private Course course;
    private User educator;

    public Content() {
    }

    public Content(int id, String title, String clarify, String youtubeLink, int educator_id, int course_id) {
        this.id = id;
        this.title = title;
        this.clarify = clarify;
        this.youtubeLink = youtubeLink;
        this.educator_id = educator_id;
        this.course_id = course_id;
        this.course=Course.getFetch(course_id);
        this.educator=User.getFetch(educator_id);
    }
    public static ArrayList<Content> getList(){
        ArrayList<Content> contentList=new ArrayList<>();
        String query="SELECT * FROM content";
        try {
            Statement st= DBConnector.getInstance().createStatement();
            ResultSet rs=st.executeQuery(query);
            Content obj;
            while (rs.next()){
                obj=new Content();
                obj.setId(rs.getInt("id"));
                obj.setTitle(rs.getString("title"));
                obj.setClarify(rs.getString("clarify"));
                obj.setYoutubeLink(rs.getString("yt_link"));
                obj.setEducator_id(rs.getInt("educator_id"));
                obj.setCourse_id(rs.getInt("course_id"));
                contentList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return contentList;
    }

    public static boolean add(int educator_id, int course_id, JTextField fldContTitle) {
        String query="INSERT INTO content (educator_id , course_id , title , clarify , yt_link) VALUES (?,?,?,'Eğitmenin doldurması bekleniyor','Eğitmenin doldurması bekleniyor')";
        try {
            PreparedStatement pr=DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,educator_id);
            pr.setInt(2,course_id);
            pr.setString(3,fldContTitle.getText());
            return pr.executeUpdate()!=-1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean update(int contId, String contEduName, String contCourseName, String contTitle, String contClarify, String contYtLink) {
        User educator=new User();
        String query="UPDATE content SET educator_id=?, course_id=? ,title=?, clarify=?, yt_link=? WHERE id=?";
        educator=User.getFetchEdu(contEduName);
        Course course=Course.getFetchWithName(contCourseName);
        System.out.println(educator.getName());
        System.out.println(course.getName());
        if (educator.getType().equals("educator")){
            Helper.showMsg("Öğretmen bulunamadı !");
            return false;
        }
        try {
            PreparedStatement pr=DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,educator.getId());
            pr.setInt(2,course.getId());
            pr.setString(3,contTitle);
            pr.setString(4,contClarify);
            pr.setString(5,contYtLink);
            pr.setInt(6,contId);
            return pr.executeUpdate()!=-1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean delete(int id) {
        String query="DELETE FROM content WHERE id=?";

        try {
            PreparedStatement pr=DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,id);
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClarify() {
        return clarify;
    }

    public void setClarify(String clarify) {
        this.clarify = clarify;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public int getEducator_id() {
        return educator_id;
    }

    public void setEducator_id(int educator_id) {
        this.educator_id = educator_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getEducator() {
        return educator;
    }

    public void setEducator(User educator) {
        this.educator = educator;
    }


}
