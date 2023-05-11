package tw.org.iii.tutor;

public class Brad31interface運用 {

	public static void main(String[] args) {
		RecShape s1 = new RecShape(10, 3);
		Circle s2 = new Circle(4);
		System.out.println(m1(s1));
		System.out.println(m1(s2));
	}
	static String m1(Shape shape) { //接收一個 Shape 介面的參數
		if (shape instanceof RecShape) { 
			//物件變數;不是這個類別的實體 這個類別是不是這個類別
			System.out.println(((RecShape)shape).isSquare()?"OK":"XX");
			//將 shape 物件轉換成 RecShape 型別。在這段程式碼中，
			//shape 是一個實作了 Shape 介面的物件，可能是 RecShape 或 Circle 的實例。
		}else if (shape instanceof Circle) {
			System.out.println(((Circle)shape).getDiameter());
		}
		return shape.length() + ":" + shape.area();//多型表現
	}
}

interface Shape {// 介面;你一定要做出兩個方法，是一個特殊的引用類型 都是抽象類別
	double length();// 不用定義，因為在介面為功能實作 public abstract 公開抽象
	
	double area();
	
	//個方法都是公開抽象的，也就是只有方法簽名，沒有實作內容。其他類別可以實作 Shape 介面，
	//並實現這兩個方法，就可以達到多型的效果。
}

class RecShape implements Shape { //介面是一種規範，定義了一組方法的名稱、輸入參數、回傳型別，但不提供具體的實現。
	int w, h;
	public RecShape(int w, int h) {
		this.w = w; this.h = h; //類別(this)
	}
	public double  length() { // 一定要public 要對外公開實作方法 周長
		return (w+h)*2;
	}

	public double area() { //面積
		return w*h;
	}
	public boolean isSquare() { //布林值正方形
		return w == h;
	}
}
class Circle implements Shape {
	double r;
	Circle(double r){ //建構式
		this.r = r;}
	public double length() {
		return r * 2 * Math.PI;} //圓周長
	public double area() { 
		return r * r * Math.PI;} //面積
	public double getDiameter() {
		return 2*r;}//直徑
}


