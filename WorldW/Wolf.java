package WorldW;

public class Wolf extends Animal {
	private int power = 8;
	private int liveLenght = 25;
	private int powerToReproduction = 20;
	private static String name = "W";
	
	public Wolf(Position position, GameWorld view, String name, int power) {
		super(position, view, name, power);
		this.power = power;
		this.name = "W";
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
		return "Wolf power: " + power + ", Actual position " + this.position.getX() + " " + this.position.getY() + "\n";
	}
}

