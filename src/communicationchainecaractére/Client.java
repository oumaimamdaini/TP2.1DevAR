package communicationchainecaractére;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class Client {

	public static void main(String[] args) {

		try {

			Socket s = new Socket("localhost",1234);
			System.out.println("je suis un client pas encore connecté");
			// Socket s =new Socket("192.168.1.17",4000); //Connexion d'un client
			System.out.println("je suis connecté au serveur");
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			int op1, op2;
			String operation;
			Scanner scanner = new Scanner(System.in);// 1
			op1 = scanner.nextInt();
			op2 = scanner.nextInt();
			do {
				System.out.println("donner l'opertion(+,-,*,/)");
				operation=scanner.nextLine();				
			}while(!operation.equals("+") && !operation.equals("-") && !operation.equals("*") && !operation.equals("/"));
			
			PrintWriter pw=new PrintWriter(os,true);
			pw.println(op1);
			pw.println(op2);
			pw.println(operation);
			System.out.println(op1+" "+"operation" +" "+op2+" = "+(new BufferedReader(new InputStreamReader(is))).readLine() );
			System.out.println("déconnexion client");
			s.close();// Déconnexion d'un client
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}