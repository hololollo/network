package sec3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
// 편집기(추가)
public class MyClient {
	public static void main(String[] args) {
		BufferedReader in = null; // 입력 스트림(메세지 받기)
		PrintWriter out = null; // 출력 스트림(메세지 보내기)
		
		Socket socket = null; // 클라이언트 쪽에서 서버소켓은 불필요
		Scanner sc = new Scanner(System.in);
		
		try {
			socket = new Socket("127.0.0.1", 6000); // 서버 연결
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
			while(true) { // 대화 반복
				System.out.println("전송하기 >>>");
				String outMsg = sc.nextLine();
				out.println(outMsg); // 보낼 메세지 저장
				out.flush(); // 메세지 발송
				if ("quit".equalsIgnoreCase(outMsg)) {
					break;
				}
				String inMsg = in.readLine(); // 받은 메세지 읽기
				System.out.println("[From Server]" + inMsg);
				if ("quit".equalsIgnoreCase(inMsg)) {
					break;
				}
			}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {// 컴퓨터 주소, 포트번호
				e.printStackTrace();
			} finally {
				try {
					sc.close();
					if(socket != null) {
						socket.close();
					}
					System.out.println("[서버연결종료]");
			   } catch (IOException e) {
					System.out.println("소켓통신 종료 오류");
					e.printStackTrace();
			   }
			}
		}
	}
