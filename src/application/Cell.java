package application;

public class Cell {
	
	boolean _isHidden;
	boolean _isMine;
	boolean _isFlagged;
	int _neighborMines;
	
	int xCoord;
	int yCoord;
	
	String _displayCharacter;
	
	public Cell(int x, int y) {
		_isHidden = true;
		_isMine = false;
		_neighborMines = -1;
	}
	
	public void changeHiddenStatus() {
		if(_isHidden) {
			_isHidden = false;
			if(_isMine) Board.endGame();
			return;
		}
		_isHidden = true;
	}
	
	private void determineDisplayCharacter() {
		if (_isHidden) {
			if (_isFlagged) {
				_displayCharacter = "?";
			}else {
				_displayCharacter = "x";
			}
		}else {
			if (_neighborMines == -1) {
				findNeighborMines();
				determineDisplayCharacter();
			}else if (_neighborMines == 0) {
				_displayCharacter = " ";
			}else {
				_displayCharacter = Integer.toString(_neighborMines);
			}
		}
	}
	
	private void findNeighborMines() {
		
		_neighborMines = 0;
		int size = Board.getBoard().length;
		
		 int myRow = -1, myCol = -1;
		 for (int row = -1; row < 3; row++) {
			 myRow = yCoord + row;
			 if (myRow < 0) continue;
			 if (myRow >= size) break;
			 for (int col = -1; col < 3; col++) {
				 myCol = xCoord + col;
				 if (xCoord < 0) continue;
				 if (xCoord >= size) break;
				 if (Board.getBoard()[myRow][myCol].isMine()) _neighborMines++;
			 }
		 }
	}
	
	public boolean isHidden() {
		return _isHidden;
	}
	
	public void setMine() {
		_isMine = true;
	}
	
	public boolean isMine() {
		return _isMine;
	}
	
}

