package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;

import javax.swing.*;

public class EducatorGUI extends JFrame{
    private JPanel wrapper;

    public EducatorGUI(){
        add(wrapper);
        setSize(400,400);
        setLocation(Helper.screenCenter("x",getSize()),Helper.screenCenter("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
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