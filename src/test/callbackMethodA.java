package test;

import java.util.function.Consumer;

public class callbackMethodA {
	public static int calcMethod(int A, int B , Consumer callback){
		System.out.println("calcMethod 호출됨");

		System.out.println("calcMethod에서  callback.accept(1) 실행");
		callback.accept(1);
		System.out.println("콜백 수행 후 return A+B");
		return A+B;
	}
}
