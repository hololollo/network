package test22;
//1:1채팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
		public static void main(String[] args) {
			BufferedReader in = null; // 입력 스트림
			PrintWriter out = null; // 출력 스트림
			
			Socket socket = null;
			Scanner sc = new Scanner(System.in);
			
			try {
				socket = new Socket("192.168.20.206", 7009);
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream());
				
				while(true) {
					System.out.println("전송하기 >>>");
					String outMsg = sc.nextLine();
					out.println(outMsg);
					out.flush();
					if ("quit".equalsIgnoreCase(outMsg)) {
						break;
					}
					String inMsg = in.readLine();
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
