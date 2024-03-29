package application;

public class Board {
	static Cell[][] _board = new Cell[10][10];
	static GameSceneController controller;
	int mines = 10;
	static int numHidden = 0;
	
	public static void buildBoard() {
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				_board[row][col] = new Cell(row, col);
			}
		}
	}
	
	public void checkBoard() {
		int hidden1 = 0;
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				if (_board[row][col].isHidden()) { 
					hidden1 += 1;
					if (hidden1 > mines) return;
				}
			}
		} 
		Board.numHidden = hidden1;
		if (numHidden == mines) endGame();
	}
	
	private void revealCell(int x, int y) {
		
	}

	public static Cell[][] getBoard() {
		return _board;
	}
	
	public static void endGame() {
		GameSceneController.endGame();
	}
	
	public static void assignController(GameSceneController c) {
		controller = c;
	}

}


