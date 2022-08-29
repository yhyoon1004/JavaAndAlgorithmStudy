package ThreadLecture;

public class ThreadMainEx {
	public static void main(String[] args) {
		Thread th = new Thread();
		th.start();
		long id = Thread.currentThread().getId();
		String name = Thread.currentThread().getName();
		int priority = Thread.currentThread().getPriority();
		Thread.State s = Thread.currentThread().getState();
		
		System.out.println("현재 스레드 이름 ="+id);
		System.out.println("현재 스레드 ID ="+name);
		System.out.println("현재 스레드 우선순위 값 ="+priority);
		System.out.println("현재 스레드 상태 ="+s);
	}
}
