package World;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Init {
	
	private Board board;
	
	public void init() {

	board = new Board();
	
	board.initBoard();
	
	Grass grass = new Grass(3);
	Sheep sheep = new Sheep(5);
	
	BoardView view = board.tablica[board.getX()-1][board.getY()-1];
	
	view = board.tablica[1][1];
	view.addOrganism(grass);
	view = board.tablica[3][4];
	view.addOrganism(sheep);
	}
	
	public void run () {
		int lenght = 100;
		int test = 1;
        for (int i = 0; i < lenght; i++) {

            List<Organism> organismAllList = new ArrayList<>();
            for (int row = 0; row < board.getX(); row++) {
                for (int col = 0; col < board.getY(); col++) {
                    List<Organism> organismList = board.tablica[row][col].getOrganisms();
                    organismAllList.addAll(organismList);
                }
            }

            for (Organism organism : organismAllList) {
                organism.move(board);
            }

            if (i > 0) {
                Scanner sc = new Scanner(System.in);

                System.out.print("Enteruj to dalej.");
                System.out.println(test++);
                sc.nextLine();
            }
            
            this.board.printMap();
            
            if (i == lenght - 1) {

                System.out.print("Koniec testu.");
            }
        }
	}
}
