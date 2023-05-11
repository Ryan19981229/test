package tw.org.iii.tutor;

public class Brad12SWITCH和CASE {
	public static void main(String[] args) {
		int month = 10;
		int days = 0;
		switch(month) {   //多重分支，只能比對單一的值;可以用在月份大小(適合沒有規律很難下條件)
		//switch是一個選擇結構,包括一個條件表達式和一個或多個case分支。
		case 1:
			System.out.println("A");
			break;
		case 10:
			System.out.println("B");
			break;  //會印出B,但是如果沒有break會去找下一個break並也印出C
		case 100:
			System.out.println("C");
			break;
		default:
			System.out.println("XX");
			break;
		}
		//分辨每個月分大小天
		switch(month) {   
		case 1, 3, 5, 7, 8, 10, 12:  //也可以寫在一起
			days = 31;
			break;
		case 4, 6, 9, 11:
			days = 30;
			break;
		case 2:
			days = 28;
			break;
		default:
			System.out.println("XX");
		}
		System.out.printf("%d月有%d天", month, days);
	}
}
