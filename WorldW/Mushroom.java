package WorldW;

public class Mushroom extends Plant {
	private int power = 4;
	private int liveLenght = 25;
	private static String name = "M";
	private int powerToReproduction = 12;

	public Mushroom(Position position, GameWorld view, String name, int power) {
		super(position, view, name, power);
		this.power = power;
		this.name = "M";
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
		return "Mushroom power: " + power + "\n";
	}
}

