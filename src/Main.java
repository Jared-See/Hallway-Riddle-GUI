import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    Button testButton;
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception { // Main Code for JavaFX
        primaryStage.setTitle("Title of the window"); //Titles of the window
        testButton = new Button(); //Creates Button
        testButton.setText("Click Me"); //Labels Button

        StackPane layout = new StackPane();
        layout.getChildren().add(testButton);

        Scene scene = new Scene(layout,  300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
