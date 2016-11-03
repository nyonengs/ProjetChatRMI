
import java.rmi.Remote;
import java.rmi.RemoteException;
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
public interface ManageInterface extends Remote{
   // public void addClient(ClientInterface cl) throws RemoteException;
    public boolean connection(String login) throws RemoteException;
    public boolean disconnect(String login) throws RemoteException;
    public String sendMessage(String msg) throws RemoteException;
    public ArrayList<String> getUsersList() throws RemoteException;
}
