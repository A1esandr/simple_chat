package chat.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainSwingWindow extends JFrame {
    public MainSwingWindow(){
        setTitle("Simple chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 500, 500, 500);

        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());

        JTextArea jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);
        jp.add(jsp, BorderLayout.CENTER);

        JPanel bottomJp = new JPanel();
        bottomJp.setLayout(new BorderLayout());

        JTextField field = addTextField(jta);
        bottomJp.add(field, BorderLayout.CENTER);

        JButton button = addButton(jta, field);
        bottomJp.add(button, BorderLayout.SOUTH);
        jp.add(bottomJp, BorderLayout.SOUTH);
        add(jp);

        setVisible(true);
    }

    private void sendMessage(JTextField field, JTextArea jta){
        if(!field.getText().isEmpty()){
            jta.append(field.getText()+"\n");
            field.setText("");
        }
    }

    private JTextField addTextField(JTextArea jta){
        JTextField field = new JTextField();
        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(field, jta);
            }
        });
        return field;
    }

    private JButton addButton(JTextArea jta, JTextField field){
        JButton button = new JButton("Отправить");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(field, jta);
            }
        });
        return button;
    }
}
