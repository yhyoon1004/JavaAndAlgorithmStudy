package StreamLecture2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class TextCopy {
	public static void main(String[] args) {
		File src = new File("c:/windows/system.ini");
		File dest = new File("c:/Temp/system.txt");
		int c;
		try {
			FileReader fr = new FileReader(src);
			FileWriter fw = new FileWriter(dest);
			while ((c = fr.read()) != -1) {
				fw.write((char) c);
			}
			fr.close();
			fw.close();
			System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사하였습니댜.");
		} catch (Exception e) {
			System.out.println("파일 복사 오류");
		}
	}
}
