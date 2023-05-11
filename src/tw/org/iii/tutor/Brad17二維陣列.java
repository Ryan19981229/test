package tw.org.iii.tutor;

public class Brad17二維陣列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = new int[3][]; // 宣告二維陣列:陣列不是空間觀念，是線性觀念
		a[0]=new int[2];
		a[1]=new int[3];
		a[2]=new int[4];//初始化後是0000
		System.out.println(a); //---->記憶體位置
        System.out.println("------");
		for (int[] a1 : a) {
			for (int a2 : a1) {
				System.out.println(a2 + "");
			}
			System.out.println();
		}
		System.out.println("----------------");
		System.out.println(a);//---->記憶體位置
		System.out.println("----------------");
		for (int i = 0; i < a.length; i++) { //先跑外面迴圈一次; 裡面跑完在跑外面第二次
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
