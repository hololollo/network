package test22;
// 1:1 채팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Server {
	public static void main(String[] args) {
		// 서버를 만들려면 항상 포트번호가 있어야 한다.(고유) 보통은 Wellknown을 피해서 5~6000번대로 만든다.
				// 파일, 네트워크, db는 기본적으로 예외처리가 필요하다.
				BufferedReader in = null; 	// 읽기 입력 스트림(통신데이터)
				PrintWriter out = null; 	// 쓰기 출력 스트림(통신데이터)
				
				
				ServerSocket server = null; // (서버 소켓)나중에 서버를 닫아야 하기 때문에 기본적으로 null처리
				Socket socket = null; // 일반 소켓
				Scanner sc = new Scanner(System.in); // 키보드로 입력
				
				try {
					server = new ServerSocket(7009); // 소켓이 열려있는지 여부를 확인하기 위해 try~catch사용
					System.out.println("[Server 실행] : Client 연결 대기 중 입니다.");
					socket = server.accept(); // 일반 소켓(클라이언트가 연결이 가능한 상태 - 콘센트 역할)
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

