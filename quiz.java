package quizapplication;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class quiz extends JFrame implements ActionListener{

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String usersanswers[][] = new String[10][1];
    JRadioButton opt1,opt2,opt3,opt4;
    ButtonGroup buttonGroup;
    JButton next,submit;
    JLabel qno,question;
    public static int count=0;
    public static int timer=15;
    public static int ans_given =0;
    public static int score =0;
    String name;
    quiz(String name) {
        this.name = name;
        getContentPane().setBackground(new Color(187,198,226));
        setBounds(50, 5, 1200, 720);
        setLayout(null);
        


         // Image view
         ImageIcon I1 = new ImageIcon(getClass().getResource("QuizImg.png"));
         JLabel image = new JLabel(I1);
         image.setBounds(0, 0, 1200, 250);
         add(image);
         
         // Questions
         qno = new JLabel();
         qno.setBounds(100, 300, 50, 30);
         qno.setFont(new Font("Tahoma",Font.PLAIN,24));
         add(qno);


         question = new JLabel();
         question.setBounds(150, 300, 1200, 30);
         question.setFont(new Font("Tahoma",Font.PLAIN,24));
         add(question);

         questions[0][0] = "Who is the father of C language?";
         questions[0][1] = "Steve Jobs";
         questions[0][2] = "James Gosling";
         questions[0][3] = "Dennis Ritchie";
         questions[0][4] = "Charles Babbage";
 
         questions[1][0] = "Which of the following cannot be variable name in C?";
         questions[1][1] = "int";
         questions[1][2] = "export";
         questions[1][3] = "friend";
         questions[1][4] = "1010";
 
         questions[2][0] = "Which package contains the Random class?";
         questions[2][1] = "java.util package";
         questions[2][2] = "java.lang package";
         questions[2][3] = "java.awt package";
         questions[2][4] = "java.io package";
 
         questions[3][0] = "An interface with no fields or methods is known as?";
         questions[3][1] = "Runnable Interface";
         questions[3][2] = "Abstract Interface";
         questions[3][3] = "Marker Interface";
         questions[3][4] = "CharSequence Interface";
 
         questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
         questions[4][1] = "Stack";
         questions[4][2] = "String memory";
         questions[4][3] = "Random storage space";
         questions[4][4] = "Heap memory";
 
         questions[5][0] = "Which of the following is used to prevent any changes in variable within a C program?";
         questions[5][1] = "short";
         questions[5][2] = "immutable";
         questions[5][3] = "const";
         questions[5][4] = "volatile";
 
         questions[6][0] = "Which keyword is used for accessing the features of a package?";
         questions[6][1] = "import";
         questions[6][2] = "package";
         questions[6][3] = "extends";
         questions[6][4] = "export";
 
         questions[7][0] = "In java, jar stands for?";
         questions[7][1] = "Java Archive Runner";
         questions[7][2] = "Java Archive";
         questions[7][3] = "Java Application Resource";
         questions[7][4] = "Java Application Runner";
 
         questions[8][0] = "Which of the following is an example of iteration in C?";
         questions[8][1] = "for";
         questions[8][2] = "while";
         questions[8][3] = "do-while";
         questions[8][4] = "all the above";
 
         questions[9][0] = "Which of the following option leads to the portability and security of Java?";
         questions[9][1] = "Bytecode is executed by JVM";
         questions[9][2] = "The applet makes the Java code secure and portable";
         questions[9][3] = "Use of exception handling";
         questions[9][4] = "Dynamic binding between objects";



         
        answers[0][1] = "Dennis Ritchie";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "const";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "all the above";
        answers[9][1] = "Bytecode is executed by JVM";

        opt1 = new JRadioButton();
        opt1.setBounds(170, 470, 700, 30);
        opt1.setBackground(new Color(187,198,226));
        opt1.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt1);


        
	    opt2 = new JRadioButton();
	    opt2.setBounds(170,510,700,30);
	    opt2.setBackground(new Color(187,198,226));
	    opt2.setFont(new Font("Dialog",Font.PLAIN,20));
	    add(opt2);
	    
	    opt3 = new JRadioButton();
	    opt3.setBounds(170,550,700,30);
	    opt3.setBackground(new Color(187,198,226));
	    opt3.setFont(new Font("Dialog",Font.PLAIN,20));
	    add(opt3);
	   
	    opt4 = new JRadioButton();
	    opt4.setBounds(170,590,700,30);
	    opt4.setBackground(new Color(187,198,226));
	    opt4.setFont(new Font("Dialog",Font.PLAIN,20));
	    add(opt4);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(opt1);
        buttonGroup.add(opt2);
        buttonGroup.add(opt3);
        buttonGroup.add(opt4);

        next = new JButton("Next");
		next.setBounds(950,500,90,30);
		next.setBackground(new Color(30,144,254));
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		add(next);
		
		submit = new JButton("Submit");
		submit.setBounds(950,550,90,30);
		submit.setBackground(new Color(30,144,254));
		submit.setForeground(Color.WHITE);
	    submit.addActionListener(this);
		submit.setEnabled(false);
		add(submit);

        start(count);

         setVisible(true);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == next) {
        if(buttonGroup.getSelection() == null) {
            usersanswers[count][0] = "";
        } else {
            usersanswers[count][0] = buttonGroup.getSelection().getActionCommand();
        }
        if(count == 8) {
            next.setEnabled(false);
            submit.setEnabled(true);
        }
        count++;
        start(count);
       }

       if(e.getSource() == submit) {
        if(buttonGroup.getSelection() == null) {
            usersanswers[count][0] = "";
        } else {
            usersanswers[count][0] = buttonGroup.getSelection().getActionCommand();
        }

        for(int i=0;i<usersanswers.length;i++) {
            if(usersanswers[i][0].equals(answers[i][1])) {
                score += 10;
            }
        }
        setVisible(false);
        new Score(name,score);

       }
    }

    public void paint(Graphics g) {
        super.paint(g);
        String time = "Time Left-"+timer+" seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 20));

        if(timer > 0) {
            g.drawString(time, 900, 450);

        } else {
            g.drawString("TimesUp !!", 900,450);
        }
        timer--;
        try {
            Thread.sleep(1000);
            repaint();
        } 
        catch(Exception e ) {
            e.printStackTrace();
        }
        if(ans_given == 1) {
            ans_given=0;
            timer=15;
        } else if (timer < 0) {
            if(count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            } 
            if(count == 9) {
                if(buttonGroup.getSelection() == null) {
                    usersanswers[count][0] = "";
                } else {
                    usersanswers[count][0] = buttonGroup.getSelection().getActionCommand();
                }

                for(int i=0;i<usersanswers.length;i++) {
                    if(usersanswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    }
                }
                
                setVisible(false);
                new Score(name,score);

            } else {
                timer=15;
                if(buttonGroup.getSelection() == null) {
                    usersanswers[count][0] = "";
                } else {
                    usersanswers[count][0] = buttonGroup.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
           
        }
     }

    public void start(int count) {

        qno.setText(""+(count+1)+".");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        buttonGroup.clearSelection();
    }

    public static void main(String[] args) {
        new quiz("");
    }

}
