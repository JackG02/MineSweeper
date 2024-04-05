package application;

public class Cell {
	
	boolean _isHidden;
	boolean _isMine;
	boolean _isFlagged;
	int _neighborMines;
	
	int colCoord;
	int rowCoord;
	
	String _displayCharacter;
	
	public Cell(int row, int col) {
		_isHidden = true;
		_isMine = false;
		_neighborMines = -1;
		colCoord = col;
		rowCoord = row;
	}
	
	public void changeHiddenStatus() {
		if(_isHidden) {
			_isHidden = false;
			return;
		}
		_isHidden = true;
	}
	
	public void determineDisplayCharacter() {
//		if (_isMine) {
//			_displayCharacter = "B";
//			return;
//		}
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
	
	public void findNeighborMines() {
		
		_neighborMines = 0;
		int size = Board.getBoard().length - 1;
		
		 int myRow = -1, myCol = -1;
		 for (int row = -1; row < 2; row++) {
			 myRow = rowCoord + row;
			 if (myRow < 0) continue;
			 if (myRow > size) break;
			 for (int col = -1; col < 2; col++) {
				 myCol = colCoord + col;
				 if (myCol < 0) continue;
				 if (myCol > size) break;
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
	
	public int getCol() {
		return colCoord;
	}
	
	public int getRow() {
		return rowCoord;
	}
}

