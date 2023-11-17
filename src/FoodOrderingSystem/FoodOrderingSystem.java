package FoodOrderingSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderingSystem extends JFrame{
    private JPanel jpanel;
    private JCheckBox cPizza;
    private JRadioButton rbFifteen;
    private JButton btnOrder;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rbNone;
    private JRadioButton rbFive;
    private JRadioButton rbTen;

    public FoodOrderingSystem() {
        JRadioButton[] grpDiscount = {rbNone,rbFive,rbTen,rbFifteen};
        JCheckBox[] grpFoods = {cPizza,cBurger,cFries,cSoftDrinks,cTea,cSundae};
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ctr=0;
                float total = 0,discount=0;
                int price=0;
                try{
                    for(JCheckBox f: grpFoods){
                        if(f.isSelected()) {
                            ctr++;
                        }
                    }
                    if(ctr==0){
                        throw new IllegalArgumentException("Please select atleast one food.");
                    }
                    ctr=0;
                    for(JRadioButton f: grpDiscount){
                        if(f.isSelected()){
                            ctr++;
                        }
                    }
                    if(ctr==0){
                        throw new IllegalArgumentException("Please select discount.");
                    }
                    for(JCheckBox f: grpFoods){
                        if(f.isSelected()) {
                            price = Integer.parseInt(f.getToolTipText());
                            total+=price;
                        }
                    }
                    for(JRadioButton f: grpDiscount){
                        if(f.isSelected()){
                            discount = Float.parseFloat(f.getToolTipText())*total;
                            total = total-discount;
                        }
                    }
                    String formattedTotal = String.format("%.2f", total);
                    JOptionPane.showMessageDialog(null,"Total price is Php "+formattedTotal);
                }
                catch(Exception err){
                    JOptionPane.showMessageDialog(null,err.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        FoodOrderingSystem order = new FoodOrderingSystem();
        order.setContentPane(order.jpanel);
        order.setSize(500,400);
        order.setLocationRelativeTo(null);
        order.setDefaultCloseOperation(3);
        order.setTitle("Food Ordering System");
        order.setVisible(true);
    }
}
