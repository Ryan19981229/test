package tw.org.iii.tutor;

public class hw {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, j;
		boolean isYes;
		for (i = 2; i < 100; i++) {
			isYes = true; // 每次進入外層迴圈時，重新設定 isYes 為 true
			for (j = 2; j < i; j++) {
				if (i % j == 0) {
					isYes = false;
					break;
				}
			}
			if (isYes) { // 判斷 i 是否為質數
				System.out.println(i);
			}
		}
	}
}
