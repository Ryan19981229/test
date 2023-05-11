package tw.org.iii.tutor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.print.DocFlavor.INPUT_STREAM;

public class Brad65UCPserver接收端 {

	public static void main(String[] args) {
		try {
		ServerSocket server = new ServerSocket(9957); //server 接收要求
		Socket socket = server.accept();
		String urip = socket.getInetAddress().getHostAddress();
		System.out.println(urip);
		InputStream in = socket.getInputStream();
		InputStreamReader ir = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(ir);
		String line;
		while ((line = br.readLine())!=null) {
			System.out.println(line);
		}
		server.close();
		System.out.println("ok");
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
