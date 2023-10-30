package com.patikadev.Model;

import com.patikadev.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student extends User{
    private int course_id;
    private int stu_id;
    private int cont_id;
    private Course course;
    private Content content;
    public Student() {
    }

    public Student(int id, String name, String Uname, String pass, String type) {
        super(id, name, Uname, pass, type);
        this.stu_id=id;
        this.course=Course.getFetch(course_id);

    }

    public static boolean joinCourse(int stu_id,int course_id){
        String query="INSERT INTO student(stu_id,course_id) VALUES (?,?)";

        try {
            PreparedStatement pr= DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,stu_id);
            pr.setInt(2,course_id);
            return pr.executeUpdate()!=-1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public  int getCourse_id(int stu_id) {
        int id;
        String query = "SELECT * FROM student WHERE stu_id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, stu_id);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                id=rs.getInt("course_id");
                System.out.println(id);
                return id;

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    public int getContent_id(int cont_id){
        String query="SELECT * FROM quiz WHERE cont_id=?";
        int contentId = 0;
        try {
            PreparedStatement pr=DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1,cont_id);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {

                contentId = rs.getInt("cont_id");

            }
            return contentId;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }


}
