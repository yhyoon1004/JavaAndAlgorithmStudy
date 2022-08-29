package ch12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RunnableTimerEx extends JFrame implements Runnable{
	int n = 0;
	JLabel label= new JLabel();
	
	@Override
	public void run() {
		while (true) {
			String num = n + "";
			label.setText(num);
			n++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
		}
	}
	RunnableTimerEx() {
		setTitle("타이머");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = getContentPane();
		con.setLayout(new FlowLayout());
		con.add(label);
		
		setVisible(true);
		setSize(300,300);

		Thread th = new Thread(this);
		th.start();
	}

	public static void main(String[] args) {
		new RunnableTimerEx();
	}

}
