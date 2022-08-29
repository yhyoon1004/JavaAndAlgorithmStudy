package report;
import java.io.*;
public class ch12_report01 {
	public static void main(String[] args) {
		File target = new File("c:/Temp/sample.txt");
//		읽어드린 값을 출력할 문자열 변수 선언
		String content = "";
		try {//파일, 스레드 , 입출력, 네트워크는 예외발생하므로 try-catch문으로 예외처리 
			FileReader input = new FileReader(target);
			//읽어 드릴 내용을 저장할 참조변수 선언 read()메서드는 반환 타입이 int이므로
			int c;
			//read()메서드에서 읽어드릴 값이 없으면 -1을 반환하므로 -1이면 빠져나옴
			while((c=input.read())!=-1) {
//				읽어드린 문자값을 저장
				content+=(char)c;
			}
			//다 읽어드렸으면 스트림 닫아주기
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//받아온 값을 출력
		System.out.println(content);
	}
}
