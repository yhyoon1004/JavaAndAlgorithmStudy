package SocketProgramming;

import java.net.*;
import java.io.*;
import java.util.*;

public class CalcServer {
	public static String calc(String exp) {
		StringTokenizer st = new StringTokenizer(exp);
		if(st.countTokens() !=3)return "error";
		
		String res = "";
		int op1 = Integer.parseInt(st.nextToken());
		String opcode = st.nextToken();
		int op2 = Integer.parseInt(st.nextToken());
		
		switch(opcode) {
		case "+": res = Integer.toString(op1+op2);break;
		case "-": res =Integer.toString(op1-op2);break;
		case "*": res =Integer.toString(op1*op2);break;
		default : res = "error";
		}
		return res;
	}

	public static void main(String[] args) {
		BufferedReader in =null;
		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		
		try {
			
			listener = new ServerSocket(9999);
			System.out.println("연결을 기다리고 있습니다....");
			socket =  listener.accept();
			System.out.println("연결되었습니다.");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out =  new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				String inputMessage = in.readLine();
				
				if(inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("클라이언트: "+inputMessage);
					break;
				}
				
				System.out.print("보내기>>");
				String res = calc(inputMessage);
				out.write(res+"\n");
				out.flush();
			}
			
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			try {
				scanner.close();
				socket.close();
				listener.close();
			} catch (IOException e2) {
				e2.printStackTrace();
				System.out.println(e2.getMessage());
			}
		}
	}//end Main
}
