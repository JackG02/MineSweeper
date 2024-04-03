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
	
	@Test
	public void revealTest() {		
		// Build board
		Board boardObject = new Board();
		boardObject.buildBoard();

		Board._board[1][2].setMine();
		boardObject.revealCell(2, 2);

		// Test Method checkBoard
		assertEquals(true, Board._board[0][2].isHidden());
		assertEquals(true, Board._board[1][1].isHidden());
		assertEquals(true, Board._board[1][2].isHidden());
		assertEquals(true, Board._board[1][3].isHidden());
	}

}
