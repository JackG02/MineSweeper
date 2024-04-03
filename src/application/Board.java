package application;

public class Board {
	
	static Cell[][] _board = new Cell[10][10];
	static GameSceneController controller;
	int mines = 10;
	int flags = 0;
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
	
	public static void revealCell(int x, int y) {
		Cell cell = _board[x][y];
		if(!cell.isHidden()) return;
		cell.changeHiddenStatus();
		if(cell.isMine()) {
			endGame();
			return;
		}
		
		cell.determineDisplayCharacter();
		System.out.println("Cell neighbor mines: " + cell._neighborMines);
		if(cell._neighborMines == 0) {

			System.out.println("Revealing cell neighbors");
			if (x < _board.length - 1) revealNeighbors(_board[x - 1][y], x + 1, y);
			if (x > 0) revealNeighbors(_board[x - 1][y], x - 1, y);
			if (y < _board.length - 1) revealNeighbors(_board[x][y + 1], x, y + 1);
			if (y > 0) revealNeighbors(_board[x][y - 1], x, y - 1);
		}
	}
	
	private static void revealNeighbors(Cell c, int x, int y) {
		if (c.isMine() || !c.isHidden()) {
			System.out.println("Invalid cell at " + x + "," + y);
			return;}
		if (c._neighborMines == -1) {c.findNeighborMines();}
		if (c._neighborMines == 0) {
			c.changeHiddenStatus();
			
			if (x < _board.length - 1) revealNeighbors(_board[x - 1][y], x + 1, y);
			if (x > 0) revealNeighbors(_board[x - 1][y], x - 1, y);
			if (y < _board.length - 1) revealNeighbors(_board[x][y + 1], x, y + 1);
			if (y > 0) revealNeighbors(_board[x][y - 1], x, y - 1);
		}
		
	}

	public static Cell[][] getBoard() {
		return _board;
	}
	
	public static void endGame() {
		System.out.println("End Game - Board");
		GameSceneController.endGame();
	}
	
	public static void assignController(GameSceneController c) {
		controller = c;
	}
	
	public int getFlag() {
		return flags;
	}
	public void setFlag() {
		
	}

}


