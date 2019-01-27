package WorldW;

public class Grass extends Plant {
	private int power = 4;
	private int liveLenght = 15;
	private static String name = "G";
	private int powerToReproduction = 12;

	public Grass(Position position, GameWorld view, String name, int power) {
		super(position, view, name, power);
		this.power = power;
		this.name = "G";
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
		return "Grass power: " + power + "\n";
	}
}
