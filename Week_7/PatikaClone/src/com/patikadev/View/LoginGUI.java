package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Operator;
import com.patikadev.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame{
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JTextField fld_user_uname;
    private JPasswordField fld_user_pass;
    private JButton btn_login;

    public LoginGUI(){
        add(wrapper);
        setSize(400,400);
        setLocation(Helper.screenCenter("x",getSize()),Helper.screenCenter("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        btn_login.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_user_uname)||Helper.isFieldEmpty(fld_user_pass)){
                Helper.showMsg("fill");
            }else {
                User u=new User();
                u=User.getFetch(fld_user_uname.getText(),fld_user_pass.getText());
                if (u==null){
                    Helper.showMsg("Kullanıcı Bulunamadı !");
                }else {

                    switch (u.getType()){
                        case "operator":
                            System.out.println(u.getType());
                            OperatorGUI opGUI=new OperatorGUI((Operator) u);
                            break;
                        case "educator":
                            EducatorGUI educatorGUI=new EducatorGUI();
                            break;
                        case "student":
                            StudentGUI studentGUI=new StudentGUI();
                            break;
                    }
                    dispose();
                }
            }
        });
    }

    public static void main(String[] args) {
        Helper.setLayout();
        LoginGUI loginGUI=new LoginGUI();
    }
}
/*
Giriş Ekranına Ekleme


Öğrenciler giriş ekranı sırasında üyelikleri yok ise sisteme kayıt olabilirler.


Kayıt ol ekranı tasarlanmalı ve sadece öğrenciler sisteme kayıt yapabilmeli.


Sistemdeki operatörleri yazılımcı (Yani sizler) eklemeli, eğitmenleride sadece operatörler ekleyebilmeli.
 */