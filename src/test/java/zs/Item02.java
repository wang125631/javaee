package zs;

public class Item02  implements Item{

	private Item it;

	public Item02(Item it) {

		this.it = it;
	}



	@Override
	public String say() {
		
		return "11 "+ it.say() +" 11";
	}
	
	
	
}
