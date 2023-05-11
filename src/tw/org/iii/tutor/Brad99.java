package tw.org.iii.tutor;

public class Brad99 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int j = 1; j < 10; j++) {
			for (int i = 2; i < 6; i++) {
				int r = i * j;
				System.out.printf("%d x %d = %d\t", i, j, r);
			}
			System.out.println();
		}
		System.out.println("-----------------------------------------------------------");
		for (int j = 1; j < 10; j++) {
			for (int i = 6; i < 10; i++) {
				int r = i * j;
				System.out.printf("%d x %d = %d\t", i, j, r);
			}
			System.out.println();
		}
		System.out.println("-----------------------------------------------------------");
		final int ROWS = 2;
		final int START = 4;
		final int COLS = 9;

		for (int k = 0; k < ROWS; k++) {
			for (int j = 1; j <= 9; j++) {
				for (int i = START; i < (START + COLS); i++) { //
					int newi = i + k * COLS;
					int r = newi * j;
					System.out.printf("%d x %d = %d\t", newi, j, r); 
					//\t 是一個特殊的轉義序列，用於表示水平制表符（Tab）字符。 
				}
				System.out.println();
			}
			System.out.println("-----------------------------------------------------------");
		}
	}
}
