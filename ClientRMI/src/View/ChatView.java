/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author brasc
 */
public class ChatView extends JFrame implements ActionListener{
    private JLabel labelUsername = new JLabel("Enter username: ");
    private JTextField textUsername = new JTextField(20);
    private JTextField textMessage = new JTextField(20);
    private JTextField textScreem = new JTextField(30);
    private JButton buttonLogin = new JButton("Login");
    private JButton buttonSend = new JButton("Send");
    private JButton buttonConnection = new JButton("Connection");
    private JButton buttonDeconnection = new JButton("Disconnect");
    private JPanel connectionView;
    private JPanel onlineView;
    private JPanel screemView;
    private JPanel screemExchange;
    private JMenuBar menuBar;
   // private OnlineView online ;
    private JPanel screemview ;
    
    
    public ChatView(){
             setTitle("CHAT");
             getContentPane().setPreferredSize(new Dimension(700,600) );
            // setExtendedState(JFrame.MAXIMIZED_BOTH);
            // getContentPane().setLayout( new BorderLayout() );
             
    }
    public void accueil(){
    
       onlineView = new JPanel(new GridBagLayout());
       onlineView.setPreferredSize(new Dimension(10,10));;
       buildConnectionView();
     //  getContentPane().add(connectionView,BorderLayout.WEST);
       
       /*
         
       */
       menuBar = new JMenuBar();
       menuBar.add(buttonConnection);
       menuBar.add(buttonDeconnection);
       setJMenuBar(menuBar);
      // screemView = new JPanel(new GridBagLayout());
      // onlineView = new JPanel(new GridBagLayout());
      // screemExchange = new JPanel(new GridBagLayout());
      // screemExchange.setSize(50, 60);
      // screemExchange.setPreferredSize(new Dimension(100,400));
     //  screemview.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Login Panel"));
       //screemExchange.add(screemview,"north");
       buildScreemExchange();
       //getContentPane().add(screemExchange,BorderLayout.EAST);
       getContentPane().add(onlineView,BorderLayout.EAST);
       getContentPane().setVisible(true);
    }
    public void buildConnectionView(){
        
        connectionView = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        connectionView.add(labelUsername, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        connectionView.add(textUsername, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 2;
       // constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        connectionView.add(buttonLogin, constraints);
        
        // set border for the panel 
        connectionView.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Login Panel"));
       
         pack();
         
        // setLocationRelativeTo(null);
         getContentPane().add(connectionView,BorderLayout.WEST);
    }
    public void buildScreemView(){
    
        
    }
    public void buildScreemExchange(){
        
        
         
        screemExchange = new JPanel(new GridBagLayout());
       
        GridBagConstraints constraints = new GridBagConstraints();
        //screemExchange.setLayout(new FlowLayout());
       /* screemview = new JPanel(new GridBagLayout());
        screemview.setPreferredSize(new Dimension(50,150));
        screemview.setBorder(BorderFactory.createLineBorder(Color.BLACK));*/
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth =2;
       
        //constraints.anchor = GridBagConstraints.NORTH;
        textScreem.setEditable(false);
        textScreem.setPreferredSize(new Dimension(50,20));
        
       // constraints.insets = new Insets(10, 10, 10, 10);
       // constraints.gridx = 0;
       // constraints.gridy = 0;
        //screemExchange.add(textMessage, constraints);
       
        screemExchange.add(textScreem,constraints);
        
       // constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridheight = 50;
        constraints.anchor = GridBagConstraints.LAST_LINE_START;
        screemExchange.add(textMessage,constraints );
       // screemExchange.add(buttonSend, constraints);
       // constraints.anchor = GridBagConstraints.SOUTH;
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.LAST_LINE_END;
        screemExchange.add(buttonSend,constraints);
        screemExchange.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        screemExchange.setPreferredSize(new Dimension(80,10));
        //screemExchange.setLayout( new BorderLayout() );
       
        // pack();
        getContentPane().add(screemExchange,BorderLayout.CENTER);
       // setLocationRelativeTo(null);
        //screemExchange.setVisible(true);
    }
    public void addMenuItemActionListener(ActionListener listener) {
		buttonLogin.addActionListener(listener);
		buttonSend.addActionListener(listener);
		buttonConnection.addActionListener(listener);
		buttonConnection.addActionListener(listener);
		//heuristiqueA.addActionListener(listener);

	}

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
