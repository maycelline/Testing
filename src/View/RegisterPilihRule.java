package View;

import Model.Constant;

import javax.swing.*;

public class RegisterPilihRule {
    JFrame frame;
    JPanel registerPilihRule;
    JLabel pilihRule;
    JButton registerKurir, registerPelanggan;

    public RegisterPilihRule(){
        //Panel
        registerPilihRule = new JPanel();
        registerPilihRule.setSize(600,800);
        registerPilihRule.setLayout(null);

        //Label
        pilihRule = new JLabel("Sebagai apa anda mendaftar?", SwingConstants.CENTER);
        pilihRule.setBounds(0,130,600,30);
        registerPilihRule.add(pilihRule);

        //Button Kurir
        registerKurir = new JButton("Kurir");
        registerKurir.setBounds(60, 190, 480, 40);
        registerPilihRule.add(registerKurir);

        //Button Pelanggan
        registerPelanggan = new JButton("Pelanggan");
        registerPelanggan.setBounds(60,270,480,40);
        registerPilihRule.add(registerPelanggan);

        //Frame
        frame = new JFrame(Constant.applicationName);
        frame.setSize(600,800);
        frame.setVisible(true);
        frame.add(registerPilihRule);
    }
}
