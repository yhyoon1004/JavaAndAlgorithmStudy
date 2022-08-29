package callback;

import java.util.function.Consumer;

public class callbackTest {
	public static void main(String[] args) {

		Consumer<Integer> callbackConfirm = new Consumer<Integer>() {
			@Override
			public void accept(Integer value) {
				if (value.intValue() == 1) {
					resultPrint();
				}
			}
		};

		System.out.println("main메서드에서 콜백 클래스의 calcMethod 메서드를 호출하는 과정");
		System.out.println("calcMethod(3,4,callbackConfirm) 실행");
		int calcValue = callbackMethodA.calcMethod(3,4,callbackConfirm);
		System.out.println("main메서드에서 처리 결과 출력");
		System.out.println("calcValue = " + calcValue);

		System.out.println("종료");

	}//end of main

	public static void resultPrint() {
		System.out.println("callbackTest.resultPrint");
		System.out.println("콜백 consumer 호출됨.");
	}
}
