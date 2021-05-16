package GiaoDien.GiaoDienChinh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThongBao extends JFrame {
    private JLabel lbTrong;
    public static JLabel lbThongBao;
    public static JPanel tb;

    public ThongBao(String thongBao){
        setTitle("Thông báo từ hệ thống");
        setSize(450, 200);
        lbThongBao = new JLabel(thongBao);
        dungGiaoDien();
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void dungGiaoDien(){
        JPanel khung = new JPanel(new FlowLayout(1, 50, 20));
//        Panel Thong Bao
        tb = new JPanel();
        tb.add(lbTrong = new JLabel(" "));
        lbTrong.setPreferredSize(new Dimension(450, 30));
        tb.add(lbThongBao);
        lbThongBao.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        khung.add(tb);
        tb.setPreferredSize(new Dimension(450, 100));
        add(khung);
    }

}
