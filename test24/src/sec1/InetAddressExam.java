package sec1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExam {
	public static void main(String[] args) {
		InetAddress test = null; // null로 초기화(기본값)
		try {
			test = InetAddress.getLocalHost(); // 현재 로컬 컴퓨터
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		System.out.println("현재 로컬 컴퓨터의 네트워크 정보");
		System.out.println(test.getHostName() + " " + test.getHostAddress());
		
		InetAddress google_address = null;
		try {
			google_address = InetAddress.getByName("www.google.com"); // 도메인 네임
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		System.out.println("\nGoogle 서버의 네트워크 정보");
		System.out.println(google_address);
		
		InetAddress naver_addr = null;
		try {
			InetAddress[] iArr = InetAddress.getAllByName("www.naver.com"); // 구글 서버 컴퓨터(서버 주소) 배열에 저장.
			for(InetAddress addr : iArr) {
				System.out.println("\nnaver 서버 주소");
				System.out.println(addr.getHostAddress()); // getAddress : 데이터 주소만 반환 / getHostAddress : 서버주소 값을 반환
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
	}

