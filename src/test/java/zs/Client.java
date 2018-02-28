package zs;

public class Client {

	public static void main(String[] args) {
	
		Item item01 = new Item01(); 
		Item item02 = new Item02(item01);
		Item item03 = new Item03(item02);
		System.out.println(item01.say());
		System.out.println(item02.say());
		System.out.println(item03.say());
	}
}
