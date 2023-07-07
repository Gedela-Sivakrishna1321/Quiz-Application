package quizapplication;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Next extends JFrame implements ActionListener{

    JButton back,start;
    public String name;
    Next(String name) {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Heading
        JLabel heading = new JLabel("Welcome  "+name+"  !   Let's Play ('-')");
        heading.setBounds(50, 20, 1000, 40);
        heading.setFont(new Font("viner Hand ITC",Font.BOLD,30));
        heading.setForeground(Color.BLUE);
        add(heading);

        // Displaying Rules
        JLabel rules = new JLabel();
        rules.setBounds(30, 50, 600, 400);
        rules.setFont(new Font("Times Roman",Font.PLAIN,16));
        rules.setText(

            "<html>"+
            "1. Read all the following Instructions carefully.Keep your admit card." + "<br><br>" +
            "2. You should not use your mobile phones while giving the test." + "<br><br>" +
            "3. All the questions are compulsary to answer." + "<br><br>"  +
            "4. Each question has a time limit, Submit within time, else it moves to the next question." + "<br><br>" +
            "5. Any kind of malpractice is not encouraged." + "<br><br>" +
            "6. All the best for your exam !! " + "<br><br>" +
            "<html>"

        );
        add(rules);


         // Buttons
         back = new JButton("back");
         back.setBounds(450, 350, 90, 30);
         back.setForeground(Color.WHITE);
         back.setBackground(new Color(30, 144, 254));
         back.addActionListener(this);
         back.setVisible(true);
         add(back);
 
 
         start = new JButton("start");
         start.setBounds(720, 350, 90, 30);
         start.setForeground(Color.WHITE);
         start.setBackground(new Color(30, 144, 254));
         start.addActionListener(this);
         start.setVisible(true);
         add(start);

       
        setLocation(150, 150);
        setSize(1000, 500);
        setVisible(true);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == start) {
            setVisible(false);
            new quiz(name);
        } else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Next("user");
    }

}
