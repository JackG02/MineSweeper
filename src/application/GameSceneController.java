package application;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.Priority;


public class GameSceneController {
	@FXML
	private Label MinesLeft;
	@FXML
	private GridPane gameBoard;

	
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
			}
			
		}
		
	}

	// creates empty button size 30 by 30 for gridPane
	private Button createButton() {
		Button button = new Button();
		button.setMaxSize(30, 30);
		return button;
	}
		
	@FXML
	public static void endGame() {
		System.out.println("test");
		return;
	}
}
