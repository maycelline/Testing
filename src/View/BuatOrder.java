package View;

import Model.Constant;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class BuatOrder {
    JFrame frame;
    JPanel panelPengirim, panelPenerima, panelBarang;
    JLabel labelPengirim, labelPenerima, labelBarang, labelNamaPenerima, labelNamaPengirim, labelAlamatPenerima, labelAlamatPengirim, labelNomorHPPenerima, labelNomorHPPengirim, labelTipeBarang, labelTotalBarang, labelBeratBarang;
    JButton buttonOrder;

    public BuatOrder(){
        //Panel Pengirim
        panelPengirim = new JPanel();
        panelPengirim.setBounds(50,50,240,400);
        panelPengirim.setBorder(new Border() {
            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {

            }

            @Override
            public Insets getBorderInsets(Component c) {
                return null;
            }

            @Override
            public boolean isBorderOpaque() {
                return false;
            }
        });

        //Frame
        frame = new JFrame(Constant.applicationName+" - Order");
        frame.setSize(600,800);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.add(panelPengirim);
        frame.setVisible(true);
    }
}