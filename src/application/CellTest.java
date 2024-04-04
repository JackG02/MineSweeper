package application;

import org.junit.Test;
import static org.junit.Assert.*;

public class CellTest {

	@Test
	public void constructTest() {
		Cell cell = new Cell(1,3);
		assertEquals(1, cell.getRow());
		assertEquals(3, cell.getCol());
	}
	
	@Test
	public void changeHiddenStatusTest() {
		Cell cell = new Cell(1,1);
		cell.changeHiddenStatus();
		assertFalse(cell.isHidden());
	}
	
	@Test
	public void determineFlaggedDisplayTest() {
		Cell cell = new Cell(1,1);
		cell._isFlagged = true;
		cell.determineDisplayCharacter();
		assertEquals("?", cell._displayCharacter);
	}
	
	@Test
	public void determineHiddenDisplayTest() {
		Cell cell = new Cell(1,1);
		cell.determineDisplayCharacter();
		assertEquals("x", cell._displayCharacter);
	}
	
	@Test
	public void determineEmptyDisplayTest() {
		Cell cell = new Cell(1,1);
		cell.changeHiddenStatus();
		
		Board board = new Board();
		board.buildBoard();
		
		cell.determineDisplayCharacter();

		assertEquals(" ", cell._displayCharacter);
	}
	
	@Test
	public void determineNeighborDisplayTest() {
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

}
