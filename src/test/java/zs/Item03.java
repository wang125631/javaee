package zs;

public class Item03 implements Item{

	private Item it;

	
	public Item03(Item it) {

		this.it = it;
	}


	@Override
	public String say() {
	
		return " 22 "+it.say()+" 22";
	}
	
}
