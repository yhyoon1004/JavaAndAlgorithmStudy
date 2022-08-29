package ch09;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class practiceMouse extends JFrame {
	JLabel label = new JLabel("Move Me");
	
	practiceMouse(){
		super("마우스 이벤트 처리 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentpane = getContentPane();
		contentpane.setLayout(null);
		
		label.setLocation(10,10);
		label.setSize(100,20);
		contentpane.add(label);
		
		/*
		 * contentpane.addMouseListener(new MouseListenerA());
		 * contentpane.addMouseMotionListener(new MouseListenerA());
		 */
		setSize(400,300);
		setVisible(true);
		
	}
	
	/*
	 * class MouseListenerA implements MouseListener,MouseMotionListener {
	 * 
	 * @Override public void mouseDragged(MouseEvent e) {
	 * setTitle("MouseDragged("+e.getX()+", "+e.getY()+")");
	 * label.setLocation(e.getX(),e.getY()); }
	 * 
	 * @Override public void mouseMoved(MouseEvent e) { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 * 
	 * @Override public void mouseClicked(MouseEvent e) { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 * 
	 * @Override public void mousePressed(MouseEvent e) {
	 * setTitle("MouseDragged("+e.getX()+", "+e.getY()+")");
	 * label.setLocation(e.getX(),e.getY());
	 * 
	 * }
	 * 
	 * @Override public void mouseReleased(MouseEvent e) { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 * 
	 * @Override public void mouseEntered(MouseEvent e) { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 * 
	 * @Override public void mouseExited(MouseEvent e) { // TODO Auto-generated
	 * method stub
	 * 
	 * } }
	 */
	
	public static void main(String[] args) {
		new practiceMouse();
	}
}
