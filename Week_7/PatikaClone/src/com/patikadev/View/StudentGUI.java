package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentGUI extends JFrame{
    private JPanel wrapper;
    private JTabbedPane tabbedPane1;
    private JButton btn_patika_join;
    private JLabel lbl_welcome;
    private JPanel pnl_course_list;
    private JScrollPane scrl_course_list;
    private JTable tbl_course_list;
    private JPanel pnl_course_add;
    private JButton btn_course_join;
    private JTextField fld_course_name;
    private JPanel pnl_education_list;
    private JScrollPane scrl_cont_list;
    private JTable tbl_cont_list;
    private JPanel pnl_quiz_list;
    private JScrollPane scrl_quiz_list;
    private JTable tbl_quiz_list;
    private JTextField fld_quiz_comment;
    private JTextField fld_quiz_contID;
    private JTextField fld_quiz_answer;
    private JButton btn_answer_add;
    private Student student;
    private DefaultTableModel mdl_course_list;
    private Object[] row_course_list;
    private Object[] row_cont_list;
    private Object[] row_quiz_list;
    private DefaultTableModel mdl_content_list;
    private DefaultTableModel mdl_quiz_list;
    public StudentGUI(Student student){
        try {
            Helper.setLayout();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        this.student = student;
        student.setCourse_id(student.getCourse_id(student.getId()));
        add(wrapper);
        setSize(1000, 500);
        setLocation(Helper.screenCenter("x", getSize()), Helper.screenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
        lbl_welcome.setText("Hoşgeldin : " + student.getName());
        mdl_content_list=new DefaultTableModel();
        mdl_course_list = new DefaultTableModel();
        Object[] col_courseList = {"ID", "Ders Adı", "Programlama Dili", "Patika", "Eğitmen"};
        mdl_course_list.setColumnIdentifiers(col_courseList);
        row_course_list = new Object[col_courseList.length];

        tbl_course_list.setModel(mdl_course_list);
        tbl_course_list.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_course_list.getTableHeader().setReorderingAllowed(false);
        loadCourseModel();

        mdl_content_list=new DefaultTableModel();
        Object[] col_cont_list = {"ID", "Eğitmen", "Dersler", "Başlık", "Açıklama","Youtube"};
        mdl_content_list.setColumnIdentifiers(col_cont_list);

        row_cont_list=new Object[col_cont_list.length];
        tbl_cont_list.setModel(mdl_content_list);
        loadContentModel();
        tbl_course_list.getSelectionModel().addListSelectionListener(e -> {
            try {
                String selectID=tbl_course_list.getValueAt(tbl_course_list.getSelectedRow(),0).toString();
                String selectCourseName=tbl_course_list.getValueAt(tbl_course_list.getSelectedRow(),3).toString();
                fld_course_name.setText(selectCourseName);
            }catch (Exception err){
                System.out.println(err.getMessage());
            }
        });

        btn_course_join.addActionListener(e -> {
        if (Helper.isFieldEmpty(fld_course_name)){
            Helper.showMsg("Seçim yapınız");
        }else {
            if (Student.joinCourse(student.getId(), Integer.parseInt(tbl_course_list.getValueAt(tbl_course_list.getSelectedRow(),0).toString()))){
             Helper.showMsg("done");

                student.setCourse_id( Integer.parseInt(tbl_course_list.getValueAt(tbl_course_list.getSelectedRow(),0).toString()));
                loadContentModel();
            }
        }
        });

        //Quiz
        mdl_quiz_list=new DefaultTableModel();
        Object[] col_quiz_list={"ID","İçerik id","Soru"};
        mdl_quiz_list.setColumnIdentifiers(col_quiz_list);

        row_quiz_list=new Object[col_quiz_list.length];
        tbl_quiz_list.setModel(mdl_quiz_list);
        loadQuizModel();

        tbl_quiz_list.getSelectionModel().addListSelectionListener(e -> {
            try {
                String select_user_id = tbl_quiz_list.getValueAt(tbl_quiz_list.getSelectedRow(), 0).toString();
                fld_quiz_contID.setText(select_user_id);
            } catch (Exception exp) {
            }
        });
        btn_answer_add.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_quiz_contID)){
                Helper.showMsg("Seçim yapınız");
            }else {
                if (Answer.add(Integer.parseInt(fld_quiz_contID.getText()),student.getId(),fld_quiz_answer.getText(),fld_quiz_comment.getText())){
                    Helper.showMsg("done");
                }
            }
        });
    }
    private void loadCourseModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_course_list.getModel();
        clearModel.setRowCount(0);
        int i = 0;
        for (Course obj : Course.getList()) {
            i = 0;
            row_course_list[i++] = obj.getId();
            row_course_list[i++] = obj.getName();
            row_course_list[i++] = obj.getLang();
            row_course_list[i++] = obj.getPatika().getName();
            row_course_list[i++] = obj.getEducator().getName();
            mdl_course_list.addRow(row_course_list);
        }
    }
    public void loadContentModel(){
        DefaultTableModel clearModel = (DefaultTableModel) tbl_cont_list.getModel();
        clearModel.setRowCount(0);
        for (Content obj:Content.getList()){
            int i=0;
            if(obj.getCourse_id()==this.student.getCourse_id(student.getId())){
                row_cont_list[i++]=obj.getId();
                row_cont_list[i++]= User.getFetch(obj.getEducator_id()).getName();
                row_cont_list[i++]= Course.getFetch(obj.getCourse_id()).getName();
                row_cont_list[i++]=obj.getTitle();
                row_cont_list[i++]=obj.getClarify();
                row_cont_list[i++]=obj.getYoutubeLink();
                mdl_content_list.addRow(row_cont_list);}
        }
    }

    private void loadQuizModel(){
        DefaultTableModel clearModel=(DefaultTableModel) tbl_quiz_list.getModel();
        clearModel.setRowCount(0);

        int i;
        for (Quiz obj:Quiz.quizList()){

                i = 0;
                row_quiz_list[i++] = obj.getId();
                row_quiz_list[i++] = obj.getCont_id();
                row_quiz_list[i++] = obj.getQuestion();
                mdl_quiz_list.addRow(row_quiz_list);

        }
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