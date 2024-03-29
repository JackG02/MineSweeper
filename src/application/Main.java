package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;


public class Main extends Application {
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			// set a title for the Window
			primaryStage.setTitle("Minesweeper");
			
			// get an FXML loader and read in the fxml code
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/GameScene.fxml"));
			AnchorPane mainLayout = (AnchorPane)loader.load();
			// Create the scene with the layout in the fxml code, set the scene and show it
			Scene scene = new Scene(mainLayout);
			primaryStage.setScene(scene);
			//System.out.println(mainLayout.getChildren().get(0));
//			Board board = new Board();
//			board.buildBoard();
			

			primaryStage.show();
			
			
			GameSceneController controller = loader.getController();
			Board.assignController(controller);
			Board.buildBoard();
			controller.buildBoard();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}