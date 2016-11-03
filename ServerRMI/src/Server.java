
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author snyoneng
 */
public class Server {
    
    public Server() {
		try {
			Registry registry =LocateRegistry.createRegistry(1099);
			ManageInterface manager= new ServerManager();
			ManageInterface server = (ManageInterface) UnicastRemoteObject.exportObject(manager, 0);
			//registry.rebind("tchatManager", stub);
                        
                        Naming.rebind("tchatManager", server);
                    
			System.out.println("Server is running");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
    
    public static void main(String[] args) {
        // TODO code application logic here
        Server server = new Server();
    }
    
}
