package application;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {

	@Test
	public void hiddenTest() {		
		// Build board
		Board boardObject = new Board();
		boardObject.buildBoard();
		// Reveal 90 cells
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 10; col++) {
				Board.getBoard()[row][col].changeHiddenStatus();
			}
		}
		Board.getBoard()[9][0].changeHiddenStatus();
		boardObject.checkBoard();
		// Test Method checkBoard
		assertEquals(9, Board.numHidden);
	}

}
