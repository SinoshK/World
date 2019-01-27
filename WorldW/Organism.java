package WorldW;

public abstract class Organism {
	Position position;
	private GameWorld view;
	private int power;
	private String name;
	public int liveLenght;
	private int powerToReproduction;
	
	public abstract boolean shouldReproduce();
	
	public Organism(Position position, GameWorld view, String name, int power) {
		this.position = new Position(position);
		this.view = view;
		this.power = power;
		this.name = name;
	}

	public String getName() {
	    return name;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}

	public Position getMovement() {
		return position;
	}
	
	public Position getNoMove() {
		return position;
	}

	public GameWorld getBoardView() {
		return view;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
	public int getLiveLenght() {
		return liveLenght;
	}

	public void setLiveLenght(int liveLenght) {
		this.liveLenght = liveLenght;
	}
	
	public int getPowerToReproduction() {
		return powerToReproduction;
	}

	public void setPowerToReproduction(int powerToReproduction) {
		this.powerToReproduction = powerToReproduction;
	}	
}
