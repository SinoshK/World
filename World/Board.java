package World;

public class Board {
	private int x = 6;
	private int y = 6;
	BoardView[][] tablica = new BoardView[x][y];

    public void initBoard() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                tablica[i][j] = new BoardView();
            }
        }
    }

    public void printMap() {
        for (int row = 0; row < x; row++) {
            for (int col = 0; col < y; col++) {
                System.out.print(tablica[row][col] + " ");
            }
            System.out.println();
        }
    }

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}