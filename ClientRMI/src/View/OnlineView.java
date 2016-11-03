/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author brasc
 */
public class OnlineView extends JPanel{
    
   
    public OnlineView(){
       this.setVisible(true);
    }
    
   
    public void showConnected(ArrayList<String> listConnected){
        
        for( String s : listConnected){
         
            this.add(new JLabel(s)) ;
        }
      
    }
}
