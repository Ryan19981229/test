package tw.org.iii.tutor;

public class Brad43例外異常用法 {

	public static void main(String[] args) {
		Bird b1 = new Bird();
		try {
			b1.setLag(2);
			System.out.println("ok");
		}catch(Exception e) {
			System.out.println("Error");
		}

	}

}
class Bird {
	private int lag;
	void setLag(int lag) throws Exception  { //對外宣稱交代有能有例外
		if (lag >= 0 && lag <= 2) {
		this.lag= lag;
		}else {
			throw new Exception(); //拋出例外
		}
	}
}