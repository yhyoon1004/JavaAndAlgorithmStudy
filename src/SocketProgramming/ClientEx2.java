package SocketProgramming;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.io.*;
import java.net.*;


public class ClientEx2 extends JFrame{
	
	JTextArea ta;
	JTextField tf;
	JButton btSubmit;
	
	Socket socket = null;
	
	BufferedReader in = null;
	BufferedWriter out = null;
	
	public ClientEx2() {
		super("채팅 클라이언트");
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
		
		clientInit();
	}//end of ServerEx2()
	
	public void clientInit() {
		try {
			socket = new Socket("localhost", 9999);
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				String inputMessage =in.readLine();
				ta.append("서버 >> "+inputMessage);
				if(inputMessage==null)continue;
			}//end of while
			
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	class MyActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String outputMessage = tf.getText();
				ta.append("클라이언트 : 나 >> "+outputMessage+"\n");
				tf.setText("");
				
				out.write(outputMessage+"\n");
				out.flush();
				
				if(outputMessage.equalsIgnoreCase("bye")) {
					tf.setEnabled(false);
					btSubmit.setEnabled(false);
					socketsClose();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		new ClientEx2();
	}
}
