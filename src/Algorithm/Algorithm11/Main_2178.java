package Algorithm.Algorithm11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2178 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] MiroSize = br.readLine().split(" ");
		int MiroX = Integer.parseInt(MiroSize[0]);
		int MiroY = Integer.parseInt(MiroSize[1]);

		boolean[][] Miro = new boolean[MiroX][MiroY];
		String target;
		for (int i = 0; i < MiroX; i++) {
			target = br.readLine();
			for (int j = 0; j < MiroY; j++) {
				Miro[i][j] = target.charAt(j) == '1' ? true : false;
			}
		}//end of for 미로초기화



	}//end of main

	static int detect(boolean[][] targetMiro){



		return 1;
	}

}//end of class
