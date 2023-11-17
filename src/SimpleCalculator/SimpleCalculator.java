package SimpleCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {
    private JTextField txtNum1;
    private JComboBox cbOp;
    private JTextField txtNum2;
    private JLabel lblResult;
    private JPanel jpanel;
    private JButton button1;



    public SimpleCalculator() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num1;
                int num2;
                int res;
                String op;
                try{
                    num1 = Integer.parseInt(txtNum1.getText());
                    num2 = Integer.parseInt(txtNum2.getText());
                    op = (String) cbOp.getSelectedItem();
                    switch (op){
                        case "+":
                            res = num1 + num2;
                            lblResult.setText(String.valueOf(res));
                            break;
                        case "-":
                            res = num1 - num2;
                            lblResult.setText(String.valueOf(res));
                            break;
                        case "*":
                            res = num1 * num2;
                            lblResult.setText(String.valueOf(res));
                            break;
                        case "/":
                            if(num2==0){
                                throw new ArithmeticException("Undefined");
                            }
                            res = num1 / num2;
                            lblResult.setText(String.valueOf(res));
                            break;
                        default:
                            break;
                    }
                }catch(ArithmeticException err){
                    lblResult.setText(err.getMessage());
                    JOptionPane.showMessageDialog(null,err.getMessage());
                }catch(Exception err){
                    JOptionPane.showMessageDialog(null,"Please input valid numbers");
                }
            }
        });
    }

    public static void main(String[] args) {
        SimpleCalculator calc = new SimpleCalculator();
        calc.setContentPane(calc.jpanel);
        calc.setSize(400,180);
        calc.setLocationRelativeTo(null);
        calc.setDefaultCloseOperation(3);
        calc.setTitle("Simple Calculator");
        calc.setVisible(true);
    }
}
