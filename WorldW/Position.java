package WorldW;

import java.util.Random;

public class Position {
	
	private int x;
	private int y;
	
	public Position(Position position) {
		this.x = position.x;
		this.y = position.y;
	}
	
	public Position(int x,  int y) {
		this.x = x;
		this.y = y;
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
    
	public boolean equals(Object object) {
		Position pos = (Position) object;
		if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        if (this.x != pos.x) {
            return false;
        }
        if (this.y != pos.y) {
            return false;
        }
        return true;
	}

	public Position noMove(Organism o) {
		return o.getPosition();
	}

	private final int up = 0;
	private final int down = 1;
	private final int left = 2;
	private final int right = 3;
	
	public Position move(Organism o) {
		Random rand = new Random();
		Position pos = o.getPosition();
		GameWorld world = o.getBoardView();
		
		int worldX = world.getX()-1;
		int worldY = world.getY()-1;
		int random = rand.nextInt(4);
		
		switch (random) {
			case up:
				if ((pos.getY() - 1) >= 0) {
					pos.setY(pos.getY() - 1);
				}
				break;
			case down:
				if ((pos.getY() + 1) <= worldY) {
					pos.setY(pos.getY() + 1);
				}
				break;
			case left:
				if ((pos.getX() - 1) >= 0) {
					pos.setX(pos.getX() - 1);
				}
				break;
			case right:
				if ((pos.getX() + 1) <= worldX) {
					pos.setX(pos.getX() + 1);
				}
				break;
		}
		return o.getPosition();
	}
}
