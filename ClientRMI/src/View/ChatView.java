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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
    private JTextField userConnected = new JTextField("User(s) Connected");
    private JButton buttonLogin = new JButton("Login");
    private JButton buttonSend = new JButton("Send");
    private JButton buttonConnection = new JButton("Connection");
    private JButton buttonDeconnection = new JButton("Disconnect");
    private JPanel connectionView;
    private JPanel onlineView;
    private JPanel screemView;
    private JPanel screemExchange;
    private JMenuBar menuBar;
    private JTextArea boardscreem ;
     private JTextArea online, areawrite ;
   // private OnlineView online ;
    private JPanel screemview ;
    
    
    public ChatView(){
             setTitle("CHAT");
             getContentPane().setPreferredSize(new Dimension(700,1000) );
            // setExtendedState(JFrame.MAXIMIZED_BOTH);
            // getContentPane().setLayout( new BorderLayout() );
             
    }
    public void accueil(){
    
       buildOnlineView();
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
         
         connectionView.setVisible(false);
        // setLocationRelativeTo(null);
         getContentPane().add(connectionView,BorderLayout.WEST);
    }
    public void buildOnlineView(){
    
        
        onlineView = new JPanel(new GridBagLayout());
     
        GridBagConstraints constraints = new GridBagConstraints();
        
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.anchor = GridBagConstraints.NORTH;
        userConnected.getCaretColor().getGreen();
        onlineView.add(userConnected,constraints);
        
        constraints.anchor = GridBagConstraints.SOUTH;
        online = new JTextArea ();
        online.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(online);
         scrollPane.setPreferredSize(new Dimension(50,100));
         onlineView.add(scrollPane,constraints);
         //onlineView.setPreferredSize(new Dimension(50,520));
         getContentPane().add(onlineView,BorderLayout.EAST);
        
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
       
        
          boardscreem = new JTextArea ();
          boardscreem.setEditable(false);
          JScrollPane scrollPane = new JScrollPane(boardscreem);
          scrollPane.setPreferredSize(new Dimension(200,520));
        //constraints.anchor = GridBagConstraints.NORTH;
        
       // textScreem.setPreferredSize(new Dimension(50,20));
        
       // constraints.insets = new Insets(10, 10, 10, 10);
       // constraints.gridx = 0;
       // constraints.gridy = 0;
        //screemExchange.add(textMessage, constraints);
       
        screemExchange.add(scrollPane ,constraints);
        
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
       // screemExchange.setPreferredSize(new Dimension(80,10));
        //screemExchange.setLayout( new BorderLayout() );
        screemExchange.setVisible(false);
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

    public JTextField getTextUsername() {
        return textUsername;
    }

    public void setTextUsername(JTextField textUsername) {
        this.textUsername = textUsername;
    }

    public JTextField getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(JTextField textMessage) {
        this.textMessage = textMessage;
    }

    public JTextField getTextScreem() {
        return textScreem;
    }

    public void setTextScreem(JTextField textScreem) {
        this.textScreem = textScreem;
    }

    public JPanel getOnlineView() {
        return onlineView;
    }

    public void setOnlineView(JPanel onlineView) {
        this.onlineView = onlineView;
    }

    public JPanel getScreemView() {
        return screemView;
    }

    public void setScreemView(JPanel screemView) {
        this.screemView = screemView;
    }

    public JPanel getScreemExchange() {
        return screemExchange;
    }

    public void setScreemExchange(JPanel screemExchange) {
        this.screemExchange = screemExchange;
    }

    public JButton getButtonSend() {
        return buttonSend;
    }

    public void setButtonSend(JButton buttonSend) {
        this.buttonSend = buttonSend;
    }

    public JButton getButtonConnection() {
        return buttonConnection;
    }

    public void setButtonConnection(JButton buttonConnection) {
        this.buttonConnection = buttonConnection;
    }

    public JButton getButtonDeconnection() {
        return buttonDeconnection;
    }

    public void setButtonDeconnection(JButton buttonDeconnection) {
        this.buttonDeconnection = buttonDeconnection;
    }

    public JPanel getConnectionView() {
        return connectionView;
    }

    public void setConnectionView(JPanel connectionView) {
        this.connectionView = connectionView;
    }

    public JTextField getUserConnected() {
        return userConnected;
    }

    public void setUserConnected(JTextField userConnected) {
        this.userConnected = userConnected;
    }

    public JTextArea getBoardscreem() {
        return boardscreem;
    }

    public void setBoardscreem(JTextArea boardscreem) {
        this.boardscreem = boardscreem;
    }

    public JTextArea getOnline() {
        return online;
    }

    public void setOnline(JTextArea online) {
        this.online = online;
    }

    public JTextArea getAreawrite() {
        return areawrite;
    }

    public void setAreawrite(JTextArea areawrite) {
        this.areawrite = areawrite;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
