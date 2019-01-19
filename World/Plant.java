package World;

public abstract class Plant extends Organism {
	
	private String name;
	private int x;
	private int y;
	
	public Plant(String name, int power) {
		super(name, power);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String toString() {
		return "Plant name = " + name 
				+ " Position = " + x + " " + y 
				+ " Power = ";
	}
}
