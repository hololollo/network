package exam4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
 문제 4. TCP 소켓을 사용하여 클라이언트에서 서버로 연결처리하는 네트워크 프로그램을 구동하였으나 서버와 연결이 되지 않았다. 문제점이 있는 코드를 찾아 
[원인](20점)에 파악된 문제점을 기술하고, 해결된 코드를 [조치내용](20점)에 해결방법을 작성하여 보고서를 완성하시오. (40점)

- 서버 IP : 각자 IP 주소, 포트번호 : 3000

[서버용 프로그래밍 코드]
코드는 Test4-1.png

[클라이언트용 프로그래밍 코드]
코드는 Test4-2.png
 */
public class Exam4_S {
	public static void main(String[] args) {
		BufferedReader in = null; 	// 읽기 입력 스트림(통신데이터)
		PrintWriter out = null; 	// 쓰기 출력 스트림(통신데이터)
		
		
		ServerSocket server = null; // (서버 소켓)나중에 서버를 닫아야 하기 때문에 기본적으로 null처리
		Socket socket = null; // 일반 소켓
		Scanner sc = new Scanner(System.in); // 키보드로 입력
		
		try {
			// 소켓이 열려있는지 여부를 확인하기 위해 try~catch사용
			server = new ServerSocket(3000); // try블록 바깥에 null로서 객체 생성을 해주고 포트번호를 입력
			System.out.println("[Server 실행] : Client 연결 대기 중 입니다.");
			Socket s = server.accept();
			System.out.println("[Cilent 연결]");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 읽어와라.
			out = new PrintWriter(socket.getOutputStream());
			
			while(true) {
				String inMsg = in.readLine(); // 한 줄씩 읽는다.
				if("quit".equalsIgnoreCase(inMsg)) { // 대소문자 구분 없이
					break;
				} 
				System.out.println("[From Client : ] " + inMsg);
				System.out.println("전송>>>");
				
				String outMsg = sc.nextLine();
				out.println(outMsg);
				out.flush(); // 비운다.
				if("quit".equalsIgnoreCase(outMsg)) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally { // 열어 놓은것의 역순으로 닫는다.
			
			try {
				sc.close();
				socket.close();
				server.close();
				System.out.println("연결 종료");
			} catch (IOException e) {
				System.out.println("소켓 통신 종료 오류");
				e.printStackTrace();
			}
			
		}
		
	}
}

