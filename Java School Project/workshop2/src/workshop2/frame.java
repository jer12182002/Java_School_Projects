/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop2;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 *
 * @author Jason
 */
public class frame {

    private javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
    private javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
    private javax.swing.JLabel JLabel3 = new javax.swing.JLabel();
    private javax.swing.JLabel JLabel4 = new javax.swing.JLabel();
    private javax.swing.JTextField JText1 = new javax.swing.JTextField(8);
    private javax.swing.JTextField JText2 = new javax.swing.JTextField(8);
    private javax.swing.JTextField JText3 = new javax.swing.JTextField(10);
    private javax.swing.JTextField JText4 = new javax.swing.JTextField(10);
    private javax.swing.JButton JButton1 = new javax.swing.JButton();
    private javax.swing.JButton JButton2 = new javax.swing.JButton();
    private javax.swing.JTextArea JTextArea = new javax.swing.JTextArea();
    private javax.swing.JFrame JFrame = new javax.swing.JFrame();
    private java.awt.FlowLayout Layout = new java.awt.FlowLayout();

    public frame(ArrayList<Account> acc) {

        JFrame.setLayout(Layout);
        JFrame.setVisible(true);
        JFrame.setSize(500, 500);
        JFrame.setDefaultCloseOperation(3);

        JLabel1.setText("Account");
        JLabel2.setText("First Name");
        JLabel3.setText("Last Name");
        JLabel4.setText("Balance");

        JButton1.setText("Save Object");
        JButton2.setText("Load Object");

        JFrame.add(JLabel1);
        JFrame.add(JText1);
        JFrame.add(JLabel2);
        JFrame.add(JText2);
        JFrame.add(JLabel3);
        JFrame.add(JText3);
        JFrame.add(JLabel4);
        JFrame.add(JText4);
        JFrame.add(JButton1);
        JFrame.add(JButton2);
        JFrame.add(JTextArea);

        JButton1.addActionListener(new java.awt.event.ActionListener() {
            int account = 0;
            String firstN;
            String lastN;
            double bal = 0;
            boolean parseGood=false;

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    account = Integer.parseInt(JText1.getText());
                    bal = Double.parseDouble(JText4.getText());
                    parseGood=true;
                } catch (Exception ex) {
                    System.out.println(ex);
                    JTextArea.setText("invalid information, please make sure account and balance are digit only!");
                }

                if (!(JText1.getText().trim().length() > 0)) {
                    JTextArea.setText("Please type in account number!");
                }

                firstN = JText2.getText();
                lastN = JText3.getText();

                if ((!(firstN.trim().length() > 0)) || !(lastN.trim().length() > 0)) {
                    JTextArea.setText("please type in your name!");
                } else {
                    if (account > 0&&parseGood) {
                        if (!(firstN.matches("[a-zA-Z ]*\\d+.*") || lastN.matches("[a-zA-Z ]*\\d+.*"))) {

                            new SaveObj().UserTypeAccInfo(account, firstN, lastN, bal, acc);
                            JTextArea.setText("Account Saved");

                        } else {
                            JTextArea.setText("Please type in valid format for Names!");
                        }
                    }
                }
            }
        });

        JButton2.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Account> accList = new ArrayList();
                if (new readObj().readAndPrintFile().size() <= 0) {
                    JTextArea.setText("No Account in history, please add one!");
                } else {
                    accList = new readObj().readAndPrintFile();
                    JTextArea.setText(accList.toString().replace('[', ' ').replace(']', ' ').replace(',', '\n').trim());
                }
            }
        });

    }
}
