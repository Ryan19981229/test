package tw.org.iii.tutor;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Brad67TCP {
//資料讀進來
//邊讀邊寫會比較慢，尤其是網際網路會比硬碟更慢
	public static void main(String[] args) {
		try {
		File source = new File("dir1/螢幕擷取畫面 2023-03-03 130205.png");
		BufferedInputStream bin = 
			new BufferedInputStream(
				new FileInputStream(source));
			byte [] buf = new byte[(int)source.length()];
			bin.read();
			
			
			//這裡直接用SocketOutputStreen也可以，不用寫BufferedOutputStream
			Socket socket = new Socket(
					InetAddress.getByName("10.0.104.56"),9999);
			//使用TCP發送端傳送，可靠度比較好
			BufferedOutputStream bout = 
					new BufferedOutputStream(socket.getOutputStream());
			//使用BufferedOutputStream演算法會比較有效
			bout.write(buf);
			bout.flush();
			bout.close();
			System.out.println("ok");
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
