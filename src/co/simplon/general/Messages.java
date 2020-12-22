package co.simplon.general;


import java.util.ArrayList;

public class Messages {
	public static ArrayList<String> listDeMessages = new ArrayList<String> ();
	
	public static void effaceMessages() {
		
		listDeMessages.clear();
		
	}
	
	public static void 	addErrorMessage(String msg) {
		
		listDeMessages.add(msg);
		
	}
	
	public static void 	addInfoMessage(String msg) {
		
		listDeMessages.add(msg);
		
	}
	
	
	public static ArrayList<String>  getListMessages() {
		
		return listDeMessages;
		
	}

}
