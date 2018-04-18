import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage window;


    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Hallway Riddle");

        //GridPane with 10px padding around edge
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
        TextField doorsInput = new TextField(""); //Creates the Input Label
        GridPane.setConstraints(doorsInput, 1,1); //Gives the input label a place to appear
        doorsInput.setPromptText("100");

        //Door of Interest Label
        Label doorOfInterestLabel = new Label("What door do you want to know the state of"); //Creates the Label
        GridPane.setConstraints(doorOfInterestLabel, 2,0); //Gives the label a place to appear

        //Number of Loops Input
        TextField doorOfInterestinput = new TextField(); //Creates the Input Label
        GridPane.setConstraints(doorOfInterestinput, 2,1); //Gives the input label a place to appear
        doorOfInterestinput.setPromptText("98");

        //Button to solve it
        Button solveButton = new Button("Solve");
        GridPane.setConstraints(solveButton, 3, 1);
        solveButton.setStyle("-fx-color: #c13232");

        //Button on click
        solveButton.setOnAction(e -> {
            //Creates String Variables for the Text Fields
            String doorOfInterest = doorOfInterestinput.getText();
            String totalDoor = doorsInput.getText();
            String totalLoops = loopInput.getText();

            // Checks to make sure the textfields are filled in
            if (totalLoops.isEmpty() || doorOfInterest.isEmpty() || totalDoor.isEmpty()){
                AlertBox.display("Error", "You need to fill in all of the boxes. Try Again");
            }else{
                //Creates Int Variables for the Numbers entered into the text field
                int doorOfInterestInt = Integer.parseInt(doorOfInterest);
                int totalDoorInt = Integer.parseInt(totalDoor);
                int totalLoopsInt = Integer.parseInt(totalLoops);


                //Check if the total door is less than the door of interest try again
                if (totalDoorInt < doorOfInterestInt){
                    AlertBox.display("Error", "Your Door of Interest is less than the total doors, that doesn't add up. Try Again");
                } else {
                    //Finds the state of the door based on the input variables
                    door_state_find(totalDoorInt, totalLoopsInt, doorOfInterestInt);
                }

            }
        });

        //Add everything to grid
        grid.getChildren().addAll(loopLabel, loopInput, doorsLabel, doorsInput, doorOfInterestLabel, doorOfInterestinput, solveButton);

        //Displays everything to the GUI
        Scene scene = new Scene(grid, 800, 500);
        scene.getStylesheets().add("stylesheet.css"); //Allows our custom css stylesheet
        window.setScene(scene);
        window.show();
    }





    //Method for determining the state (Open or Close) of a door
    public static boolean door_state_find(int number_of_door, int number_of_loops, int door_of_interest){
        //Declaring Variables
        int i = 1;
        boolean door_checker = true; //Figures out if the door changes state on the loop
        boolean state_of_door = false; //The door starts out as closed

        while(i <= number_of_loops){ //Simulates someone walking up the hallway for the number of loops
            //Switches the state of the door when necessary
            if(door_checker == true){
                if (state_of_door == false) { state_of_door = true; } //Switches value of door
                else if (state_of_door == true) { state_of_door = false; } //Switches state of door
            }

            i++; //Moves onto next loop or walk up the hallway

            if(door_of_interest % i == 0){ //The person interacts with the D.O.I
                door_checker = true; //You need to change the state of the door
            }  else {
                door_checker = false; //Otherwise you don't need to change the state of the door
            }
        }

        //Outputs the state of the door
        if(state_of_door == true){
            AlertBox.display("Results", " Door #"+door_of_interest + " would be open");
        }
        if(state_of_door == false){
            AlertBox.display("Results", " Door #"+door_of_interest + " would be closed");
        }
        return state_of_door;
    }
}