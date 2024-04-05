package application;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.Priority;


public class GameSceneController {
	@FXML
	private Label MinesLeft;
	@FXML
	public GridPane gameBoard;

	
	public void buildBoard() {
		// allows rows to grow and set constraints for Height of gridPane
		System.out.println(gameBoard.toString());
//		System.out.println(GameBoard.getRowConstraints());
//		System.out.println(GameBoard.getColumnConstraints());
		
		gameBoard.getRowConstraints().clear();
		gameBoard.getColumnConstraints().clear();
		
		int numRows = 10;
		int numCols = 10;
		
		for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
			RowConstraints rc = new RowConstraints();
			rc.setVgrow(Priority.ALWAYS);
			rc.setFillHeight(true);
			gameBoard.getRowConstraints().add(rc);
		}
		// allows Columns to grow and set constraints for Width of gridPane
		for (int colIndex = 0; colIndex < numCols; colIndex++) {
			ColumnConstraints cc = new ColumnConstraints();
			cc.setHgrow(Priority.ALWAYS);
			cc.setFillWidth(true);
			gameBoard.getColumnConstraints().add(cc);
		}
		// fills the board with buttons based on constraints made above
		for (int colIndex = 0; colIndex < numCols; colIndex++) {
			for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
				Button button = createButton();
				gameBoard.add(button, colIndex, rowIndex);
				//http://www.java2s.com/example/java-api/javafx/scene/control/button/setonaction-1-0.html
			
				button.addEventHandler(MouseEvent.MOUSE_CLICKED, 
						new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent e) {
							System.out.println(e.getButton().toString());
							//Left Click
							int row = GridPane.getRowIndex(button);
							int col = GridPane.getColumnIndex(button);
							
							
							if(e.getButton() == MouseButton.SECONDARY) {
								if(Board._board[row][col]._isFlagged) {
									Board._board[row][col]._isFlagged = false;
									Board.decrementFlag();
									System.out.println("dec");
								}
								else if(!Board._board[row][col]._isFlagged && Board.getFlag() < 10) {
									Board._board[row][col]._isFlagged = true;
									Board.incrementFlag();
									System.out.println("inc");
								}
//								MinesLeft.setText(Integer.toString(Board.getFlag()));
								updateBoardVisuals();
							}
							else if (e.getButton() == MouseButton.PRIMARY){
								System.out.println(
										"Button clicked at: " + 
										row + 
										", " +
										col
										);
		
								Board.revealCell(row, col);
								updateBoardVisuals();
							}
						}
				});
				
				
//				button.setOnAction( new EventHandler<ActionEvent>() {
//					public void handle(ActionEvent event) {
//						System.out.println(
//								"Button clicked at: " + 
//								GridPane.getRowIndex(button) + 
//								", " + 
//								GridPane.getColumnIndex(button));
//					}
//				});
				
					
			}
			
		}
		
		updateBoardVisuals();
	}
	
	// creates empty button size 30 by 30 for gridPane
	private Button createButton() {
		Button button = new Button();
		button.setMaxSize(35, 35);
		return button;
	}
	
	public void updateBoardVisuals() {
		ObservableList<Node> children = gameBoard.getChildren();
		for (int i = 0; i < children.size(); i++) {
			int x = GridPane.getColumnIndex(children.get(i));
			int y = GridPane.getRowIndex(children.get(i));
			
			Cell c = Board.getBoard()[y][x];
			c.determineDisplayCharacter();
			
			MinesLeft.setText(Integer.toString(10 - Board.getFlag()));
			
			Button b = (Button)children.get(i);
			b.setText(c._displayCharacter);
		}
	}
		
	public static void endGame() {
		System.out.println("End Game - Controller");
		return;
	}
	
}
