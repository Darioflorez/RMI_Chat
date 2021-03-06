package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import client.Notifiable;
import common.ActionHandler;

public class SendMessage extends UnicastRemoteObject implements ActionHandler{
	private static final long serialVersionUID = 1L;
	private ArrayList<Notifiable> clientList = null;
    	private String currentMsg;

	protected SendMessage() throws RemoteException {
		super();
		clientList = new ArrayList<Notifiable>();
	}

	@Override
	synchronized public void sendMessage(String msg) throws RemoteException {
        	currentMsg=msg;
        	for(Notifiable n : clientList) {
            		n.notifyNewMessage(msg);
        	}
    	}

	@Override
	public String getHelp() throws RemoteException {
		String space = "               ";
        	String commands = "Available commands:" + "\n";
        	String help = "/help" + space + ": return a list of all available commands" + "\n";
        	String who = "/who" + space + ": return a list of all connected clients" + "\n";
        	String nick = "/nick <nickname>" + space + ": set a nick name for this client" + "\n";
        	String quit = "/quit" + space + ": disconnect this client" + "\n";
        	commands += space + help;
        	commands += space + who;
        	commands += space + nick;
        	commands += space + quit;

        	return commands;
	}
	
	@Override
    	public void registerForNotification(Notifiable n) throws RemoteException {
        	clientList.add(n);
        	System.out.println(clientList.size());
    	}

    	@Override
    	public void deRegisterForNotification(Notifiable n) throws RemoteException {
        	clientList.remove(n);
        	System.out.println(clientList.size());
    	}

}
