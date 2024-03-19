package sec1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class ServerBack extends Thread {
	Vector<ReceiveInfo> clientList = new Vector<>(); // 클라이언트 쓰레드 목록 (List로 해도 무방.)
	List<String> nickNameList = new ArrayList<>(); // 클라이언트 대화명 목록
	ServerSocket serverSocket; // 서버 소켓
	Socket socket; // 일반 소켓
	private ChatServerGUI serverChatGui; // GUIserver 다음 창 이름 : ChatServerGUI
	
	public void setGUI(ChatServerGUI serverChatGui) {
		this.serverChatGui = serverChatGui;
	}
	
	public void startServer(int port) {
		try {
			Collections.synchronizedList(clientList); // 동기화
			serverSocket = new ServerSocket(port);
			System.out.println("현재 IP주소 : [" + InetAddress.getLocalHost() + "], " + "port 번호 : [" + port + "]");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		nickNameList.add("Admin"); // 관리자 추가
		try {
			while(true) { // 접속 대기 모드
				System.out.println("접속 대기중");
				socket = serverSocket.accept();
				System.out.println("["+socket.getInetAddress()+"]에서 접속하셨습니다.");
				ReceiveInfo receive = new ReceiveInfo(socket);
				clientList.add(receive);
				receive.start();
			}
		} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	
	public void transmitAll(String message) {
		for(int i = 0; i < clientList.size(); i++) {
			try {
				ReceiveInfo ri = clientList.elementAt(i);
				ri.transmitAll(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
		
	public void removeClient(ReceiveInfo client, String nickName) {
		clientList.removeElement(client);
		nickNameList.remove(nickName);
		System.out.println("목록에서" + nickName + "을 제거하였습니다.");
		serverChatGui.userList.setText(null);
		serverChatGui.appendUserList(nickNameList);
	}
	
	class ReceiveInfo extends Thread { // 받는사람(수신자) 목록, 이름, 메세지... 
		private DataInputStream in;
		private DataOutputStream out;
		String nickName;
		String message;
		
		public ReceiveInfo(Socket socket) {
			try {
				out = new DataOutputStream(socket.getOutputStream());
				in = new DataInputStream(socket.getInputStream());
				nickName = in.readUTF(); // 인코딩 (데이터문자를 읽을 수 있는 문자로 변환)
				nickNameList.add(nickName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// 쓰레드는 반드시 run()메서드를 오버라이드 해야한다.
		@Override
		public void run() {
			try {
				serverChatGui.userList.setText(null);
				serverChatGui.appendUserList(nickNameList);
				transmitAll(nickName+"님이 입장하셨습니다.\n");
				for(int i=0;i<nickNameList.size();i++) {
					transmitAll(nickName+nickNameList.get(i));
				}
				serverChatGui.appendMessage(nickName+"님이 입장하셨습니다.\n");
				while(true) {
					message = in.readUTF();
					serverChatGui.appendMessage(message);
					transmitAll(message);
				}
			} catch(Exception e) {
				System.out.println(nickName +"님이 퇴장하셨습니다.");
				removeClient(this, nickName);
				transmitAll(nickName + "님이 퇴장하셨습니다.");
				for(int i=0;i<nickNameList.size();i++) {
					transmitAll(nickName+nickNameList.get(i));
				}
				serverChatGui.appendMessage(nickName+"님이 퇴장하셨습니다.\n");
			}
		}
		public void transmitAll(String message) {
			try {
				out.writeUTF(message);
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
