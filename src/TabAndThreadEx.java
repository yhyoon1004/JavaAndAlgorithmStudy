//import java.awt.*;
//import java.awt.Event;
//import javax.swing.*;
//
//
//class MyLabel extends JLabel{
//	int barSize=0;
//	int maxSize;
//	
//	MyLabel(int maxBarSize){
//		this.maxBarSize = maxBarSize;
//	}
//	
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		g.setColor(Color.magenta);
//		int width = (int)((double)getWidth()*barSize/maxBarSize);
//		if(width==0)return;
//		g.fillRect(0, 0, width, this.getHeight());
//	}
//
//	synchronized void fill() {
//		if(barSize==maxBarSize){
//			try {
//				wait();
//			} catch (Exception e) {
//				return;
//			}
//		}
//		barSize++;
//		repaint();
//		notify();
//	}
//	
//	synchronized void consume() {
//		if(barSize==0) {
//			try {
//				wait();
//			}catch(InterruptedException e) {
//				return;
//			}
//		}
//		barSize--;
//		repaint();
//		notify();
//	}
//}
//
//
//class ConsumerThread extends Thread{
//	MyLabel bar;
//	ConsumerThread Thread(MyLabel bar) {
//		this.bar=bar;
//	}
//	
//	public void run() {
//		while(true) {
//			try {
//				sleep(200);
//				bar.consume();
//			}catch(InterruptedException e) {
//				return;
//			}
//		}
//	}
//}
////
////public class TabAndThreadEx extends JFrame{
////	MyLabel bar = new MyLabel(100);
////	
////	public TabAndThreadEx() {
////		super(title);
////		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////		Container c = getContentPane();
////		c.setLayout(null);
////		bar.setBackground(Color.orange);
////		bar.setOpaque(true);
////		bar.setLocation(20, 50);
////		bar.setSize(300,20);
////		c.add(bar);
////		
////		c.addKeyListener(new KeyAdapter() {
////			
////		});
////	}
////}
