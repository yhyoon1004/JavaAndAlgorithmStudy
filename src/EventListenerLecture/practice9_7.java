package EventListenerLecture;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class practice9_7 extends JFrame {
	//이동시킬 레이블 컴포넌트 등록
	JLabel label = new JLabel("HELLO");
	
	
	practice9_7(){
		super("방향키로 레이블 이동 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentpane = getContentPane();
		//절대 위치 좌표로 레이블 동작할 것이기 때문에 배치관리자 삭제
		contentpane.setLayout(null);
		//컨텐트팬에 키리스너 등록하여 입력받게
		contentpane.addKeyListener(new keyListenerA());
		
		//레이블의 기본 좌표설정
		label.setLocation(10,10);
		label.setSize(100,20);
		//컨텐트펜에 레이블 요소 추가
		contentpane.add(label);
		
		setSize(300,200);
		setVisible(true);
		
		//컨텐트펜이 키보드입력 포커스객체를 가질 수 있도록 설정
		contentpane.setFocusable(true);
		//컨텐트펜에게 포커스를 줌
		contentpane.requestFocus();
	}
	
	class keyListenerA implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// 유니코드를 사용 안할 것이므로 생략
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				label.setLocation(label.getX(),label.getY()-10);
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				label.setLocation(label.getX(),label.getY()+10);
				
			}
			if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				label.setLocation(label.getX()-10,label.getY());
				
			}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				label.setLocation(label.getX()+10,label.getY());
				
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static void main(String[] args) {
		new practice9_7();
	}
}
