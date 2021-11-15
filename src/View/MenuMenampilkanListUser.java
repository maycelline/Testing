package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.*;
import Controller.*;

public class MenuMenampilkanListUser {
    public MenuMenampilkanListUser(){
        Controller c=new Controller();
        Method m=new Method();
        JFrame frame = new DefaultComponentSetting().defaultFrame();

        //panel
        JPanel panel= new JPanel();
        panel.setSize(600, 800);
        panel.setBackground(new Color(201, 228, 197));

        //init isi data
        c.getAllUsers();
        String [][] dataUser=m.konversiListToArray(c.users);

        //init kolom
        String column[]={"Tingkatan","Id User","Nama Depan","Nama Belakang","email"};

        //tabel data
        JTable tabelDataUser=new JTable(dataUser,column);
        tabelDataUser.setBounds(30,40,400,600);
        JScrollPane sp=new JScrollPane(tabelDataUser);
        panel.add(sp);

        //button back
        JButton back = new JButton("Kembali ke Main Menu");
        back.setBounds(400,20,200,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new BerandaAdmin(admin);
                frame.dispose();
            }
        });
        panel.add(back);

        //initialize panel dan frame
        panel.setLayout(null);
        panel.setVisible(true);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
