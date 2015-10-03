package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ActionHandler extends Remote{
	public void sendMessage(String msg) throws RemoteException;
	String getHelp() throws RemoteException;
	public void registerForNotification(Notifiable n) throws RemoteException;
    	public void deRegisterForNotification(Notifiable n) throws RemoteException;
	//String setNick(String nickname) throws RemoteException;
}
