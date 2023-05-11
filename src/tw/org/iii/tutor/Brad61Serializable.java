
	package tw.org.iii.tutor;

	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.io.Serializable;

	public class Brad61Serializable {//看觀念的code不是正式的code
		public static void main(String[] args) {
			Brad613 obj = new Brad613();
			try {
				ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("dir1/brad"));
				oout.writeObject(obj);
				oout.flush();//強制將緩衝區內容寫入目標輸出流中 
				oout.close();
				System.out.println("----");
				ObjectInputStream oin = new ObjectInputStream(new FileInputStream("dir1/brad"));
				oin.readObject();
				oin.close();
				
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	class Brad611 implements Serializable { //序列化;以下都有被序列化出去
		Brad611(){System.out.println("Brad611()");}
	}
	class Brad612 extends Brad611 {
		Brad612(){System.out.println("Brad612()");}
	}
	class Brad613 extends Brad612 { //
		Brad613(){System.out.println("Brad613()");}
	}