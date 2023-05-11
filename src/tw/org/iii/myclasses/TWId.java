package tw.org.iii.myclasses;

public class TWId { 
	private  String id; //private不給直接更改id //私有的實例變數 //還沒被初始化
	private  final static String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO";// final 不能改
	//加上static與物件無關
	// 隨時可以叫用
	// 以下是建構子
	public TWId() { 
		this((int) (Math.random() * 2) == 0); //隨機產生性別;是0就是true
		//第一道敘述句用不是super or this，this祖宗八代會自動初始化，不用super()
	}

	public TWId(boolean isMale) {
		this(isMale, (int) (Math.random() * 26)); //如果選擇性別產生area 
	}

	public TWId(int area) {
		this((int) (Math.random() * 2) == 0, area); //如果選擇area產生性別
	}

	public TWId(boolean isMale, int area) {
		super(); //隱形的super
		String c1 = letters.substring(area, area + 1);
		//因為拿到對應字串會拿到其他字串，會占用到記憶體(沒有真的切掉)(slice有切掉)
		StringBuilder sb = new StringBuilder(c1);
		
		//所以要用StringBuilder就可以把其他字串去除
		sb.append(isMale ? "1" : "2");
		for (int i = 0; i < 7; i++) { //產生前7碼
			sb.append((int) (Math.random() * 10));
		}

		String temp = sb.toString();  //轉成字串
		for (int i = 0; i < 10; i++) {
			if (checkId(temp + i)) { //先把最後數字加起來判斷
				id = temp + i;
				break;
			}
		}

	}

	private TWId(String id) { //這個id不是上面id
		this.id = id;
	}

	public static TWId createTWId(String id) { //回傳TWId類型物件
		//為了檢查id; 如果checkId(id)返回true，則創建一個新的TWId對象並返回，否則返回null。
		TWId twId= null;
		if (checkId(id)) { 
			twId = new TWId(id);
		}
		return twId;
	}
	public String getId() {
		return id;
	}

	public static boolean CheckId(String id) {// 寫的id是否正確,與物件無關寫上static
//		System.out.println("checkID");
	// 1. len = 10
	// 2. c1 => A-Z
	// 3. c2 => 1, 2
	// 4. c3-10 => 0 - 9
		boolean isRight = false;
		if (id.length() == 10) {
			char c1 = id.charAt(0);
			if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(c1) != -1) {
				char c2 = id.charAt(1);
				if (c2 == '1' || c2 == '2') {
					for (int i = 2; i < 10; i++) {
						if (id.charAt(i) >= '0' && id.charAt(i) <= '9') {
							isRight = true;
						} else {
							isRight = false;
							break;
						}
					}

				}

			}
		}
		return isRight;
	}

	public static boolean checkId(String id) { //可以呼叫直接帶入值
		// 1. len = 10
		// 2. c1 => A-Z
		// 3. c2 => 1, 2
		// 4. c3-10 => 0 - 9
		boolean isRight = false;
		if (id.matches("[A-Z][1289][0-9]{8}")) {
		    char c1 = id.charAt(0);//取出第一位 以char表示字元
			System.out.println(c1);
			int n12 = letters.indexOf(c1) + 10;
//			System.out.println(n12);
			//取出陣列位子
			//indexOf陣列索引值
			int n1 = n12 / 10;
			int n2 = n12 % 10;
			int n3 = Integer.parseInt(id.substring(1, 2));
			int n4 = Integer.parseInt(id.substring(2, 3));
			int n5 = Integer.parseInt(id.substring(3, 4));
			int n6 = Integer.parseInt(id.substring(4, 5));
			int n7 = Integer.parseInt(id.substring(5, 6));
			int n8 = Integer.parseInt(id.substring(6, 7));
			int n9 = Integer.parseInt(id.substring(7, 8));
			int n10 = Integer.parseInt(id.substring(8, 9));
			int n11 = Integer.parseInt(id.substring(9, 10));

			int sum = n1 * 1 + n2 * 9 + n3 * 8 + n4 * 7 + n5 * 6 + n6 * 5 + n7 * 4 + n8 * 3 + n9 * 2 + n10 * 1
					+ n11 * 1;
			isRight = sum % 10 == 0;
		}

		return isRight;
	}

}

