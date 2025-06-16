package system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;

public class Deposit extends JFrame implements ActionListener {
    String pin;
    TextField textField;

    JButton b1, b2, b3; // Buttons: Deposit, Back, and Exit

    Deposit(String pin) {
        this.pin = pin;

        // Setting up the ATM interface
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        // Label for entering deposit amount
        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(460, 180, 400, 35);
        l3.add(label1);

        // Input field for deposit amount
        textField = new TextField();
        textField.setBackground(new Color(65, 125, 128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460, 230, 320, 25);
        textField.setFont(new Font("Raleway", Font.BOLD, 22));
        l3.add(textField);

        // Deposit button
        b1 = new JButton("Deposit");
        b1.setBounds(700, 362, 150, 35);
        b1.setBackground(new Color(65, 125, 128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        // Back button
        b2 = new JButton("BACK");
        b2.setBounds(700, 406, 150, 35);
        b2.setBackground(new Color(65, 125, 128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        // Exit button
        b3 = new JButton("EXIT");
        b3.setBounds(410, 406, 150, 35);
        b3.setBackground(new Color(65, 125, 128));
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        l3.add(b3);

        // Frame settings
        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amountStr = textField.getText();

            if (e.getSource() == b1) { // Deposit button functionality
                if (amountStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Deposit");
                    return;
                }

                double amount = Double.parseDouble(amountStr);
                Date date = new Date();

                Con c = new Con();
                String query = "INSERT INTO bank VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = c.connection.prepareStatement(query);
                stmt.setString(1, pin);
                stmt.setDate(2, new java.sql.Date(date.getTime()));
                stmt.setString(3, "DEPOSIT");
                stmt.setDouble(4, amount);

                int rowsInserted = stmt.executeUpdate();

                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Deposit failed. Please try again.");
                }

                setVisible(false);
                new Main_Class(pin);
            } else if (e.getSource() == b2) { // Back button functionality
                setVisible(false);
                new Main_Class(pin); // Navigate back to Main_Class
            } else if (e.getSource() == b3) { // Exit button functionality
                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to exit?",
                        "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0); // Exit the application
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a valid number.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error. Please contact support.");
        }
    }

    public static void main(String[] args) {
        new Deposit(""); // Main entry point
    }
}
