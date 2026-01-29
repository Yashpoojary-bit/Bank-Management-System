package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton s, c;
    String formno;

    Signup3(String formno) {
        this.formno = formno;

        setLayout(null);
        getContentPane().setBackground(new Color(215, 252, 252));

        // BANK ICON
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(100, 20, 80, 80);
        add(image);

        JLabel l1 = new JLabel("Page 3:");
        l1.setFont(new Font("Raleway", Font.BOLD, 20));
        l1.setBounds(250, 30, 200, 30);
        add(l1);

        JLabel l2 = new JLabel("Account Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 20));
        l2.setBounds(250, 60, 300, 30);
        add(l2);

        // ACCOUNT TYPE
        JLabel l3 = new JLabel("Account Type:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(100, 130, 200, 30);
        add(l3);

        r1 = new JRadioButton("Saving Account");
        r2 = new JRadioButton("Fixed Deposit Account");
        r3 = new JRadioButton("Current Account");
        r4 = new JRadioButton("Recurring Deposit Account");

        r1.setBounds(100, 170, 200, 30);
        r2.setBounds(350, 170, 300, 30);
        r3.setBounds(100, 210, 200, 30);
        r4.setBounds(350, 210, 300, 30);

        JRadioButton[] radios = {r1, r2, r3, r4};
        for (JRadioButton r : radios) {
            r.setFont(new Font("Raleway", Font.BOLD, 16));
            r.setBackground(new Color(215, 252, 252));
            add(r);
        }

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1); bg.add(r2); bg.add(r3); bg.add(r4);

        // CARD NUMBER
        JLabel l4 = new JLabel("Card Number:");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(100, 260, 200, 30);
        add(l4);

        JLabel l5 = new JLabel("(Your 16-digit Card Number)");
        l5.setFont(new Font("Raleway", Font.PLAIN, 12));
        l5.setBounds(100, 290, 200, 20);
        add(l5);

        JLabel l6 = new JLabel("XXXX-XXXX-XXXX-4841");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));
        l6.setBounds(350, 260, 300, 30);
        add(l6);

        JLabel l7 = new JLabel("(It would appear on ATM card / Cheque Book and Statement)");
        l7.setFont(new Font("Raleway", Font.PLAIN, 12));
        l7.setBounds(350, 290, 450, 20);
        add(l7);

        // PIN
        JLabel l8 = new JLabel("PIN:");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(100, 330, 200, 30);
        add(l8);

        JLabel l9 = new JLabel("XXXX");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));
        l9.setBounds(350, 330, 200, 30);
        add(l9);

        JLabel l10 = new JLabel("(4-digit Password)");
        l10.setFont(new Font("Raleway", Font.PLAIN, 12));
        l10.setBounds(100, 360, 200, 20);
        add(l10);

        // SERVICES
        JLabel l11 = new JLabel("Services Required:");
        l11.setFont(new Font("Raleway", Font.BOLD, 18));
        l11.setBounds(100, 410, 200, 30);
        add(l11);

        c1 = new JCheckBox("ATM Card");
        c2 = new JCheckBox("Internet Banking");
        c3 = new JCheckBox("Mobile Banking");
        c4 = new JCheckBox("EMAIL Alerts");
        c5 = new JCheckBox("Cheque Book");
        c6 = new JCheckBox("E-Statement");

        c1.setBounds(100, 450, 200, 30);
        c2.setBounds(350, 450, 200, 30);
        c3.setBounds(100, 490, 200, 30);
        c4.setBounds(350, 490, 200, 30);
        c5.setBounds(100, 530, 200, 30);
        c6.setBounds(350, 530, 200, 30);

        JCheckBox[] checks = {c1, c2, c3, c4, c5, c6};
        for (JCheckBox cb : checks) {
            cb.setFont(new Font("Raleway", Font.BOLD, 16));
            cb.setBackground(new Color(215, 252, 252));
            add(cb);
        }

        c7 = new JCheckBox(
                "I hereby declare that the above entered details are correct to the best of my knowledge.",
                true
        );
        c7.setBackground(new Color(215, 252, 252));
        c7.setBounds(100, 580, 700, 30);
        add(c7);

        // BUTTONS
        s = new JButton("Submit");
        c = new JButton("Cancel");

        s.setBounds(260, 640, 120, 35);
        c.setBounds(420, 640, 120, 35);

        s.setBackground(Color.BLACK);
        s.setForeground(Color.WHITE);
        c.setBackground(Color.BLACK);
        c.setForeground(Color.WHITE);

        s.addActionListener(this);
        c.addActionListener(this);

        add(s);
        add(c);

        setSize(850, 730);
        setLocation(350, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == s) {

            String atype = null;
            if (r1.isSelected()) atype = "Saving Account";
            else if (r2.isSelected()) atype = "Fixed Deposit Account";
            else if (r3.isSelected()) atype = "Current Account";
            else if (r4.isSelected()) atype = "Recurring Deposit Account";

            Random ran = new Random();
            long cardno = Math.abs((ran.nextLong() % 90000000L) + 1409963000000000L);
            int pin = Math.abs((ran.nextInt() % 9000) + 1000);

            if (atype == null) {
                JOptionPane.showMessageDialog(null, "Please select account type");
                return;
            }

            JOptionPane.showMessageDialog(
                    null,
                    "Account Created Successfully\nCard No: " + cardno + "\nPIN: " + pin

        );} else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Signup3("");
    }
}
