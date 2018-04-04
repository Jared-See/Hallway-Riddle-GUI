/*import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent> {
    Stage window;

    public static void main(String[] args) {
        launch(args); //Launches the "import javafx.application.Application"
    }

    @Override
    public void start(Stage primaryStage) throws Exception { // Main Code for JavaFX goes here
        window = primaryStage;
        window.setTitle("Hallway Riddle Solver");
        //Creates the Grid
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Number Of Loops Label
        Label loopLabel = new Label("How many loops are there?"); //Creates the Label
        GridPane.setConstraints(loopLabel, 0,0); //Gives the label a place to appear

        //Number of Loops Input
        TextField loopInput = new TextField(); //Creates the input Label
        GridPane.setConstraints(loopInput, 0,1); //Gives the input label a place to appear
        loopInput.setPromptText("100");

        //Number Of Doors Label
        Label doorsLabel = new Label("How many doors are in your hallway"); //Creates the Label
        GridPane.setConstraints(doorsLabel, 1,0); //Gives the label a place to appear

        //Number of Doors Input
        TextField doorsInput = new TextField("How many doors are in your hallway"); //Creates the Input Label
        GridPane.setConstraints(doorsInput, 1,1); //Gives the input label a place to appear
        doorsInput.setPromptText("100");

        //Door of Interest Label
        Label doorOfInterestLabel = new Label("What door do you want to know the state of"); //Creates the Label
        GridPane.setConstraints(doorOfInterestLabel, 2,0); //Gives the label a place to appear

        //Number of Loops Input
        TextField doorOfInterestinput = new TextField(); //Creates the Input Label
        GridPane.setConstraints(doorOfInterestinput, 2,1); //Gives the input label a place to appear
        doorOfInterestinput.setPromptText("98");

        Button solveButton = new Button("Solve");
        GridPane.setConstraints(solveButton, 3, 1);

        //Adds Everything to the Grid
        grid.getChildren().addAll(loopInput, loopInput, doorOfInterestinput, doorOfInterestLabel, doorsInput, doorsLabel, solveButton);

        Scene scene = new Scene(grid, 300, 200);
        window.setScene(scene);
        window.show();
    }
}
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("thenewboston - JavaFX");

        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Name Label - constrains use (child, column, row)
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 0);

        //Name Input
        TextField nameInput = new TextField("Bucky");
        GridPane.setConstraints(nameInput, 1, 0);

        //Password Label
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 1);

        //Password Input
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 1);

        //Login
        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton, 1, 2);

        //Add everything to grid
        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);

        Scene scene = new Scene(grid, 300, 200);
        window.setScene(scene);
        window.show();
    }


}