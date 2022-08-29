package report;

import java.io.*;

public class ch12_report05 {
	public static void main(String[] args) {
		//해당 위치의 디렉토리 파일객체 생성
		File target = new File("c:\\Temp");
		//listFiles()메서드로 파일 객체 배열 생성
		File[] targetList = target.listFiles();
		//반복문으로 해당 파일 객체리스트를 읽어드림
		for(int i= 0; i<targetList.length; i++){
			//String객체의 메서드 endsWith()메서드로 해당 문자열로 끝나는 
			//.txt로 끝나는 파일일경우 아래 명령문 수행
			if(targetList[i].getPath().endsWith(".txt")){
				 System.out.println(targetList[i].getPath()+" 삭제되었습니다.");
				 //파일 객체의 delete메서드 호출시
				 //SecurityException - If a security manager exists 
				 //and its SecurityManager.checkDelete(java.lang.String) 
				 //method deniesdelete access to the file
				 //위와같은 에러 발생로  try- catch처리 해줌
				 try {
					 targetList[i].delete();
				 }catch (SecurityException e) {
					 e.printStackTrace();
				 }
			}
		}
	}
}
