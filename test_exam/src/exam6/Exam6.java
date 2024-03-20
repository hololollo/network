package exam6;
/*
 문제6. TCP 소켓을 사용하여 아래의 요구사항에 맞게 클라이언트에서 서버로 연결 처리하는 네트워크 프로그램을 구동하였으나 서버와 연결이 되지 않았다. 
문제점이 있는 코드를 찾아 [원인](50점)에 파악된 문제점을 기술하고, 해결 방안을 구상하여 [조치내용](50점)에 해결방법을 작성하여 보고서를 완성하시오. (100점)

- 서버 IP : 127.0.0.1, 포트번호 : 3000

[클라이언트용 프로그래밍 코드]
package kr.or.iei.run;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class Client {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = null;
		PrintWriter pw = null;
		Socket socket = null;
		int port = 3000;
		try {
			socket = new Socket(port);
			if(socket != null) {
				System.out.println("[Client]");
				System.out.println("서버와 연결 성공!");
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(socket.getOutputStream());
			// 이하 코드는 중간 생략..

			}
		}
	}
}

[서버용 프로그래밍 코드]
package kr.or.iei.run;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Server {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = null;
		PrintWriter pw = null;
		int port = 3333;
		String serverIP = "127.0.0.1";
		ServerSocket server = null;
		try {
			server = new ServerSocket(serverIP, port);
			System.out.println("[Server]");
			System.out.println("클라이언트의 요청을 기다리고 있습니다...");
			System.out.println(socket.getInetAddress().getHostAddress() + " 가 연결을 요청함...");
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter((socket.getOutputStream()));
		// 이하 코드는 중간 생략..
		}
	}
}
 */
public class Exam6 {
	public static void main(String[] args) {

	}

}
