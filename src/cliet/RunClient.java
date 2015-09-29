package cliet;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import common.ActionHandler;

public class RunClient {
	
	static String msg = "hej";
	static ActionHandler actionHandler = null;
	static boolean done = false;
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
			try {
				actionHandler = (ActionHandler)Naming.lookup("rmi://127.0.0.1/ActonHandler");
				msg = actionHandler.sendMessage();
				System.out.println("Server say: " + msg);
				msg = actionHandler.getHelp();
				System.out.println("Server say: " + msg);
				String msgOut = "";
				while(!done){
					System.out.print("> ");
					msgOut = scanner.nextLine();
					if( msgOut == null || msgOut.equals("/quit")){
						done = true;
						break;
					}
					if(msgOut.equals("/help")){
						System.out.println("----HELP----");
						msg = actionHandler.getHelp();
						System.out.println("Server say: " + msg);
					}
					
				}
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				scanner.close();
			} finally {
				scanner.close();
				System.out.println("Close connection!");
			}
		

	}

}
