package World;

public class Grass extends Plant {
	private int power = 3;
	private int liveLenght = 12;
	private final static String NAME = "G";
	
	public void move(Board board) {
        if (this.liveLenght < 1) {
            for (int row = 0; row < board.getX(); row++) {
                for (int col = 0; col < board.getY(); col++) {
                	board.tablica[row][col].removeOrganism(this);
                }
            }
        }
        if (power > 6) {
            Grass g = new Grass(3);
            BoardView pole = board.tablica[(int) (Math.random() * board.getX())][(int) (Math.random() * board.getY())];
            if (pole.getOrganisms().isEmpty()) {
                pole.addOrganism(g);
                this.power -= 3;
            }
        } else power++;
        this.liveLenght -= 1;
	}
	
	public Grass(int power) {
		super(NAME, power);
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
	public String getName() {
		return NAME;
	}
	
	public int getLiveLenght() {
		return liveLenght;
	}

	public void setLiveLenght(int liveLenght) {
		this.liveLenght = liveLenght;
	}
	
	public String toString() {
		return "Grass power: " + power + ", name " + NAME + " Position: " + getX() + " " + getY();
	}

	public boolean shouldReproduce() {
		return true;
	}
}
