package quizapplication;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Score  extends JFrame implements ActionListener{

    Score(String name,int score) {


        setBounds(230,100,1000,600);
		getContentPane().setBackground(new Color(187,198,226));
		setLayout(null);
		
        ImageIcon I1 = new ImageIcon(getClass().getResource("scoreimg.png"));
        JLabel image = new JLabel(I1);
        image.setBounds(0, 10, 600, 500);
        add(image);


        JLabel heading = new JLabel("Thankyou "+ name+".");
	    heading.setBounds(80,37,600,30);
	    heading.setFont(new Font("Tahoma",Font.PLAIN,26));
	    add(heading);

        JLabel title = new JLabel("Congratulations");
	    title.setBounds(645,120,300,30);
	    title.setFont(new Font("Tahoma",Font.PLAIN,26));
	    add(title);

        JLabel lblscore = new JLabel("Your score is " + score);
	    lblscore.setBounds(645,170,320,30);
	    lblscore.setFont(new Font("Tahoma",Font.PLAIN,26));
	    add(lblscore);
	    

        JButton submit = new JButton("Play again");
		submit.setBounds(675,300,150,30);
		submit.setBackground(new Color(30,144,254));
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		add(submit);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       setVisible(false);
       new Login();
    }

    public static void main(String[] args) {
        new Score("user",0);
    }
   
}
