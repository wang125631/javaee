package zr;

public class Cilent {

	public static void main(String[] args) {
	
		RealHandler realHandler01 = new  RealHandler();
		RealHandler realHandler02 = new  RealHandler();
		RealHandler realHandler03 = new  RealHandler();
		
		realHandler01.setHandler(realHandler02);
		realHandler02.setHandler(realHandler03);
		realHandler01.handlerRequest();
	}
}
