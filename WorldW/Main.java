package WorldW;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		GameWorld test = new GameWorld(10, 10);
		
		Sheep s1 = new Sheep(new Position(1,1), test, "S", 5);
		Sheep s2 = new Sheep(new Position(2,3), test, "S", 5);
		Sheep s3 = new Sheep(new Position(7,8), test, "S", 5);
		
		Wolf w1 = new Wolf(new Position(5,5), test, "W", 8);
		
		Grass g1 = new Grass(new Position(7,2), test, "G", 4);
		Grass g2 = new Grass(new Position(6,6), test, "G", 4);
		Grass g3 = new Grass(new Position(4,1), test, "G", 4);
		Grass g4 = new Grass(new Position(1,7), test, "G", 4);
		
		Mushroom m1 = new Mushroom(new Position(9,9), test, "M", 4);

		test.addOrganism(s1);
		test.addOrganism(s2);
		test.addOrganism(s3);
		test.addOrganism(g1);
		test.addOrganism(g2);
		test.addOrganism(g3);
		test.addOrganism(g4);
		test.addOrganism(w1);
		test.addOrganism(m1);
		
		System.out.println(test);
		sc.nextLine();
		
		for(int x=0; x < 100; x++) {
			test.makeTurn();
			System.out.print(test);
			System.out.print("\n");
			sc.nextLine();
		}
	}
}
