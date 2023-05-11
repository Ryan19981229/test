//package tw.org.iii.tutor;
//
//import tw.org.iii.myclasses.TWId;
//
//public class Brad23 {
//	
//
//	public static void main(String[] args) {
////		TWId.checkId(null);
//		String id = "A1234555G9";
//		if (id.matches("[A-Z][12][0-9]{8}")) { // [ABC]字元集取一;正規表示式
//			System.out.println("OK");
//		} else {
//			System.out.println("XX");
//		}
//		TWId twid = new TWId();
//		System.out.println(twid.CheckId(id));
//	}
//}

package tw.org.iii.tutor;

import tw.org.iii.myclasses.TWId; //可以用.*表示全部

public class Brad23TWId {

	public static void main(String[] args) {
//		String id = "A123456789";
//		if (TWId.checkId(id)) { //直接呼叫函數帶入進去
//			System.out.println("OK");
//		} else {
//			System.out.println("XX");
//		}
//		System.out.println("---");
//		if (TWId.CheckId(id)) { //直接呼叫函數帶入進去
//			System.out.println("OK");
//		} else {
//			System.out.println("XX");
//		}
//		System.out.println("---");

		TWId id1 = new TWId();
		TWId id2 = new TWId(1);
		TWId id3 = new TWId(false);
		TWId id4 = new TWId(true, 0);

		System.out.println(id1.getId());
		System.out.println(id2.getId());
		System.out.println(id3.getId());
		System.out.println(id4.getId());
		
		TWId id5 = TWId.createTWId("A123456789");
		System.out.println(id5.getId());
	}
}
