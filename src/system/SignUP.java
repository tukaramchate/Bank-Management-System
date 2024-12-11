package system;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SignUP extends JFrame {

    Random ran = new Random();
    long first4= (ran.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first4);
    SignUP(){
        super("Application Form");


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

        JLabel label1 = new JLabel("Application form NO:" + first);
        label1.setBounds(160,20,600,40);
        label1.setFont(new Font("Raleway",Font.BOLD,38));
        add(label1);

        getContentPane().setBackground(new Color(222, 255, 252));
        setLayout(null);
        setSize(850,800);
        setLocation(360,40);
        setVisible(true);
    }

    public static void main(String[] args) {
    new SignUP();
    }
}
