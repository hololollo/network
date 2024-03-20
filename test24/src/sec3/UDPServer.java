package sec3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {

	public static void main(String[] args) {
		DatagramSocket socket = null;
		DatagramPacket packet = null;
		int port = 7980;
		try {
			// 수신
			socket = new DatagramSocket(port);
			// 지정된 포트(7980)를 사용하여 DatagramSocket을 생성합니다. 이 소켓은 클라이언트로부터 데이터를 수신하기 위해 사용됩니다.
			while(true) {
				//서버가 계속해서 클라이언트로부터 데이터를 수신할 수 있도록 합니다.
				byte[] buffer = new byte[512];
				packet = new DatagramPacket(buffer, buffer.length); // 보낼데이터, 개수
				// 512바이트 크기의 바이트 배열인 buffer를 생성하고, DatagramPacket을 생성하여 buffer와 같은 길이의 배열을 사용합니다. 
				// 이 패킷은 데이터를 수신하기 위한 용도로 사용됩니다.
				System.out.println("ready");
				socket.receive(packet); // 실린 수신 데이터 패킷 받기
				// DatagramSocket을 사용하여 클라이언트로부터 데이터 패킷을 수신합니다.
				String rData = new String(packet.getData()); // 수신된 패킷(byte) 데이터 => String으로 형 변환
				System.out.println("수신 데이터 : " + rData); // 형 변환된 패킷 데이터를 출력
				
				//현재 ip주소, 포트번호 출력 (클라이언트의 IP 주소와 포트 번호를 얻어와서 출력합니다.)
				InetAddress ip = packet.getAddress();
				port = packet.getPort();
				System.out.println("[Client IP Address]" + ip);
				System.out.println("[Client port]" + port);
				
				// 원래 데이터에 추가(송신)
				// 수신한 데이터를 다시 클라이언트로 보내는 DatagramPacket을 생성하고, 이를 사용하여 클라이언트에게 데이터를 다시 전송합니다.
				packet = new DatagramPacket(packet.getData(), packet.getData().length, ip, port);
				socket.send(packet); // 송신 데이터 패킷 실어 보내기
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	} // while 끝.
	
} // main 메서드 끝.
