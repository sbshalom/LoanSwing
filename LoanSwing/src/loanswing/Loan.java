/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loanswing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



/**
 *
 * @author Administrator
 */
public class Loan extends JFrame{
    
    private JRadioButton smallRadioButton,
                       mediumRadioButton,
                       largeRadioButton;
    private ButtonGroup buttonGroup;
    private JTextField RateIntrest, Amount, BillTextField;
    private JLabel OptionsLabel,BillLabel,RateIntrestLabel,AmountLabel ;
    private JButton calcButton,
                    resetButton;
    private JPanel centerPanel, bottomPanel;
    
    public Loan()
    {
        super("Loan Plan");
        
        OptionsLabel= new JLabel("Options");
        OptionsLabel.setHorizontalAlignment(JLabel.CENTER);
        add(OptionsLabel, BorderLayout.NORTH);
        
        smallRadioButton= new JRadioButton("5 Years");
        smallRadioButton.setOpaque(false);
        mediumRadioButton= new JRadioButton("10 Years");
        mediumRadioButton.setOpaque(false);
        largeRadioButton= new JRadioButton("15 YearS");
        largeRadioButton.setOpaque(false);
        RateIntrestLabel= new JLabel("RateIntrest");
        RateIntrest= new JTextField();
        AmountLabel= new JLabel("Amount");
        Amount= new JTextField();
        
         buttonGroup= new ButtonGroup();
        buttonGroup.add(smallRadioButton);
        buttonGroup.add(mediumRadioButton);
        buttonGroup.add(largeRadioButton);
        
        centerPanel= new JPanel(new GridLayout(7, 1));
        centerPanel.setBackground(Color.YELLOW);
        this.add(centerPanel, BorderLayout.CENTER);
        centerPanel.add(smallRadioButton);
        centerPanel.add(mediumRadioButton);
        centerPanel.add(largeRadioButton);
        centerPanel.add(RateIntrestLabel);
        centerPanel.add(RateIntrest);
        centerPanel.add(AmountLabel);
        centerPanel.add(Amount);
        
        bottomPanel= new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        BillLabel= new JLabel("The monthly payment ");
        
        BillTextField= new JTextField(5);
        BillTextField.setEditable(false);
        BillTextField.setDisabledTextColor(Color.BLACK);
        
        MyButtonHandler handler= new MyButtonHandler();
        calcButton= new JButton("Calulate Price");
        calcButton.addActionListener(handler);
        resetButton= new JButton("Reset");
        resetButton.addActionListener(handler);
        
        bottomPanel.add(BillLabel);
        bottomPanel.add(BillTextField);
        bottomPanel.add(calcButton);
        bottomPanel.add(resetButton);
        
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    private class MyButtonHandler implements ActionListener{

        public void actionPerformed(ActionEvent event) {
            
            if(event.getSource()==calcButton)
                calculate();
            else if(event.getSource()==resetButton)
                reset();
        }

        private void calculate() {
            try {
                double price=0;
            Double AM= Double.parseDouble(Amount.getText());
            Double RI=Double.parseDouble(RateIntrest.getText());
            double monthlyRate =RI / 100 / 12.0 ; 
            
            
            if(smallRadioButton.isSelected())
            {
                price=(monthlyRate * AM) / ( 1 - ( 1 / (Math.pow(( 1 + monthlyRate ), (12 * 5) ) )));
            }
            
            if(mediumRadioButton.isSelected())
            {
                price=(monthlyRate * AM) / ( 1 - ( 1 / (Math.pow(( 1 + monthlyRate ), (12 * 10) ) )));
            }
            
            if(largeRadioButton.isSelected())
            {
                price=(monthlyRate * AM) / ( 1 - ( 1 / (Math.pow(( 1 + monthlyRate ), (12 * 15) ) )));
            }
            
           BillTextField.setText(String.valueOf(Math.round(price)));
            } catch (Exception e) {
               BillTextField.setText("Don't write Letters");
            }
            
        }

        private void reset() {
            buttonGroup.clearSelection();
            RateIntrest.setText("");
            Amount.setText("");
            BillTextField.setText("");
        }
    }
}
