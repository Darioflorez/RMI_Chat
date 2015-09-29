package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.ActionHandler;

public class SendMessage extends UnicastRemoteObject implements ActionHandler{
	private static final long serialVersionUID = 1L;

	protected SendMessage() throws RemoteException {
		super();
	}

	@Override
	public String sendMessage() throws RemoteException {
		return "This is a server message!";
	}

	@Override
	public String getHelp() throws RemoteException {
		return "This is a help command!";
	}

}
