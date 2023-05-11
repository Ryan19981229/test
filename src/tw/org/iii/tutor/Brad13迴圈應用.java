package tw.org.iii.tutor;

public class Brad13迴圈應用 {
	public static void main(String[] args) {
		int i = 0;
		for (printBrad(); i < 10; printLine()) { // 第二道敘述句省略不做視為true
			System.out.println(i++);
		}
	}

	static void printBrad() {
		int lottery = (int) (Math.random() * 49 + 1);
		System.out.println("Brad" + lottery);
	}

	static void printLine() {
		System.out.println("----");
	}
}
//第1步:進入迴圈第一個敘述句，給出1個變數。
//第2步:進入迴圈第二個敘述句，布林值判斷，通常是true false or 條件。
//第3步:符合第二個敘述句後印出來+1並回傳至第三個敘述句。
//第4步:印出第三敘述句。
//第5步:回傳至第二個敘述句判斷。