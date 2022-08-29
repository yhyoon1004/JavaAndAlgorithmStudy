import java.io.*;

public class FileWiterEx {
	public static void main(String[] args) {
		InputStreamReader in = new InputStreamReader(System.in);
		
		FileWriter fout = null;
		int c;
		try {
			fout = new FileWriter("c:/Temp/test.txt");
			while((c=in.read())!= -1) {
				fout.write(c);
			}
			in.close();
			fout.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
