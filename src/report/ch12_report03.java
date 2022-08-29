package report;
import java.io.*;
public class ch12_report03 {
	public static void main(String[] args) {
		//디렉토리, 경로명을 file객체에 줌
		File dir = new File("c:\\");
		//위에서 만든 디렉토리 파일객체를 사용해서 파일객체 배열에 listFiles메서드로 
		//해당 디렉토리에 파일들을 객체로 담아줌
		File[] dirList = dir.listFiles();
		//비교를 위해 사용할 파일 객체 생성 배열의 첫번째 것으로 넣어줌
		File temp =dirList[0];
		//반복문으로 dirlist파일 객체의 크기만큼 반복
		for(int i =1; i<dirList.length; i++) {
			//.length메서드를 사용해 현재 담겨있는 temp파일 객체의 크기보다 크면 temp에 넣어줌
			if(dirList[i].length()>temp.length()) {
				temp = dirList[i];
			}
		}
		System.out.println("가장 큰 파일은 "+temp.getPath()+"이고 크기는 "+temp.length() );
	}
}
