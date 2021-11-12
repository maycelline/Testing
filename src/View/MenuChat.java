package View;

import Model.Chat;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class MenuChat {
    
    ArrayList<JLabel> labelChat = new ArrayList();

    public MenuChat(ArrayList<Chat> chats) {

        JFrame frame = new DefaultFrameSetting().defaultFrame();
        JScrollPane scroll = new JScrollPane();
        JLabel label = new JLabel("Menggunakan ScrollPane");

        //ScrollPane
        label.setPreferredSize(new Dimension(450, 900));
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setViewportBorder(new LineBorder(Color.RED));
        scroll.getViewport().add(label, null);

        JTextField chat = new JTextField();
        chat.setBounds(25, 680, 500, 50);
        chat.setFont(new Font("Arial", Font.PLAIN, 20));

        //Button Send
        JButton send = new JButton("Send");
        send.setBounds(535, 680, 70, 50);
        send.setFont(new Font("Arial", Font.PLAIN, 15));

        //Chat Bubble
        frame.add(scroll);
        frame.add(chat);
        frame.add(send);
        frame.setLayout(null);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(25, 70, 580, 600);
        frame.setBackground(new Color(204, 180, 114));
    }
}
