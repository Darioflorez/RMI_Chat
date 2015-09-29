package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ActionHandler extends Remote{
	String sendMessage() throws RemoteException;
	String getHelp() throws RemoteException;
	//String setNick(String nickname) throws RemoteException;
}
