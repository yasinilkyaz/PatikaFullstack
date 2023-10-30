package com.patikadev.Model;

import com.patikadev.Helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Educator extends User{
    public Educator() {
    }

    public Educator(int id, String name, String Uname, String pass, String type) {
        super(id, name, Uname, pass, type);
    }
    public static Educator getFetchEdu(String name) {
        Educator obj = null;
        String query = "SELECT * FROM user WHERE name = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, name);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                obj = new Educator();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getNString("name"));
                obj.setUname(rs.getNString("uname"));
                obj.setPass(rs.getNString("pass"));
                obj.setType(rs.getString("type"));
                break;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return obj;
    }
}
