package sec3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	private static String rData;
	//rData 변수는 사용자가 입력한 데이터를 저장하기 위한 String입니다. 
	private static BufferedReader file;
	//file 변수는 사용자 입력을 받기 위한 BufferedReader입니다.
	private static int SERVER_PORT = 7980;
	//SERVER_PORT 변수는 서버의 포트 번호를 저장합니다.
	public static void main(String[] args) {
		//프로그램의 진입점(main 메서드)을 정의합니다.
		DatagramSocket socket = null;
		DatagramPacket packet = null;
		// DatagramSocket과 DatagramPacket 객체를 선언합니다. DatagramSocket은 UDP 소켓을 나타내며, DatagramPacket은 데이터 패킷을 나타냅니다.
		String rip = "192.168.20.213";
		try {
			//송신
			InetAddress ip = InetAddress.getByName(rip);
			socket = new DatagramSocket(SERVER_PORT);
			// 송신을 위해 서버의 IP 주소를 InetAddress 객체로 변환하고, 소켓을 생성합니다.
			
			System.out.print("[Message] : ");
			file = new BufferedReader(new InputStreamReader(System.in));
			rData = file.readLine();
			// 사용자에게 메시지를 입력하도록 안내하고, BufferedReader를 사용하여 사용자 입력을 읽어와 rData 변수에 저장합니다.
			
			byte[] buffer = rData.getBytes();
			packet = new DatagramPacket(buffer, buffer.length, ip, SERVER_PORT);
			socket.send(packet);
			//rData를 바이트 배열로 변환하여 DatagramPacket을 생성하고, 해당 패킷을 서버에 송신합니다.
			
			// 수신
			buffer = new byte[512];
			packet = new DatagramPacket(buffer, buffer.length);
			socket.receive(packet);
			String pData = new String(packet.getData());
			System.out.println("[Server IP Address] : " + packet.getAddress());
			System.out.println("[Server PORT] : " + packet.getPort());
			System.out.println("수신된 데이터 : " + pData);
			// 수신을 위해 새로운 DatagramPacket을 생성하고, 해당 패킷을 사용하여 서버로부터 데이터를 수신합니다. 수신된 데이터와 서버의 IP 주소, 포트 번호를 출력합니다.
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
