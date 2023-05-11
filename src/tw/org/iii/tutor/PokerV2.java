package tw.org.iii.tutor;

public class PokerV2 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		// 1. 洗牌
		int count = 52;
		int[] poker = new int[count];
		boolean isRepeat;
		int temp;
		for (int i=0; i<poker.length; i++) {
			do {
				temp = (int)(Math.random()*count);
				
				// 檢查機制
				isRepeat = false;
				for (int j=0; j<i; j++) {
					if (temp == poker[j]) {
						// 重複了
						isRepeat = true;
						break;
					}
				}
			}while (isRepeat);
			
			poker[i] = temp;
		}
		
		for (int v: poker) {
			System.out.println(v);
		}
		
		System.out.println("---");
		System.out.println(System.currentTimeMillis()-startTime);
		
	}

}
