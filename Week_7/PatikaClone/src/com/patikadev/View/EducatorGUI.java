package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Helper.Item;
import com.patikadev.Model.*;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class EducatorGUI extends JFrame{
    private JPanel wrapper;
    private JPanel pnl_education_list;
    private JScrollPane scrl_cont_list;
    private JTable tbl_cont_list;
    private JTextField fld_cont_title;
    private JComboBox cmb_cont_educator;
    private JComboBox cmb_cont_course;
    private JButton btn_cont_add;
    private JTextField fld_cont_id;
    private JButton btn_cont_delete;
    private JLabel lbl_welcome;
    private JTextField fld_edu_id;
    private JTabbedPane tab_operator;
    private JPanel pnl_quiz_list;
    private JScrollPane scrl_quiz_list;
    private JTable tbl_quiz_list;
    private JTextField fld_quiz_id;
    private JButton btn_quiz_delete;
    private JTextField fld_quiz_contID;
    private JTextField fld_quiz_question;
    private JButton btn_quiz_add;
    private Object[] row_cont_list;
    private DefaultTableModel mdl_content_list;
    private Object[] row_quiz_list;
    private DefaultTableModel mdl_quiz_list;
    private final Educator educator;


    public EducatorGUI(Educator educator){
        try {
            Helper.setLayout();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        this.educator = educator;
        add(wrapper);
        setSize(1000, 500);
        setLocation(Helper.screenCenter("x", getSize()), Helper.screenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
        lbl_welcome.setText("Hoşgeldin : " + educator.getName());

        fld_edu_id.setText(String.valueOf(educator.getId()));
        mdl_content_list=new DefaultTableModel();
        Object[] col_cont_list = {"ID", "Eğitmen", "Dersler", "Başlık", "Açıklama","Youtube"};
        mdl_content_list.setColumnIdentifiers(col_cont_list);
        loadCourseCombo();
        row_cont_list=new Object[col_cont_list.length];
        tbl_cont_list.setModel(mdl_content_list);
        loadContentModel();
        btn_cont_add.addActionListener(e -> {

            Item courseItem=(Item) cmb_cont_course.getSelectedItem();
            if (Helper.isFieldEmpty(fld_cont_title)){
                Helper.showMsg("fill");
            }else {
                if(Content.add(Integer.parseInt(fld_edu_id.getText()),courseItem.getKey(),fld_cont_title)){
                    Helper.showMsg("done");
                    loadContentModel();
                    fld_cont_title.setText(null);
                }
            }
        });
        //seçilen satırın id
        tbl_cont_list.getSelectionModel().addListSelectionListener(e -> {
            try {
                String select_cont_id = tbl_cont_list.getValueAt(tbl_cont_list.getSelectedRow(), 0).toString();
                fld_cont_id.setText(select_cont_id);
            }catch (Exception exp){
                System.out.println(exp.getMessage());
            }
        });

        tbl_cont_list.getModel().addTableModelListener(e -> {
            if (e.getType()== TableModelEvent.UPDATE){
                int cont_id=Integer.parseInt(tbl_cont_list.getValueAt(tbl_cont_list.getSelectedRow(),0).toString());
                String cont_edu_name=tbl_cont_list.getValueAt(tbl_cont_list.getSelectedRow(),1).toString();
                String cont_course_name=tbl_cont_list.getValueAt(tbl_cont_list.getSelectedRow(),2).toString();
                String cont_title=tbl_cont_list.getValueAt(tbl_cont_list.getSelectedRow(),3).toString();
                String cont_clarify=tbl_cont_list.getValueAt(tbl_cont_list.getSelectedRow(),4).toString();
                String cont_ytLink=tbl_cont_list.getValueAt(tbl_cont_list.getSelectedRow(),5).toString();
                if (Content.updateEdu(cont_id,cont_edu_name,cont_course_name,cont_title,cont_clarify,cont_ytLink)){
                    Helper.showMsg("done");
                    loadContentModel();
                }
            }
        });
        btn_cont_delete.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_cont_id)){
                Helper.showMsg("fill");
            }else {
                if (Helper.confirm("sure")){
                    int cont_id=Integer.parseInt(fld_cont_id.getText());
                    if (Content.delete(cont_id)){
                        Helper.showMsg("done");
                        loadContentModel();
                        fld_cont_id.setText(null);
                    }else {
                        Helper.showMsg("error");
                    }
                }
            }
        });
        // quiz

        mdl_quiz_list = new DefaultTableModel();
        Object[] col_quiz_list={"ID","İçerik id","Soru"};
        mdl_quiz_list.setColumnIdentifiers(col_quiz_list);

        row_quiz_list=new Object[col_quiz_list.length];
        tbl_quiz_list.setModel(mdl_quiz_list);
        loadQuizModel();

        btn_quiz_add.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_quiz_contID)&& Helper.isFieldEmpty(fld_quiz_question)){
                Helper.showMsg("fill");
            }else {
                if (Quiz.add(Integer.parseInt(fld_quiz_contID.getText()),fld_quiz_question.getText())){
                    Helper.showMsg("done");
                    loadQuizModel();
                    fld_quiz_contID.setText(null);
                    fld_quiz_question.setText(null);
                }
            }
        });
        tbl_quiz_list.getSelectionModel().addListSelectionListener(e -> {
            try{
                String selectId=tbl_quiz_list.getValueAt(tbl_quiz_list.getSelectedRow(),0).toString();
                fld_quiz_id.setText(selectId);} catch (Exception err){
                System.out.println(err.getMessage());
            }

        });
        btn_quiz_delete.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_quiz_id)){
                Helper.showMsg("fill");
            }else {
                if (Quiz.delete(Integer.parseInt(fld_quiz_id.getText()))){
                    Helper.showMsg("done");
                    loadQuizModel();
                    fld_quiz_id.setText(null);
                }
            }
        });
        //update
        tbl_quiz_list.getModel().addTableModelListener(e -> {
            if (e.getType()==TableModelEvent.UPDATE){
                int quiz_id=Integer.parseInt(tbl_quiz_list.getValueAt(tbl_quiz_list.getSelectedRow(),0).toString());
                int quiz_cont_id=Integer.parseInt(tbl_quiz_list.getValueAt(tbl_quiz_list.getSelectedRow(),1).toString());
                String quiz_question=tbl_quiz_list.getValueAt(tbl_quiz_list.getSelectedRow(),2).toString();
                if (Quiz.update(quiz_id,quiz_cont_id,quiz_question)){
                    Helper.showMsg("done");
                    loadQuizModel();
                }
            }
        });
    }
    public void loadContentModel(){
        DefaultTableModel clearModel = (DefaultTableModel) tbl_cont_list.getModel();
        clearModel.setRowCount(0);
        for (Content obj:Content.getList()){
            int i=0;
            if(obj.getEducator_id()==this.educator.getId()){
            row_cont_list[i++]=obj.getId();
            row_cont_list[i++]= User.getFetch(obj.getEducator_id()).getName();
            row_cont_list[i++]= Course.getFetch(obj.getCourse_id()).getName();
            row_cont_list[i++]=obj.getTitle();
            row_cont_list[i++]=obj.getClarify();
            row_cont_list[i++]=obj.getYoutubeLink();
            mdl_content_list.addRow(row_cont_list);}
        }
    }
    public void loadCourseCombo(){
        cmb_cont_course.removeAllItems();
        for (Course obj:Course.getList()){
            cmb_cont_course.addItem(new Item(obj.getId(), obj.getName()));
        }
    }
    private void loadQuizModel(){
        DefaultTableModel clearModel=(DefaultTableModel) tbl_quiz_list.getModel();
        clearModel.setRowCount(0);
        int i;
        for (Quiz obj:Quiz.quizList()){
            i=0;
            row_quiz_list[i++]=obj.getId();
            row_quiz_list[i++]=obj.getCont_id();
            row_quiz_list[i++]=obj.getQuestion();
            mdl_quiz_list.addRow(row_quiz_list);
        }
    }
}


/*   TODO
Eğitmenler Operatörler tarafından kendilerine atanan eğitimleri görüp listeleyebilirler.  düzenleme veya silme yetkileri bulunmaz. Başka eğitmenlere ait eğitimleride göremezler.
Eğitmenler içerik ekleyip kendilerine ait olan içerikleri düzenleyip, silebilirler ve listeleyebilirler.
Eğitmen tüm bu işleri arayüz üzerinden yapmalıdır.
İçeriklerin özellikleri :
İçerik Başlığı
İçerik Açıklaması
İçerik Youtube Linki
İçerik Quiz Soruları
İçeriğin ait olduğu ders bilgisi
Quiz soruları eğitmen panelinden eklenecektir ve soruyu eklerken hangi içeriğe ait olduğu seçilmelidir.
İçerik listeleme ekranında, derslere göre ve içerik başlığına göre filtreleme yapılabilmeli.
 */