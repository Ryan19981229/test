package tw.org.iii.tutor;

public class PokerV3hw {
	public static void main(String[] args) {
		int count = 52;
		int[] poker = new int[count];
		for (int i = 0; i < poker.length; i++) {
			poker[i] = i + 1;
		}
		for (int n = 0; n < 1000; n++) {
			int a = (int) (Math.random() * count);
			int b = (int) (Math.random() * count);
			int table = poker[a];
			poker[a] = poker[b];
			poker[b] = table;
		}
		for (int card : poker) {
			System.out.println(card + " ");
		}
	}
}
