package tw.org.iii.tutor;

public class Brad16有用陣列擲骰子 {
	// 以陣列方式
	public static void main(String[] args) {
		int[] p = new int[7];
		
		for (int i=0; i<10000000; i++) {
			int point = (int)(Math.random()*9+1);	// 1 ~ 6
			if (point >= 1 && point <= 9) {
				p[point>=7?point-3:point]++; //三元運算子;作弊
			}else {
				p[0]++;
			}
		}
		
		if (p[0] == 0) {
			for (int i=1; i<=6; i++) {
				System.out.printf("%d點出現%d次\n", i, p[i]);
			}
		}else {
			System.out.println("debug = " + p[0]);
		}
		System.out.println("----");
		
		// for-each
		for (int v : p) {
			System.out.println(v);
		}
		
		
		
	}

}
//三源運算式