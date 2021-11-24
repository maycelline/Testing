package View;

import Controller.Controller;
import Model.Chat;
import Model.Kurir;
import Model.Pelanggan;
import Model.Transaksi;
import Model.User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MenuChat {
    
    private ArrayList<JLabel> labelChat = new ArrayList();
    private String namaLawanChat, name;
    private int idLawanChat;
    private Controller c = new Controller();
    private JButton send, refresh;
    private DefaultComponentSetting GUI = new DefaultComponentSetting();

    public MenuChat(Transaksi transaksi, User u) {
        
        int idTransaksi = transaksi.getIdTransaksi();
        ArrayList<Chat> chats = new ArrayList();
        chats = c.getChatById(idTransaksi);
        
        namaLawanChat = c.getNamaLawanChat(transaksi, u);
        idLawanChat = c.getIdLawanChat(transaksi, u);

        JFrame frame = new DefaultComponentSetting().defaultFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.getContentPane().setLayout(null);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(25, 90, 530, 570);
        frame.getContentPane().add(scrollPane);

        JPanel borderlaoutpanel = new JPanel();
        scrollPane.setViewportView(borderlaoutpanel);
        borderlaoutpanel.setLayout(new BorderLayout(0, 0));
        
        //Chat TextField
        JTextField chat = new JTextField();
        chat.setBounds(25, 680, 455, 50);
        chat.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(chat);

        //Button Send
        send = GUI.defaultButton("Kirim",15);
        send.setBounds(485, 680, 70, 50);
        send.setFont(new Font("Arial", Font.PLAIN, 15));
        frame.add(send);
        
        //Button refresh
        refresh = GUI.defaultButton("Refresh",10);
        refresh.setBounds(500, 20, 50, 50);
        frame.add(refresh);

        send.addActionListener((ActionEvent e) -> {
            frame.dispose();

            Chat myChat = new Chat();
            myChat.setIdPenerima(idLawanChat);
            myChat.setIdPengirim(u.getIdUser());
            myChat.setChat(chat.getText());
            myChat.setIdTransaksi(idTransaksi);
            myChat.setTime(null);
            c.insertChat(myChat);
            new MenuChat(transaksi, u);
        });
        
        refresh.addActionListener((ActionEvent e) -> {
            frame.dispose();
            new MenuChat(transaksi, u);
        });

        //Button back
        JButton back = GUI.defaultButton("<",15);
        back.setBounds(25, 20, 50, 50);
        frame.add(back);
        
        back.addActionListener((ActionEvent e) -> {
            frame.dispose();
            if (u instanceof Kurir) {
                Kurir kurir = (Kurir)u;
                new MenuLihatDetailTransaksi(transaksi, kurir);
            }
            else if (u instanceof Pelanggan) {
                Pelanggan pelanggan = (Pelanggan)u;
                new MenuLihatDetailTransaksi(transaksi, pelanggan);
            }
            
        });
        //Nama
        JLabel nama = new DefaultComponentSetting().defaultRegularLabel(namaLawanChat);
        nama.setBounds(95, 20, 300, 50);
        frame.add(nama);

        nama.setFont(new Font("Arial", Font.PLAIN, 25));
        
        JPanel columnpanel = new JPanel();
        borderlaoutpanel.add(columnpanel, BorderLayout.NORTH);
        columnpanel.setLayout(new GridLayout(0, 1, 0, 1));
        columnpanel.setBackground(Color.gray);

        for (int i = 0; i < chats.size(); i++) {
            if (chats.get(i).getIdPengirim() == u.getIdUser()) {
                name = "You";
            } else {
                name = namaLawanChat;
            }
            JPanel rowPanel = new JPanel();
            rowPanel.setPreferredSize(new Dimension(300, 50));
            columnpanel.add(rowPanel);
            rowPanel.setLayout(null);

            JLabel teksChat = new JLabel(name + " : " + chats.get(i).getChat());
            teksChat.setFont(new Font("Arial", Font.PLAIN, 16));
            teksChat.setBounds(20, 5, 500, 40);
            rowPanel.add(teksChat);

            if (chats.get(i).getIdPengirim() != u.getIdUser()) {
                rowPanel.setBackground(SystemColor.inactiveCaptionBorder);
            }
        }

        frame.setVisible(true);

    }
}
