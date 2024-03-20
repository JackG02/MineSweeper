package application;

public class Board {
	static Cell[][] _board = new Cell[10][10];
	
	int mines = 10;
	
	public void buildBoard() {
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				_board[row][col] = new Cell(row, col);
			}
		}
	}
	
	public void checkBoard() {
		int numHidden = 0;
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				if (_board[row][col].isHidden()) {
					numHidden += 1;
					if (numHidden > mines) return;
				}
			}
		} 
		if (numHidden == mines) endGame();
	}
	
	private void revealCell(int x, int y) {
		
	}
	
	
	
}


