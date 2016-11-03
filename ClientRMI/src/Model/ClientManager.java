package Model;


import Model.ManageInterface;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brasc
 */
public class ClientManager {
    private ManageInterface manage;
    
    
    public boolean connectServer() {
        try {
            
            Registry registry = LocateRegistry.getRegistry("rmi://127.0.0.1/MessageDirectory", 1099);
            manage = (ManageInterface) registry.lookup("tchatManager");
            //this.manage.connection(login);
            System.out.println("Connected to server");
            return true;
        } catch (Exception e) {
           // this.showErrorMessage();
           return false;
        }
    }

    public String  sendMessage( String msg) throws RemoteException {
        return manage.sendMessage(msg);
    }  
    
   
    public boolean disconnect( String login) throws RemoteException {
       
               return manage.disconnect(login);

    }
    
    public void listUsers(String user) throws RemoteException{
    
               // manage.getMessageList().add(user);
    }
  /*****************************************************  
    
    private TchatManager tchatManager;
    private LoginForm logingView;
    private TchatForm tchatView;
    private NewDiscussionForm newDiscussionView;
    private String loginUser;
    private RefreshTchat refreshTchat;
    private Thread refreshThread;

    public Controller() {
        this.logingView = new LoginForm();
        this.tchatView = new TchatForm(this);
        this.newDiscussionView = new NewDiscussionForm();
        this.logingView.setVisible(true);
        this.setListenerToButton();

    }

    private void setObserver() {
        this.refreshTchat.addObserver(tchatView);
    }

    private void setListenerToButton() {
        this.logingView.setConnectionButtonActionListener(this);
        this.tchatView.setSendMessageButtonActionListener(this);
        this.tchatView.setDisconnectButtonActionListener(this);
        this.tchatView.setShowAddDiscussionButtonActionListener(this);
        this.newDiscussionView.addActionListenerButtonAddDiscussion(this);
    }

    private void connectServer() {
        try {
            Registry registry = LocateRegistry.getRegistry(this.logingView.getIpAddress(), 1099);
            tchatManager = (TchatManager) registry.lookup("tchatManager");
            this.tchatManager.addPublicDiscussion("public");
            System.out.println("Connected to server");
        } catch (Exception e) {
            this.showErrorMessage();
        }
    }

    private void showTchatview() {
        if (this.tchatView == null) {
            this.tchatView = new TchatForm(this);
        }
        this.tchatView.setVisible(true);
    }

    private void showLoginView() {
        if (this.logingView == null) {
            this.logingView = new LoginForm();
        }
        this.logingView.setVisible(true);
    }

    private void showAddDiscussionView() {
        if (this.newDiscussionView == null) {
            this.newDiscussionView = new NewDiscussionForm();
        }
        this.newDiscussionView.setVisible(true);
    }

    
    /**
     * This method manage the client connection to the chat server.
     * This method activ the thread, this thread is used to refresh the GUI
     */
  /*  private void connectToTchat() {
        try {
            this.connectServer();
            if (!logingView.getLogin().equals("") && this.tchatManager.connection(logingView.getLogin())) {
                this.refreshTchat = new RefreshTchat(tchatManager);
                this.setObserver();
                this.loginUser = logingView.getLogin();
                this.logingView.setVisible(false);
                this.showTchatview();
                this.refreshTchat.startThread();
                this.refreshThread = new Thread(refreshTchat);
                this.refreshThread.start();

            } else {
                this.logingView.setLbErrorConnection("An error has appeared during the connection");
                this.logingView.repaint();
            }
        } catch (RemoteException | NullPointerException ex) {
        }

    }

    private void showErrorMessage() {
        JOptionPane.showMessageDialog(tchatView, "The server seems to be offline");
    }

    public void disconnectFromTchat() {
        try {
            if (this.tchatManager.disconnect(loginUser)) {
                this.tchatView.setVisible(false);
                this.refreshTchat.stopThread();
                this.logingView.setLbErrorConnection("");
                this.showLoginView();
            }
        } catch (RemoteException ex) {
            this.showErrorMessage();
        }

    } */

   /* private void sendMessage() {
        try {
            StringBuilder createMessage = new StringBuilder();
            createMessage.append(loginUser).append(": ").append(this.tchatView.getMessageToSend());
            HashMap<String, List<String>> messagelist = this.tchatManager.sendMessage(this.tchatView.getActualDiscussion(), createMessage.toString());
            this.refreshTchat.setMessageList(messagelist);
        } catch (RemoteException ex) {
            this.showErrorMessage();
        }
    }   */

   /* private void addDiscussion() {
        try {
            this.tchatManager.addPublicDiscussion(this.newDiscussionView.getTfDiscussionTitle());
            this.newDiscussionView.setTfDiscussionTitle("");
            this.newDiscussionView.setVisible(false);
        } catch (RemoteException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  */

   /* @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logingView.getBtConnection()) {
            this.connectToTchat();
        } else if (e.getSource() == tchatView.getButtonDisconnect()) {
            this.disconnectFromTchat();
        } else if (e.getSource() == tchatView.getButtonSend()) {
            this.sendMessage();
        } else if (e.getSource() == newDiscussionView.getButtonAddDiscussion()) {
            this.addDiscussion();
        } else if (e.getSource() == tchatView.getButtonShowAddDiscussion()) {
            this.showAddDiscussionView();
        }
    } 

    
    *************************************************/
}
