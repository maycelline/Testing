/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.KurirController;
import Model.Kurir;
import Model.Transaksi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class MenuAmbilOrderKurir {
    private JFrame frame;
    private JLabel labelMenu, labelNamaPengirim,labelAlamatPengirim, labelNamaPenerima,labelAlamatPenerima, labelKategoriBarang,
            labelBeratBarang, labelJumlahBarang, labelHPPengirim, labelHPPenerima, labelTotalBayar;
    
    private final DefaultComponentSetting GUI = new DefaultComponentSetting();
    
    private Kurir kurir;
    public MenuAmbilOrderKurir(Transaksi transaksi)
    {      
//        if(new KurirController().cekKurirLogin())
//        {
//            new MenuLogin();
//        }
        
        this.kurir = (Kurir) new Model.UserManager().getInstance().getUser();
        
        
        //Menu
        labelMenu = GUI.defaultHeadingLabel("Rincian Order");
        labelMenu.setBounds(200,25,200,50);

        //Label Keterangan
        labelKategoriBarang = GUI.defaultRegularLabel("Kategori Barang : " + transaksi.getKategori_barang());
        labelKategoriBarang.setBounds(100,100,200,40);
        
        labelBeratBarang = GUI.defaultRegularLabel("Berat Barang : " + transaksi.getBerat_barang()+ " KG");
        labelBeratBarang.setBounds(100,125,200,40);
        
        labelJumlahBarang = GUI.defaultRegularLabel("Jumlah Barang : " + transaksi.getJumlah_barang());
        labelJumlahBarang.setBounds(100,150,200,40);
        
        labelNamaPengirim = GUI.defaultRegularLabel("Nama Pengirim : " + transaksi.getNama_pengirim());
        labelNamaPengirim.setBounds(100,175,200,40);
        
        labelHPPengirim = GUI.defaultRegularLabel("No Telepon Pengirim : " + transaksi.getNoHP_pengirim());
        labelHPPengirim.setBounds(100,200,200,40);
        
        labelAlamatPengirim = GUI.defaultRegularLabel("Alamat Pengirim : " + transaksi.getAlamat_pengirim());
        labelAlamatPengirim.setBounds(100,225,200,40);
        
        labelNamaPenerima = GUI.defaultRegularLabel("Nama Penerima : " + transaksi.getNama_penerima());
        labelNamaPenerima.setBounds(100,250,200,40);
        
        labelHPPenerima = GUI.defaultRegularLabel("No Telepon Penerima : " + transaksi.getNoHP_penerima());
        labelHPPenerima.setBounds(100,275,300,40);
        
        labelAlamatPenerima = GUI.defaultRegularLabel("Alamat Penerima : " + transaksi.getAlamat_penerima());
        labelAlamatPenerima.setBounds(100,300,200,40);
        
        labelTotalBayar = GUI.defaultRegularLabel("Total Pembayaran : " + transaksi.getTotal_pembayaran());
        labelTotalBayar.setBounds(100,325,325,40);

        //Button Edit
        JButton btnEditProfile = GUI.defaultButton("Ambil Order", 20);
        btnEditProfile.setBounds(200, 600, 200, 50);
        btnEditProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ambilOrderan(transaksi.getId_transaksi());
            }
        });
        
        
        //Link Kembali
        JLabel labelKembali = GUI.defaultBackLabel();
        labelKembali.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new MenuLihatOrderKurir(kurir);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                frame.dispose();
                new MenuLihatOrderKurir(kurir);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        
        //Frame
        frame = GUI.defaultFrame();

        frame.add(labelMenu);
        frame.add(labelNamaPengirim);
        frame.add(labelHPPengirim);
        frame.add(labelAlamatPengirim);
        frame.add(labelNamaPenerima);
        frame.add(labelHPPenerima);
        frame.add(labelAlamatPenerima);
        frame.add(labelKategoriBarang);
        frame.add(labelBeratBarang);
        frame.add(labelJumlahBarang);
        frame.add(labelTotalBayar);
        
        frame.add(btnEditProfile);
        frame.add(labelKembali);

    }
    
    private void ambilOrderan(int idTransaksi)
    {
        //Cek Konfirmasi
        int konfirmasi = JOptionPane.showConfirmDialog(null, "Ingin Mengambil Orderan Ini ?");

        if (konfirmasi == 0) {
            if(new KurirController().ambilOrderOlehKurir(idTransaksi, kurir.getId_user()))
            {
                if(new KurirController().ubahKetersediaanKurir(kurir.getId_user(),1))
                {
                    JOptionPane.showMessageDialog(null, "Berhasil Mengambil Order.");
                    frame.dispose();
                    new MenuLihatOrderKurir(kurir);
                }
                else    
                    JOptionPane.showMessageDialog(null, "Mohon Maaf, Telah Terjadi Kesalahan.");
            }else{
                JOptionPane.showMessageDialog(null, "Mohon Maaf, Telah Terjadi Kesalahan.");
            }
        }
    }
    
}