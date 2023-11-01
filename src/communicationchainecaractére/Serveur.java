package communicationchainecaractére;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {

	public static void main(String[] args) {
		try {
			System.out.println("je suis un serveur");

			ServerSocket ss = new ServerSocket(1234);
			int res = 0;// Création d'une nv socket
			System.out.println("j'attend un client..");
			Socket s = ss.accept();// Acceptation de la demande du client
			System.out.println("un client est connecté");
			int op1,op2;String operation;
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader bf=new BufferedReader(isr);
			op1 =Integer.parseInt(bf.readLine());//le résulatat de ce redline sera un string on va utiliser le casting
			op2 =Integer.parseInt(bf.readLine());
			operation=bf.readLine();
			switch(operation) {
			case "+":
			    res=op1+op2;
			break;
			case "-":
				res=op1-op2;
				break;
			case "*":
				res=op1*op2;
				break;
			case "/":
				res=op1/op2;
				break;
			}
			PrintWriter pw=new PrintWriter(os,true);
			pw.println(res);
			System.out.println("déconnexion serveur");
			s.close();// couper le liaison entre le client et le serveur
			ss.close();// libérer le port
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
