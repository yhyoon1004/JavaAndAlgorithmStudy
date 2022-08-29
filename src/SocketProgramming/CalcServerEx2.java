package SocketProgramming;

import java.io.*;
import java.net.*;
import java.util.*;

class CalcThread extends Thread{
	private Socket socket;
	
	public CalcThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			InetAddress inetAddress = socket.getInetAddress();
			String clientAddr = inetAddress.getHostAddress();
			System.out.println(clientAddr + " 로 부터 접속되었습니다.");
			
			BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				String inputMessage = in.readLine();
				if(inputMessage.equalsIgnoreCase("bye")) {
					System.out.println(clientAddr + " 클라이언트에서 연결을 종료하였음");
					break;
				}
				System.out.println(clientAddr+" 에서 받은 수식: "+inputMessage);
				String res = calc(inputMessage);
				out.write(res+"\n");
				out.flush();
			}//end of while
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(socket!=null) {
					socket.close();
				}
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}//end of finally
	}//end of run()
	
	public String calc(String exp) {
		StringTokenizer st = new StringTokenizer(exp, " ");
		if(st.countTokens()!=3) {
			return "error";
		}
		int op1  = Integer.parseInt(st.nextToken());
		String opcode = st.nextToken();
		int op2 = Integer.parseInt(st.nextToken());
		
		String res = "";
		switch(opcode) {
		case "+" : res = Integer.toString(op1+op2); break;
		case "-" : res = Integer.toString(op1-op2); break;
		case "*" : res = Integer.toString(op1*op2); break;
		default: res = "error";
		}
		return res;
		
	}//end of calc()
}//end of CalcThread


public class CalcServerEx2{
	
	
	public static void main(String[] args) {
		ServerSocket listener = null;
		try {
			listener = new ServerSocket(9999);
			System.out.println("연결을 기다리고 있습니다.");
			
			while(true) {
				Socket socket = listener.accept();
				CalcThread calcThread = new CalcThread(socket);
				calcThread.start();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(listener !=null) {
					listener.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}//end of Main
}
