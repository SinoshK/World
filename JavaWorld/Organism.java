package World;

public abstract class Organism {
	private int power;
	private String name;
	
	public abstract boolean shouldReproduce();

	public abstract void move(Board board);
	
	 public Organism(String name, int power) {
	        this.name = name;
	        this.power = power;
	    }

	    public String getName() {
	        return name;
	    }
}
