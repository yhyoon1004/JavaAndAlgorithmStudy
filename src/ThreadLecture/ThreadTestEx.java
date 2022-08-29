package ThreadLecture;

class ThreadTest extends Thread {
	public ThreadTest(String str) {
		setName(str);
	}

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println(i + getName());
		}
	}
}

public class ThreadTestEx {
	public static void main(String[] args) throws Exception{
		ThreadTest th1 = new ThreadTest("Hi");
		ThreadTest th2 = new ThreadTest("Hello World");
		System.out.println("*****스레드 시작*****");
		th1.start();
		th2.start();
		th1.join();
		th2.join();
		System.out.println("*****스레드 종료*****");
		
	}
}
