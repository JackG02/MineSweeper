package application;

public class Board {
	Cell[][] _board = new Cell[10][10];
	
	public void buildBoard() {
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				_board[row][col] = new Cell();
			}
		}
	}
	
}


