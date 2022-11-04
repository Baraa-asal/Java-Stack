
public class Gorilla extends Mammal {
	public Gorilla() {
		super(); //we call Mammal's constructor.
	}
	public void throwSomething() {
		System.out.println("The gorilla has thrown something! (-5) ");
		this.setEnergyLevel(this.energyLevel-5);
	}
	public void eatBananas() {
		System.out.println("The gorilla has eaten a banana! (+10) ");
		this.setEnergyLevel(this.energyLevel+10);
	}
	public void climb() {
		System.out.println("The gorilla has climbed a tree! (-10) ");
		this.setEnergyLevel(this.energyLevel-10);
	}
}
