package com.patikadev.Model;

import com.patikadev.Helper.DBConnector;

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
