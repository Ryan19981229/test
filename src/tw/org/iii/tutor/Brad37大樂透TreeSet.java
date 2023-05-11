package tw.org.iii.tutor;

import java.util.HashSet;
import java.util.TreeSet;

public class Brad37大樂透TreeSet {

	public static void main(String[] args) {
		TreeSet<Integer> lottery = new TreeSet(); //由小排到大，不允許重複
		while (lottery.size()<6) {
			lottery.add((int)(Math.random()*49+1));
		}
		System.out.println(lottery);
	}

}
