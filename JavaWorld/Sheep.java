package World;

public class Sheep extends Animal {
	private int power = 5;
	private final static String name = "S";
	
	public Sheep(int power) {
		super(name, power);
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
	
	public String toString() {
		return "Sheep power: " + power + ", name " + name + " Position: " + getX() + " " + getY();
	}

	public boolean shouldReproduce() {
		return true;
	}

	public void move(Board board) {}

}
