package ch08;

import java.awt.*;
import javax.swing.*;

public class practice01 extends JFrame{
	practice01(){
		setTitle("배치관리자");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//컨테이너 참조변수로 컨탠트 팬을 받아줌
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		con.add(new JButton("add"),BorderLayout.NORTH);
		con.add(new JButton("sub"),BorderLayout.WEST);
		con.add(new JButton("mul"),BorderLayout.EAST);
		con.add(new JButton("div"),BorderLayout.SOUTH);
		con.add(new JButton("calculate"),BorderLayout.CENTER);
		
		setSize(300,200);
		setVisible(true);
	}

	
	
	
	public static void main(String[] args) {
		new practice01();
	}
}
