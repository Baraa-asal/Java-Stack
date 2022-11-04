
public class Mammal {
	protected int energyLevel;
	
	public Mammal() {
		this.energyLevel = 100;
	}
	public int getEnergyLevel() {
		return energyLevel;
	}
	protected void setEnergyLevel(int energyLevel) { //protected: so no one can change it unless if they are subclasses.
		this.energyLevel = energyLevel;
	}
	
	public Integer displayEnergy() {
		System.out.println(this.getEnergyLevel());
		return this.getEnergyLevel();
	}
	

}
