package SocketProgramming;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.io.*;
import java.net.*;


public class ServerEx2 extends JFrame{
	
	JTextArea ta;
	JTextField tf;
	JButton btSubmit;
	
	ServerSocket listener = null;
	Socket socket = null;
	
	BufferedReader in = null;
	BufferedWriter out = null;
	
	public ServerEx2() {
		super("채팅 서버");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ta = new JTextArea(10, 20);
		ta.setBorder(new LineBorder(Color.LIGHT_GRAY,3));
		
		JPanel p = new JPanel();
		tf =new JTextField(20);
		btSubmit = new JButton("전송");
		
		MyActionListener actionListener = new MyActionListener();
		tf.addActionListener(actionListener);
		btSubmit.addActionListener(actionListener);
		
		p.add(tf);
		p.add(btSubmit);
		
		Container c = getContentPane();
		c.add(new JScrollPane(ta), BorderLayout.CENTER);
		c.add(p, BorderLayout.SOUTH);
		
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				socketsClose();
			}
		});
		
		setSize(310, 300);
		setVisible(true);
		
		serverInit();
	}//end of ServerEx2()
	
	public void serverInit() {
		try {
			listener = new ServerSocket(9999);
			ta.append("연결을 기다리고 있습니다.\n");
			
			socket  = listener.accept();
			ta.append("연결 되었습니다.\n");
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				String inputMessage =in.readLine();
				if(inputMessage.equalsIgnoreCase("bye")) {
					ta.append("클라이언트에서 bye로 연결을 종료하였음\n");
					tf.setText("");
					tf.setEnabled(false);
					btSubmit.setEnabled(false);
					break;
				}
				ta.append("클라이언트 >> "+inputMessage+"\n");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			socketsClose();
		}
	}
	
	public void socketsClose() {
		try {
			if(socket!=null) {
				socket.close();
			}
			if(listener!=null) {
				listener.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	class MyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String outputMessage = tf.getText();
				ta.append("서버 : 나 >> "+outputMessage+"\n");
				tf.setText("");
				
				out.write(outputMessage+"\n");
				out.flush();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		new ServerEx2();
	}
}
