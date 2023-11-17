package LeapYearChecker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LeapYearChecker extends JFrame{
    private JTextField txtYear;
    private JButton btnCheck;
    private JPanel jpanel;

    public LeapYearChecker() {
        btnCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int year;
                try{
                    year = Integer.parseInt(txtYear.getText());
                    boolean isLeapYear;
                    isLeapYear = (year % 4 == 0);
                    isLeapYear = isLeapYear && (year % 100 != 0 || year % 400 == 0);
                    if(isLeapYear){
                        JOptionPane.showMessageDialog(null,"Leap Year");
                    }else{
                        JOptionPane.showMessageDialog(null,"Not a leap year");
                    }
                    txtYear.setText("");
                }catch(Exception err){
                    JOptionPane.showMessageDialog(null,"Please input a valid year!");
                }

            }
        });

    }

    public static void main(String[] args) {
        LeapYearChecker checker = new LeapYearChecker();
        checker.setContentPane(checker.jpanel);
        checker.setSize(400,180);
        checker.setLocationRelativeTo(null);
        checker.setDefaultCloseOperation(3);
        checker.setTitle("Leap Year Checker");
        checker.setVisible(true);
    }
}
