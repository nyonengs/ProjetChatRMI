/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ClientManager;
import View.ChatView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author brasc
 */
public class Controller {
    private ClientManager m;
    private ChatView v;
    private String recup;
    private String username;
    
    public Controller(ClientManager m,ChatView v) {
        this.v = v;
        this.m = m;
    }
    
    
    public void appelMenu(){
                v.setVisible(true);
		v.accueil();
		v.addMenuItemActionListener(new ActionListener(){
                        @Override
			public void actionPerformed(ActionEvent e){
				recup = e.getActionCommand();
				getVue(recup);
				//v.affiche("nom= "+recup);
			}
		});
	}
    
    public void getVue(String choix){

		switch(choix){
		case "Connection": connection()  ; break;
		case "Login":
			login();
			break;
		case "Send":
                {
                    try {
                        sendMessage();
                    } catch (RemoteException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
			break;
		case "Disconnect": 
                {
                    try {
                        disConnection();
                    } catch (RemoteException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
               break;
		case "Fermer" :
			System.exit(0);
			break;
		default:;break;
		}
	}
    
   
    public void connection(){
     
      
      
                v.getConnectionView().setVisible(true);
                v.getButtonConnection().setText("Disconnect");
                
                v.getScreemExchange().setVisible(true);
                System.out.println("debug connection");
                
                    
    }
    
    
    public void disConnection() throws RemoteException{
     
      
                if(m.disconnect(username)){
                      v.getButtonConnection().setText("Connection");
                }
                
                    
    }
    
    
    
    public void login(){
     
      
      
            
                username = v.getTextUsername().getText();
                 
                if(username!=null){
                     v.getOnline().append(username);
                     System.out.println("connected : "+username);
                     
                     if(m.connectServer()){
                  
                        v.getScreemExchange().setVisible(true);
                        
                   
                   
                     }
                    else{
                         System.out.println("not connection");
                     }
                }
                else
                    System.out.println("Enter username");
                
              }
   
    
    public void sendMessage() throws RemoteException{
        
        StringBuilder msg = new StringBuilder();
        if(v.getTextMessage().getText()!=null){
        msg.append(username).append(": ").append(v.getTextMessage().getText());
        v.getBoardscreem().append(msg.toString());
        m.sendMessage(msg.toString());
        //String msg = v.getTextMessage().getText();
        }
    }
    
}
