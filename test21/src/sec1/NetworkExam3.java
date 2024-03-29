package sec1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkExam3 {
	public static void main(String[] args) {
		//본인 컴퓨터의 ip주소와 컴퓨터이름 출력
		//www.google.com의 연결 IP주소를 출력
		try {
			InetAddress a =  InetAddress.getLocalHost(); // 현재 컴퓨터
			System.out.println("본인 컴퓨터 ip 주소 : " + a.getHostAddress()); // ip주소 출력
			System.out.println("네트워크상 본인 컴퓨터 이름 : " + a.getHostName()); // 컴퓨터 이름 출력
			InetAddress[] arr = InetAddress.getAllByName("www.google.com"); // 구글사이트 주소
			
			for(InetAddress b : arr) {
				System.out.println(b.getHostAddress()); // 구글의 ip주소
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
