package explorer;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class FileExplorer {
	File current = new File("C:\\");

	public void list() {
		File[] listFiles = current.listFiles();
		if (listFiles == null || listFiles.length == 0) {
			System.out.println("No Files and No Directories");
			return;
		}
		for (File f : listFiles) {
			long lastModified = f.lastModified();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 d일 HH:mm:ss");
			System.out.println(sdf.format(new Date(lastModified)) + "\t");
			if (f.isDirectory()) {
				System.out.printf("<DIR>%24s\t", "");
			} else {
				DecimalFormat docFormat = new DecimalFormat("###,###");
				System.out.printf("%24s\t", docFormat.format(f.length()));
			}
			System.out.println(f.getName());
		}
	}

	public void changeDir(String dir) {
		if (dir.equals("..")) {
			chageToParent();
			return;
		}
		File f = new File(current.getPath(), dir);
		if (f.exists() && f.isDirectory()) {
			current = f;
		} else {
			System.out.println(dir + " 디렉토리는 존재하지 않습니다.");
		}
	}

	public void chageToParent() {
		if (current.getParent().equals("C:\\")) {
			System.out.println("C:\\는 루트디렉토리입니다.");
			return;
		}
		current = new File(current.getParent());
	}

	public void makeDir(String dir) {
		File f = new File(current.getPath(), dir);
		if(!f.exists()) {
			f.mkdir();
		}else {
			System.out.println(dir+"는(은) 이미 존재하는 디렉토리 입니다.");
		}
	}

	

	public void copy(String srcName, String destName) {
		File srcF = new File(current.getPath(),srcName);
		File destF = new File(current.getPath(),destName);
		
		if(!srcF.exists()) {
			System.out.println(srcName+"는(은) 존재하지 않습니다.");
			return;
		}else if(destF.exists()){
			System.out.println(destF.getPath()+"는(은) 이미 존재 합니다.");
		}else if(srcF.isDirectory()) {
			System.out.println(srcName+"는(은) 디렉토리입니다.");
			return;
		}
		BlockBinaryCopy bbc = new BlockBinaryCopy();
		bbc.copy(srcF, destF);
	}
	
	
	public FileExplorer() {
	}

	public void start() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("<< 파일 탐색기 명령어 >>");
		System.out.println("1. 파일 목록 보기: 		dir");
		System.out.println("2. 하위 디렉토리로 이동: 	cd 디렉토리명");
		System.out.println("3. 부모디렉토리로 이동: 	cd..");
		System.out.println("4. 디렉토리 만들기: 		mkdir New디렉토리명");
		System.out.println("5. 이름바꾸기: 		rename Old파일또는디렉토리명");
		System.out.println("6. 삭제: 			del 파일또는디렉토리명");
		System.out.println("7. 파일 복사: 		copy src파일명 dest파일명");
		System.out.println("8. 종료: 			exit");

		while (true) {
			System.out.print("\n" + current.getPath() + ">");

			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			boolean stop = false;
			try {
				switch (st.nextToken()) {
				case "dir":
					list();
					break;
				case "cd":
					changeDir(st.nextToken());
					break;
				case "mkdir":
					makeDir(st.nextToken());
					break;
				case "copy":
					copy(st.nextToken(),st.nextToken());
				case "exit":
					stop = true;
					break;
				default:
					System.out.println("잘못된 명령어 입니다.");
				}
			} catch (NoSuchElementException e) {
				System.out.println("명령어 사용법이 틀렸습니다. 명령어 사용법을 확인해 주세요.");
			}
			if (stop) {
				break;
			}
		}
	}


	public static void main(String[] args) throws IOException {
		FileExplorer explorer = new FileExplorer();
		explorer.start();
	}
}
