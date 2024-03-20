package application;

public class Board {
	Cell[][] _board = new Cell[10][10];
	
	int mines = 10;
	
	public void buildBoard() {
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				_board[row][col] = new Cell();
			}
		}
	}
	
	public boolean checkBoard() {
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				if (_board[row][col].isHidden()) {
					return false;
				}
			}
		}
		return true;
	}
	
}


