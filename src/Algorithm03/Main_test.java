package Algorithm03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_test {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String result="";
		String temp="";
		/*
		 * String[] number = new String[9] {"one","two","three",
		 * "four","five","six","seven","enight","nine" }; int change= 0;
		 */	
		for(int i=0; i<input.length();i++) {
			for(int j=0; j<10;j++) {
				if(input.charAt(i)-'0'==j) {
					result+=input.charAt(i);
				}
				else  {
					temp+=input.charAt(i);
				}//97 122
			}
			
		}
		
	}
}
