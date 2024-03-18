package application;

public class Cell {

	private enum State {
		HIDDEN,
		REVEALED
	}
	
	State _state;
	
	public void Cell() {
		_state = State.HIDDEN;
	}
	
}
