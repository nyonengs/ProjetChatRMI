
import Controller.Controller;
import Model.ClientManager;
import View.ChatView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author snyoneng
 */
public class Client {
    private ClientManager model;
    private ChatView vue;
    private Controller crtl;
    
    public Client(){
       model = new ClientManager();
       vue = new ChatView();
       crtl = new Controller(model,vue);
       crtl.appelMenu();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Client cl = new Client();
    }
}
