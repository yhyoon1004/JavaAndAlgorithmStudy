package Algorithm.Algorithm08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main_1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Map<Integer, Integer> printerPool = new HashMap<>();
		int testCase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCase; i++) {
			String[] test = br.readLine().split(" ");
			int document = Integer.parseInt(test[0]);
			int targetDocument = Integer.parseInt(test[1]);//순서를 알고싶은 문서 인덱스
			for (int j = 0; j < document; j++) {
				String[] pool = br.readLine().split(" ");
				printerPool.put(j, Integer.parseInt(pool[j]));//문서 순서를 넣어줌
			}//end of for j
			int max;
			int count;
			for (int k = 1; k < printerPool.size(); k++) {
				max = 0;
				max = (printerPool.get(k) >=  printerPool.get(max)) ? k : max;
				//k 인덱스의 우선순위가  인덱스
			}
		}//end of for i


	}//end of main
}
