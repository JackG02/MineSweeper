package application;

public class Cell {
	
	boolean _isHidden;
	
	boolean _isMine;
	
	public void Cell() {
		_isHidden = true;
		_isMine = false;
	}
	
	private void changeHiddenStatus() {
		if(_isHidden) {
			_isHidden = false;
			return;
		}
		_isHidden = true;
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

