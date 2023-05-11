package tw.org.iii.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Brad64TCP {

	public static void main(String[] args) {
		byte[] buf = new byte[1024];
		try {
			
		DatagramSocket socket = new DatagramSocket(8888);//寫在裡面不用寫close
		DatagramPacket packet = new DatagramPacket(buf, buf.length);
		socket.receive(packet);//讓 DatagramSocket 等待接收一個 UDP 封包，並將封包儲存到剛剛創建的 DatagramPacket 物件中
		String urip = packet.getAddress().getHostAddress(); // 從 DatagramPacket 取得來源 IP 位址
		byte[] data = packet.getData(); // 從 DatagramPacket 取得資料的 byte array
		int len = packet.getLength(); // 從 DatagramPacket 取得接收到的資料長度
		String mesg = new String(data, 0, len); // 將接收到的 byte array 轉換成 String，從 0 開始，長度為 len
		System.out.println(urip+":"+mesg);
		System.out.println("receive ok:"+ urip);
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
