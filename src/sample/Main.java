package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Main extends Application {

    public Stage primaryStage;
    @Override
    public void start(Stage primaryStage)  throws Exception{
        this.primaryStage=primaryStage;

        primaryStage.setTitle("Simple sockets project");


        // Create the registration form pane
        GridPane gridPane = createLandingPage();
        addLandingpgUIControls(gridPane);
        // Create a scene with the registration form gridPane as the root node.
        Scene scene = new Scene(gridPane, 800, 500);
        // Set the scene in primary stage
        primaryStage.setScene(scene);

        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
    private GridPane createLandingPage() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);



        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }



    private void addLandingpgUIControls(GridPane gridPane) {
        // Add Header
        Label headerLabel = new Label("Landing Page");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Submit Button
        Button submitButton = new Button("Start Server");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 4, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));


     submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              Server server= new Server();
                Thread t = new Thread(server);
                t.start();



                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(),
                        "Server started Successful!", "Welcome buddy this is the bid dsay for you");


          startclientWindow();

            }
        });


    }

    public void startclientWindow(){
        //Create the Client Form pane
        GridPane gridPane = createRegistrationFormPane();
        addClientUIControls(gridPane);
        //Create a scene with the Client form gridPane as the root node.
        Scene scene = new Scene(gridPane, 800, 500);
        //Set the scene in primary stage
        primaryStage.setScene(scene);

        primaryStage.show();
    }
    private GridPane createRegistrationFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }
    private void addClientUIControls(GridPane gridPane) {
        // Add Header
        Label headerLabel = new Label("Client side");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Name Label
        Label nameLabel = new Label("Full Name : ");
        gridPane.add(nameLabel, 0,1);

        // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1,1);


        // Add student number Field Label
        Label studentNoLabel = new Label("Student Number : ");
        gridPane.add(studentNoLabel, 0, 2);

        // Add student number  Text Field
        TextField studentNoField = new TextField();
        studentNoField.setPrefHeight(40);
        gridPane.add(studentNoField, 1, 2);

        // Add firstname Label
        Label facultyLabel = new Label("Faculty: ");
        gridPane.add(facultyLabel, 0, 3);

        // Add firstField Text Field
        TextField facultyField = new TextField();
        facultyField.setPrefHeight(40);
        gridPane.add(facultyField, 1, 3);

        // Add firstname Label
        Label courseLabel = new Label("Course: ");
        gridPane.add(courseLabel, 0, 4);

        // Add firstField Text Field
        TextField courseField = new TextField();
        courseField.setPrefHeight(40);
        gridPane.add(courseField, 1, 4);


        // Add firstname Labels
        Label starLabel = new Label("Horoscope : ");
        gridPane.add(starLabel, 0, 5);

        // Add firstField Text Field
        final ComboBox starComboBox = new ComboBox();
        starComboBox.setPrefHeight(40);
        starComboBox.setPromptText("HoroScope");
        starComboBox.setPlaceholder(starLabel);
        gridPane.add(starComboBox,1,5);
        starComboBox.getItems().addAll(
                "Aries", "Taurus", "Gemini"," Cancer"," Leo"," Virgo"," Libra", "Scorpio","Sagittarius","Capricorn"," Aquarius","Pisces"

        );
//        TextField courseField = new TextField();
//        courseField.setPrefHeight(40);
//        gridPane.add(courseField, 1, 4);





//        // Add Password Label
//        Label passwordLabel = new Label("Password : ");
//        gridPane.add(passwordLabel, 0, 3);
//
//        // Add Password Field
//        PasswordField passwordField = new PasswordField();
//        passwordField.setPrefHeight(40);
//        gridPane.add(passwordField, 1, 3);

        // Add Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 6, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));


        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(nameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(),
                            "Form Error!", "Please enter your name");
                    return;
                }
                if(studentNoField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(),
                            "Form Error!", "Please enter your student id");
                    return;
                }
                if(courseField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(),
                            "Form Error!", "Please enter a course field");
                    return;
                }
                if(facultyField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(),
                            "Form Error!", "Please enter your faculty");
                    return;
                }

                if(starComboBox.getId()==null) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(),
                            "Form Error!", "Please enter pick one");
                    return;
                }

                Client client=new Client(nameField.getText().toString());
                client.communicate();
                System.out.println("name is :"+nameField.getText().toString());

                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(),
                        "Registration Successful!", "Welcome " + nameField.getText());
            }
        });


    }
    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.setResizable(true);
        alert.onShownProperty().addListener(e -> {
            Platform.runLater(() -> alert.setResizable(false));
        });

        alert.show();
    }

}