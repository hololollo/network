package sec2;
// 다자간 채팅(멀티 서버용 스레드)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReceiveThread extends Thread { // 있는것을 내용만 바꿀 때
	//동기화 컬렉션 : collections.synchronizedList ... : 여러 사용자가 현재 목록을 공유(static) 하고 있어야 한다.
	static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<>()); //여러 사용자의 정보, 메세지 정보를 공유, 저장하는 공간이 필요 Collections = list, set, map ....
	
	Socket socket = null; // 비교하기 위해서 null로 처리. (null이 아니면 닫는다 등..)
	BufferedReader in = null;
	PrintWriter out = null;
	
	//socket을 주고받는 생성자
	public ReceiveThread(Socket socket) {
		this.socket = socket;
		
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 읽어와라.
			out = new PrintWriter(socket.getOutputStream());
			list.add(out);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

	@Override
	public void run() {
		String name = "";
		try {
			name = in.readLine();
			System.out.println("[" + name + "]새로운 연결 생성");
			sendAll("[" + name + "]님이 들어오셨습니다.");
			
			while(in != null) {
				String inMsg = in.readLine();
				if("quit".equalsIgnoreCase(inMsg)) {
					break;
				} 
				sendAll(name + ">>" + inMsg);
			}
		} catch (IOException e) {
			System.out.println("[" + name + "접속 끊김]");
			e.printStackTrace();
		}finally {
			System.out.println("[" + name + "]님이 나가셨습니다.");
			list.remove(out);
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("[" + name + "연결 종료]");
	}
	
	private void sendAll(String s) {
		for(PrintWriter out: list) {
			out.println(s);
			out.flush();
		}
	}

}
