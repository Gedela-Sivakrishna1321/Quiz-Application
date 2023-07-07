package quizapplication;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{

    JButton next,back;
    JTextField tfname;
    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        // Image view
        ImageIcon I1 = new ImageIcon(getClass().getResource("quizImage.png"));
        JLabel image = new JLabel(I1);
        image.setBounds(0, 5, 600, 500);
        add(image);
        
        setSize(1200, 500);
        setLocation(100, 150);

        // Welcome Heading
        JLabel heading = new JLabel("Welcome  Everyone");
        heading.setBounds(700, 60, 500, 40);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 35));
        heading.setForeground(Color.BLUE);
        add(heading);

        // User Name heading
        JLabel name = new JLabel("Enter your Name");
        name.setBounds(770, 120, 500, 40);
        name.setFont(new Font("Times New Roman", Font.BOLD, 25));
        name.setForeground(Color.BLACK);
        add(name);

        // TextFeild for user to enter his name
        tfname = new JTextField();
        tfname.setBounds(710, 180, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        tfname.setVisible(true);
        add(tfname);

        // Buttons
        next = new JButton("next");
        next.setBounds(730, 230, 90, 30);
        next.setForeground(Color.WHITE);
        next.setBackground(new Color(30, 144, 254));
        next.addActionListener(this);
        next.setVisible(true);
        add(next);


        back = new JButton("back");
        back.setBounds(900, 230, 90, 30);
        back.setForeground(Color.WHITE);
        back.setBackground(new Color(30, 144, 254));
        back.addActionListener(this);
        back.setVisible(true);
        add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == next) {
            String name = tfname.getText();
            setVisible(false);
            new Next(name);
        } else if (e.getSource() == back) {
            setVisible(false);
        }
    }

    

    public static void main(String[] args) {
        new Login();
    }

    
}