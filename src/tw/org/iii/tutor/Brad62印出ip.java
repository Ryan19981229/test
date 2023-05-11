package tw.org.iii.tutor;

import java.net.InetAddress;

public class Brad62印出ip {

	public static void main(String[] args) {
		try {
			//InetAddress ip = InetAddress.getByName("10.0.104.158"); 
			//Determines the IP address of a host, given the host's name.
			//可以傳主機名稱或ip位置
			//主機(www)以及網域(iii.org.tw)裝在一起變成主機名稱; "."意思是"在"的意思
			//port是2^16次方0~1024見一步要用
			InetAddress[]ips = InetAddress.getAllByName("www.google.com");
			for(InetAddress ip: ips) {//可能有很多IP 
				System.out.println(ip.getHostAddress());
			}
			//System.out.println(ip.getHostAddress());
			//System.out.println(ip.getHostName());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
