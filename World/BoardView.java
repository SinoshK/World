package World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BoardView {

private List<Organism> list = new ArrayList<>();

    public void addOrganism(Organism organism) {
        list.add(organism);
    }

    public void removeOrganism(Organism organism) {
        list.remove(organism);
    }
    
    public List<Organism> getOrganisms() {
        return list;
    }

    public String toString() {
        if (list.isEmpty()) {
            return "-";
        }
        String result = "";
        for (Organism organism : list) {
            result += organism.getName();
        }
        return result;
    }
   
}