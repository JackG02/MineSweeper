package application;

import org.junit.Test;
import static org.junit.Assert.*;

class CellTest {

	@Test
	void constructTest() {
		Cell cell = new Cell(1,1);
		assertEquals(1, cell.getX());
	}
	
	@Test
	void changeHiddenStatusTest() {
		Cell cell = new Cell(1,1);
		cell.changeHiddenStatus();
		assertFalse(cell.isHidden());
	}
	
	@Test
	void determineFlaggedDisplayTest() {
		Cell cell = new Cell(1,1);
		cell._isFlagged = true;
		cell.determineDisplayCharacter();
		assertEquals("?", cell._displayCharacter);
	}
	
	@Test
	void determineHiddenDisplayTest() {
		Cell cell = new Cell(1,1);
		cell.determineDisplayCharacter();
		assertEquals("x", cell._displayCharacter);
	}
	
	@Test
	void determineEmptyDisplayTest() {
		Cell cell = new Cell(1,1);
		cell.changeHiddenStatus();
		
		Board board = new Board();
		board.buildBoard();
		
		cell.determineDisplayCharacter();

		assertEquals(" ", cell._displayCharacter);
	}
	
	@Test
	void determineNeighborDisplayTest() {
		Cell cell = new Cell(1,1);
		cell.changeHiddenStatus();
		
		Board board = new Board();
		board.buildBoard();
		
		Board._board[0][0]._isMine = true;
		Board._board[0][1]._isMine = true;
		Board._board[0][2]._isMine = true;
		Board._board[1][0]._isMine = true;
		Board._board[1][2]._isMine = true;
		Board._board[2][0]._isMine = true;
		Board._board[2][1]._isMine = true;
		Board._board[2][2]._isMine = true;
		
		cell.determineDisplayCharacter();

		assertEquals("8", cell._displayCharacter);
	}
	
	@Test
	void Test() {
		Cell cell = new Cell(1,1);
		
	}

}
