package report;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class practice03 extends JFrame {
	practice03(){
		super("실험");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btn01 = new JButton("1");
		System.out.println(btn01.getText());
		add(btn01);
		setSize(100,100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new practice03();
	}
}
