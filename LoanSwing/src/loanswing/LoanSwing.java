/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loanswing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Administrator
 */
public class LoanSwing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Loan loan= new Loan();
        loan.setVisible(true);
        loan.setResizable(true);
        loan.setSize(400, 400);
        loan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loan.getContentPane().setBackground(Color.ORANGE);
        
        Toolkit tk= Toolkit.getDefaultToolkit();
        Dimension d= tk.getScreenSize();
        loan.setLocation((d.width-loan.getWidth())/2,
                (d.height-loan.getHeight())/2);
        
        
                
        
    }
    
}
