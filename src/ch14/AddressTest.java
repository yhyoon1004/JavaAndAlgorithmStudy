package ch14;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AddressTest {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress address1 = InetAddress.getLocalHost();
		System.out.println("로컬 컴퓨터 이름 "+address1.getHostName());
		System.out.println("로컬 컴퓨터 IP 주소"+address1.getHostAddress());
		
		InetAddress address2 = InetAddress.getByName("seoil.ac.kr");
		System.out.println("seoil.ac.kr 컴퓨터의 이름과 IP주소 : " +address2);
		InetAddress all []  = InetAddress.getAllByName("naver.com");
		for(int i=0; i<all.length; i++) {
			System.out.println(all[i]);
		}
	}
}
