package WorldW;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameWorld {
	
	private List<Organism> creatures = new ArrayList<Organism>();
	private List<Organism> newOrganismsToAdd = new ArrayList<Organism>();
	private int x;
	private int y;
	
	public GameWorld(int width, int length) {
		this.x = width;
		this.y = length;	
	}
	
	public List<Organism> getCreatures() {
		return creatures;
	}
	
	public void setCreatures(List<Organism> inhabitants) {
		this.creatures = inhabitants;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int width) {
		this.x = width;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int length) {
		this.y = length;
	}

	public void removeOrganism() {
    	for (Organism org : this.creatures) {
    		if (org.getLiveLenght() < 1) {
    			org.setPosition(new Position(-1, -1));
    		}
    	}
	}
	
	public void removeDeadOrganisms() {
    	creatures.removeIf(org -> org.getPosition().getX() == -1 && org.getPosition().getY() == -1);
   }
    
    public boolean addOrganism(Organism org) {
        if (org.getPosition().getX() >= 0 && org.getPosition().getY() >= 0 && org.getPosition().getX() <= this.x && org.getPosition().getY() <= this.y) {
            creatures.add(org);
            return true;
       }
        else { return false; }
    }
    
    public void addNewOrganisms() {
    	for (Organism org : newOrganismsToAdd) {
    		this.addOrganism(org);
    	}
    }
    
    public Organism getOrganismFromPosition(Position position){
        Organism temp_organism = null;
        for(Organism org : this.creatures) {
            if (org.getPosition().equals(position)) {
                temp_organism = org;
                break;
            }
        }
        return temp_organism;
    }
    
    public ArrayList<Organism> getAllOrganismsFromPosition(Position position){
        ArrayList<Organism> all_organisms = new ArrayList<Organism>();
        for(Organism org : this.creatures) {
            if (org.getPosition().equals(position)) {
                all_organisms.add(org);
            }
        }
        return all_organisms;
    }
    
    public Position getRandomFreePosition() {
    	ArrayList<Position> freePositions = new ArrayList<Position>();
    	for (int col = 0; col < this.getY(); col++){
            for (int row = 0; row < this.getX(); row++){
            	if (getOrganismFromPosition(new Position (row, col)) == null) {
            		freePositions.add(new Position(row, col));
            	}
            }
    	}
    	if (freePositions.isEmpty()) { return (new Position(-1, -1)); }
    	
    	Random rand = new Random();
    	Position randpos = freePositions.get(rand.nextInt(freePositions.size()));
    
    	return randpos;
    }
    
    public void makeTurn() {
    	for(Organism org : this.creatures) {
    		org.setPower(org.getPower()+1);
    		org.setLiveLenght(org.getLiveLenght()-1);
    		if (org.getLiveLenght() < 1) {
    			removeOrganism();
    		}
	    	if (org instanceof Sheep) {
	    		Position new_pos = org.getMovement().move(org);
	    		getAllOrganismsFromPosition(new_pos);
	    		checkCollisions(getAllOrganismsFromPosition(new_pos));
	    	if (org.getPower() >= org.getPowerToReproduction()) {
	    			newOrganismsToAdd.add(new Sheep(getRandomFreePosition(), this, "S", 6));
	    			org.setPower(org.getPower() - 7);
	    			}
	    		}
	    	
	    	if (org instanceof Wolf) {
    			Position new_pos = org.getMovement().move(org);
    			getAllOrganismsFromPosition(new_pos);
    			checkCollisions(getAllOrganismsFromPosition(new_pos));
    		if (org.getPower() >= org.getPowerToReproduction()) {
    				newOrganismsToAdd.add(new Wolf(getRandomFreePosition(), this, "W", 10));
    				org.setPower(org.getPower() - 10);
    			}
    		}
	    		
	    	if (org instanceof Grass) {
	    		if (org.getPower() >= org.getPowerToReproduction()) {
	    			newOrganismsToAdd.add(new Grass(getRandomFreePosition(), this, "G", 5));
		    		org.setPower(org.getPower() - 6);
	    			}
	    		}
	    	
	    	if (org instanceof Mushroom) {
	    		if (org.getPower() >= org.getPowerToReproduction()) {
	    			newOrganismsToAdd.add(new Mushroom(getRandomFreePosition(), this, "M", 5));
		    		org.setPower(org.getPower() - 6);
	    			}
	    		}
	    	}
    	removeDeadOrganisms();
		addNewOrganisms();
		newOrganismsToAdd.clear();
		
    	String formattedString = this.creatures.toString()
    		    .replace(",", "")
    		    .replace("[", "")
    		    .replace("]", "")
    		    .trim();
    	System.out.println(formattedString);
    	}
    
    public void checkCollisions(ArrayList<Organism> all_orgs){
    	switch (all_orgs.size()) {
    		case 1:
    			break;
    		case 2:
    			Organism inhabitant = all_orgs.get(0);
    			Organism invader = all_orgs.get(1); 	
    			collision(invader, inhabitant);
    			break;
    	}
    }
    	
    	public void collision(Organism inhabitant, Organism invader) {
    		
        	if (invader instanceof Sheep) {
    			
    			if (inhabitant instanceof Grass) {
    				inhabitant.setPosition(new Position(-1, -1));
    			}
    			else if (inhabitant instanceof Wolf) {
    				invader.setPosition(new Position(-1, -1));
    			}
    			else if (inhabitant instanceof Mushroom) {
    				invader.setPosition(new Position(-1, -1));
    				inhabitant.setPosition(new Position(-1, -1));
    			}
    		}
    		else if (invader instanceof Wolf) {
    			if (inhabitant instanceof Sheep) {
    				inhabitant.setPosition(new Position(-1, -1));
    			}
    			else if (inhabitant instanceof Mushroom) {
    				invader.setPosition(new Position(-1, -1));
    				inhabitant.setPosition(new Position(-1, -1));
    			}
    		}
    }
    
	public String toString() {
		String result = "";
		String test = "-";    
        System.out.println();
        
        for (int y=0; y < this.getY(); y++){
            for (int x=0; x < this.getX(); x++){
            	result += " ";
                Organism org = this.getOrganismFromPosition(new Position(x, y));
                if (org != null){
                    result += org.getName();
                }
                else {
                    result += test;
                }
            }
            result += "\n";
        }
        return result;
	}
}
