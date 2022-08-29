package StreamPractice;

import java.io.*;
import java.util.Arrays;

public class Ex15_3 {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		byte[] temp = new byte[4];
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		System.out.println("Input Source : "+Arrays.toString(inSrc));
		
		try {
			while(input.available()>0) {//input스트림에서 읽어들일 수 있는 스트림 크기가 0보다 크면
				input.read(temp);//input스트림에서 temp배열의 크기만큼 읽어드림
				output.write(temp);//output스트림에서 읽어들인 값을 temp에 write함

				outSrc = output.toByteArray();//outSrc에 outstream값을 배열로 넣어줌
				printArrays(temp,outSrc);
			}
		} catch (IOException e) {
			
		}
		
	}

	private static void printArrays(byte[] temp, byte[] outSrc) {
		System.out.println("temp        :"+Arrays.toString(temp));
		System.out.println("Output Source:"+Arrays.toString(outSrc));
		
	}
}
