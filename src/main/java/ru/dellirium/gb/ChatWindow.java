package ru.dellirium.gb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChatWindow extends JFrame {
    private JLabel htmlLabel;
    private String titleText = "<html><body style='width: 290px'>" +
            "<h2>Чятик</h2>";
    private String chatText = titleText;

    public ChatWindow() {

        /*
          Основное окно
         */

        setTitle("Simple chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        setLayout(new BorderLayout());

        /*
          Поле для ввода текста
         */

        JPanel chatWindow = new JPanel();
        chatWindow.setLayout(new BorderLayout());
        final JTextField chatTextArea = new JTextField("Lorem Ipsum Dolor Set Amet");
        JScrollPane chatScrollPane = new JScrollPane(chatTextArea);
        chatWindow.add(chatScrollPane);

        /*
          Окно с чатом
         */

        JPanel htmlPanel = new JPanel();
        htmlLabel = new JLabel();
        htmlLabel.setText(titleText + "</body></html>");
        htmlPanel.add(htmlLabel);

        chatTextArea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!chatTextArea.getText().equals("")){ // Если поле пустое, то ничего не делаем
                    chatText += "<p>" + chatTextArea.getText() + "</p>";
                    htmlLabel.setText(chatText + "</body></html>");
                    chatTextArea.setText("");
                }
            }
        });

        getContentPane().add(htmlPanel, BorderLayout.CENTER);
        getContentPane().add(chatWindow, BorderLayout.SOUTH);
        setVisible(true);
    }

}

