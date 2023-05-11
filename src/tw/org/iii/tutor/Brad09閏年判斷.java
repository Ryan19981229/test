package tw.org.iii.tutor;

public class Brad09閏年判斷 {

	public static void main(String[] args) {
		int year = 2100;
		boolean isLeap;
		
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					// 潤
					isLeap = true;
				}else {
					// 平
					isLeap = false;
				}
			}else {
				// 潤
				isLeap = true;
			}
		}else {
			// 平
			isLeap = false;
		}
		
		System.out.printf("%d年為%s年", year, (isLeap?"閏":"平")); //判斷布林值 
	}

}
