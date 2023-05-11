package tw.org.iii.tutor;

public class Brad34介面與繼承並用 {

	public static void main(String[] args) {


	}

}
interface Brad341{
	void m1() ;
		
}

interface Brad342{
	void m2() ;
		
}

interface Brad343 extends Brad341,Brad342{ 
	void m3() ;
	
}

class Brad344 implements Brad343{
	public void m1( ) {}
	public void m2( ) {}
	public void m3( ) {}
}
	