package ch12;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class TimerThread extends Thread {
	int n = 0;
	JLabel la;
	public TimerThread(JLabel label) {
		this.la=label;
	}
	@Override
	public void run() {
		while (true) {
			String num= n+"";
			la.setText(num);
			n++;
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
		}
		
	}//end of run
}


public class TestThread extends JFrame{
	JLabel label= new JLabel();
	
	TestThread(){
		setTitle("타이머");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		con.add(label);
		
		TimerThread th = new TimerThread(label);
		setVisible(true);
		setSize(300,300);
		th.start();
	}
	
	public static void main(String[] args) {
		new TestThread();
	}
}
