// THIS PROJECT HAS THE SOLUTION FOR BOTH ZOO KEEPER PART 1 AND 2 

public class Gorilla extends Mammal {
	public Gorilla() {
		super(); //we call Mammal's constructor.
	}
	public void throwSomething() {
		if (this.getEnergyLevel() < 5) {
			System.out.println("Gorilla has no enough energy to throw sth"); 
			return; //instead of using else, we just tell it to get out of fly() if the condition is right.
		}
		System.out.println("The gorilla has thrown something! (-5) ");
		this.setEnergyLevel(this.energyLevel-5);
	}
	public void eatBananas() {
		System.out.println("The gorilla has eaten a banana! (+10) ");
		this.setEnergyLevel(this.energyLevel+10);
	}
	public void climb() {
		if (this.getEnergyLevel() < 10) {
			System.out.println("Bat has no enough energy to climb"); 
			return; //instead of using else, we just tell it to get out of fly() if the condition is right.
		}
		System.out.println("The gorilla has climbed a tree! (-10) ");
		this.setEnergyLevel(this.energyLevel-10);
	}
}
