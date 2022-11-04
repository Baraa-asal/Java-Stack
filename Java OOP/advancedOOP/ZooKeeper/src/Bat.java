// THIS PROJECT HAS THE SOLUTION FOR BOTH ZOO KEEPER PART 1 AND 2 

public class Bat extends Mammal {
	public Bat() {
		this.setEnergyLevel(300);
	}
	
	public void fly() {
		if (this.getEnergyLevel() < 50) {
			System.out.println("Bat has no enough energy to fly"); 
			return; //instead of using else, we just tell it to get out of fly() if the condition is right.
		}
		System.out.println("Sound of a flying bat :) (-50) ");
		this.setEnergyLevel(this.energyLevel-50);
	}
	public void eatHumans() {
		System.out.println("Sound of a bat eating human :( (+25) ");
		this.setEnergyLevel(this.energyLevel+25);
	}
	public void attackTown() {
		if (this.getEnergyLevel() < 100) {
			System.out.println("Bat has no enough energy to attack towns"); 
			return;
		}
		System.out.println("Sound of a town on fire!! (-100) ");
		this.setEnergyLevel(this.energyLevel-100);
	}
	
}

