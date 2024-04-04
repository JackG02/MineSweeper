package application;
import java.util.Random;

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
		
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			int randRow = rand.nextInt(10);
			int randCol = rand.nextInt(10);
			if(!_board[randRow][randCol].isMine()) {
				System.out.println("setting mine at: (" + randRow + "," + randCol + ")" );
				_board[randRow][randCol].setMine();
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
			int right = x + 1;
			int left = x - 1;
			if (x < _board.length - 1) revealNeighbors(_board[right][y], right, y);
			if (x > 0) revealNeighbors(_board[left][y], left, y);
			
			int up = y - 1;
			int down = y + 1;
			if (y < _board.length - 1) revealNeighbors(_board[x][down], x, down);
			if (y > 0) revealNeighbors(_board[x][up], x, up);
		}
	}
	
	private static void revealNeighbors(Cell c, int x, int y) {
		if (c.isMine() || !c.isHidden()) {
			System.out.println("Invalid cell at " + x + "," + y);
			return;}
		if (c._neighborMines == -1) {c.findNeighborMines();}
		if (c._neighborMines == 0) {
			c.changeHiddenStatus();
			
			int right = x + 1;
			int left = x - 1;
			if (x < _board.length - 1) revealNeighbors(_board[right][y], right, y);
			if (x > 0) revealNeighbors(_board[left][y], left, y);
			
			int up = y - 1;
			int down = y + 1;
			if (y < _board.length - 1) revealNeighbors(_board[x][down], x, down);
			if (y > 0) revealNeighbors(_board[x][up], x, up);
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


