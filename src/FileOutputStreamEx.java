import java.io.*;

public class FileOutputStreamEx {
	public static void main(String[] args) {
		byte[] b= {7,51,3,4,-1,24};

		byte[] b02 = new byte[6];
		
		
		try {
			FileOutputStream fout = new FileOutputStream("c:/Temp/test.out");
		
				fout.write(b);
				
				FileInputStream fin = new FileInputStream("c:/Temp/test.out");
				fin.read(b02);
				
				fout.close();
				fin.close();
			
		} catch (Exception e) {
			System.out.println("c:\\Temp\\test.out을 저장하였습니다.");
		}
		System.out.println("c:\\Temp\\test.out을 저장하였습니다.");
		
		for(byte c: b02) {
			System.out.print(c+" ");
		}
	}
}
