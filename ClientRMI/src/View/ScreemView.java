/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author brasc
 */
public class ScreemView extends JPanel{
    private JTextField text ;
    
    public ScreemView(){
       
       text = new JTextField();
       
       this.setVisible(true);
    }
    
    public void showText(String msg){
        
        this.add(new JTextField(msg));
    }
}
