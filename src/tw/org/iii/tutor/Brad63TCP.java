package tw.org.iii.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Brad63TCP {
//TCP不能平行傳送多個連線請求
	public static void main(String[] args) {

		byte[] data = "Xin chào".getBytes();
		try {
			DatagramSocket socket = new DatagramSocket(); // 插座
			DatagramPacket packet = new DatagramPacket(
					data, data.length, InetAddress.getByName("10.0.104.255"), 8888);
			//DatagramPacket(byte[] buf, int length, InetAddress address, int port)
			//網域最後一碼是255，255可以廣播      //255是一个特殊的值，它表示广播地址。
			// 構造一個數據報包，用於將長度為 length 的數據包發送到指定主機上的指定端口(port)號(0~65535)。
			//DatagramSocket 類別用於建立 UDP socket 並接收或傳送資料。
			//DatagramPacket 類別則用於封裝 UDP 封包，包含了傳送或接收的資料、目的地 IP 位址和埠號等資訊。
			socket.send(packet);
			socket.close();
			System.out.println("ok");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
