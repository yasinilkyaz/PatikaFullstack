package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;

import javax.swing.*;

public class StudentGUI extends JFrame{
    private JPanel wrapper;

    public StudentGUI(){
        add(wrapper);
        setSize(400,400);
        setLocation(Helper.screenCenter("x",getSize()),Helper.screenCenter("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
    }

}
/*
Öğrenciler sisteme giriş yaptıklarında, aynı sizlerinde yaptığı gibi patikalar üzerinden derslere erişmeliler.
Öğrenciler tüm bu işleri arayüz üzerinden yapmalıdır.
Öğrenciler patikalar üzerinden BİR derse kayıt olmalıdır.
Öğrenciler kayıt oldukları derse ait içeriklere ulaşabilir ve görüntüleyebilir. (Youtube videosunu proje içerisine gömmeye gerek yoktur sadece link verilebilir)
Öğrenciler derslere ait içerikleri değerlendirebilir ve yorum yapabilir.
Öğrenciler derslere ait quizleri çözebilir.
 */