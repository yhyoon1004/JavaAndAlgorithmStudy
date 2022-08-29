package JavaSwingLecture;

import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class VibratingFrame extends JFrame implements Runnable {
	private Thread th;

	public VibratingFrame() {
		setTitle("진동하는 프레임 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 200);
		setLocation(300, 300);
		setVisible(true);
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (!th.isAlive()) {
					th.interrupt();
				}
			}
		});

		th = new Thread(this);
		th.start();
	}

	@Override
	public void run() {
		Random r = new Random();
		while (true) {
			try {
				Thread.sleep(20);
			} catch (Exception e) {
				return;
			}

			int x = getX() + r.nextInt() % 5;
			int y = getY() + r.nextInt() % 5;
			setLocation(x, y);
		}
	}

	public static void main(String[] args) {
		new VibratingFrame();
	}
}
