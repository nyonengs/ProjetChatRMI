
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brasc
 */
public class ServerManager extends UnicastRemoteObject implements ManageInterface {

    
    private ArrayList userlist;
    public ServerManager() throws RemoteException {
        super();
        this.userlist = new ArrayList<>();
    }

    
   
    @Override
    public boolean connection(String login) throws RemoteException {
       if (checkUser(login)) {
            return false;
        }
        this.userlist.add(login);
        return true;
    }

    @Override
    public boolean disconnect(String login) throws RemoteException {
         if (this.userlist.contains(login)) {
            this.userlist.remove(login);
            return true;
        }
        return false;
    }

    @Override
    public String sendMessage(String msg) throws RemoteException {
        return  checkLenghtMessage(msg);
    }
     
    private String checkLenghtMessage(String msg){
         
        if(msg.length()> 256){
            return msg.substring(0, 255);
        }
       return msg;
    }
    
    private boolean checkUser(String login) throws RemoteException {
        return this.userlist.contains(login);
    }

    @Override
    public ArrayList<String> getUsersList() throws RemoteException {
          //userlist.add(user);
         return userlist;
    }
}
