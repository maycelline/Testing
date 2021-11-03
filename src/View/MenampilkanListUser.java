package View;

import javax.swing.*;
import java.awt.*;
import Model.*;
import Controller.*;

public class MenampilkanListUser {
    public MenampilkanListUser(){
        Controller c=new Controller();
        Method m=new Method();
        //frame
        JFrame frame = new JFrame("Nama APK");
        frame.setSize(1500, 1500);

        //panel
        JPanel panel= new JPanel();
        panel.setSize(1200, 1200);
        panel.setBackground(new Color(201, 228, 197));

        //init isi data
        String [][] dataUser=m.konversiListToArray(c.users);

        //init kolom
        String column[]={"Tingkatan","Id User","Nama Depan","Nama Belakang","email"};

        //tabel data
        JTable tabelDataUser=new JTable(dataUser,column);
    }
}