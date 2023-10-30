package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Educator;
import com.patikadev.Model.Operator;
import com.patikadev.Model.Student;
import com.patikadev.Model.User;

import javax.swing.*;

public class LoginGUI extends JFrame{
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JTextField fld_user_uname;
    private JPasswordField fld_user_pass;
    private JButton btn_login;
    private JTextField fld_user_name_register;
    private JButton btn_user_register;
    private JTextField fld_user_uname_register;
    private JTextField fld_user_pass_register;

    public LoginGUI(){
        add(wrapper);
        setSize(400,800);
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
                            OperatorGUI opGUI=new OperatorGUI((Operator) u);
                            break;
                        case "educator":
                            EducatorGUI educatorGUI=new EducatorGUI((Educator) u);
                            break;
                        case "student":
                            StudentGUI studentGUI=new StudentGUI((Student) u);
                            break;
                    }
                    dispose();
                }
            }
        });
        btn_user_register.addActionListener(e -> {

                String name = fld_user_name_register.getText();
                String uname = fld_user_uname_register.getText();
                String pass = fld_user_pass_register.getText();

                if (User.register(name, uname, pass)) {
                    Helper.showMsg("done");
                    fld_user_name_register.setText(null);
                    fld_user_uname_register.setText(null);
                    fld_user_pass_register.setText(null);
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