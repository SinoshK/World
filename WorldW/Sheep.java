package WorldW;


public class Sheep extends Animal {
	private int power = 5;
	private int liveLenght = 18;
	private int powerToReproduction = 14;
	private static String name = "S";
	
	public Sheep(Position position, GameWorld view, String name, int power) {
		super(position, view, name, power);
		this.power = power;
		this.name = "S";
		this.liveLenght = liveLenght;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
	public String getName() {
		return name;
	}
	
	public int getLiveLenght() {
		return liveLenght;
	}

	public void setLiveLenght(int liveLenght) {
		this.liveLenght = liveLenght;
	}

	public boolean shouldReproduce() {
		return true;
	}

	public int getPowerToReproduction() {
		return powerToReproduction;
	}

	public void setPowerToReproduction(int powerToReproduction) {
		this.powerToReproduction = powerToReproduction;
	}
	
	public String toString() {
		return "Sheep power: " + power + ", Actual position " + this.position.getX() + " " + this.position.getY() + "\n";
	}
}
