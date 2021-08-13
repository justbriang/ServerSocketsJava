package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
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

import javax.swing.event.ChangeListener;

public class Main extends Application {

    public Stage primaryStage;
    Server server;
    GridPane gridPane;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        primaryStage.setTitle("Simple sockets project");
        // Create the Landing page pane
        Parent homeroot=FXMLLoader.load(getClass().getResource("sample.fxml"));
//         gridPane = createLandingPage();
//        //add components to the pane
//        addLandingpgUIControls();
        // Create a scene with the landingpage  gridPane as the root node.
        Scene scene = new Scene(homeroot, 800, 500);
        // Set the scene in primary stage
        primaryStage.setScene(scene);

        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }

//    private GridPane createLandingPage() {
//        // Instantiate a new Grid Pane
//        GridPane gridPane = new GridPane();
//
//        // Position the pane at the center of the screen, both vertically and horizontally
//        gridPane.setAlignment(Pos.CENTER);
//
//        // Set a padding of 20px on each side
//        gridPane.setPadding(new Insets(40, 40, 40, 40));
//
//        // Set the horizontal gap between columns
//        gridPane.setHgap(10);
//
//        // Set the vertical gap between rows
//        gridPane.setVgap(10);
//
//
//        // columnOneConstraints will be applied to all the nodes placed in column one.
//        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
//        columnOneConstraints.setHalignment(HPos.RIGHT);
//
//        // columnTwoConstraints will be applied to all the nodes placed in column two.
//        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
//        columnTwoConstrains.setHgrow(Priority.ALWAYS);
//
//        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
//
//        return gridPane;
//    }
//
//
//    private void addLandingpgUIControls() {
//        // Add Header
//        Label headerLabel = new Label("Server Page");
//        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
//        gridPane.add(headerLabel, 0, 0, 2, 1);
//        GridPane.setHalignment(headerLabel, HPos.CENTER);
//        GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));
//        // Add Port Label
//        Label nameLabel = new Label("Port Number : ");
//        gridPane.add(nameLabel, 0, 1);
//
//        // Add Port Text Field
//        TextField portField = new TextField();
//        portField.setPrefHeight(40);
//        portField.textProperty().addListener(new javafx.beans.value.ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
//                if (!newValue.matches("\\d*")) {
//                    portField.setText(newValue.replaceAll("[^\\d]", ""));
//                }
//            }
//        });
//
//        gridPane.add(portField, 1, 1);
//        // Add Proceedings Text Field
//        // Add Port Label
//        Label logLabel = new Label("Proceedings : ");
//        gridPane.add(logLabel, 1, 4);
//
//
//        TextArea logField = new TextArea();
//        logField.setPrefHeight(100);
//
//        gridPane.add(logField, 1, 5);
//
//
//        // Add Connect Button
//        Button submitButton = new Button("Start Server");
//        submitButton.setPrefHeight(40);
//        submitButton.setDefaultButton(true);
//        submitButton.setPrefWidth(100);
//        gridPane.add(submitButton, 3, 1 );
//        GridPane.setHalignment(submitButton, HPos.CENTER);
//        GridPane.setMargin(submitButton, new Insets(20, 0, 20, 0));
//
//        // Prompt Client for Auth data
//        Button promptButton = new Button("Prompt Client");
//        promptButton.setPrefHeight(40);
//        promptButton.setDefaultButton(true);
//        promptButton.setPrefWidth(300);
//        gridPane.add(promptButton, 1, 3);
//        GridPane.setHalignment(promptButton, HPos.CENTER);
//        GridPane.setMargin(promptButton, new Insets(20, 0, 20, 0));
//        submitButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                if (portField.getText().isEmpty()) {
//                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(),
//                            "Form Error!", "Please enter the port you wish to use");
//                    return;
//                }
//                if (Integer.parseInt(portField.getText()) > 65535) {
//                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(),
//                            "Form Error!", "Invalid Port");
//                    return;
//                }
//
//                Server server = new Server(Integer.parseInt(portField.getText()));
//
////                Thread t = new Thread(server);
////                t.start();
//               String resp= server.StartServer(logField);
//
//               logField.setText(resp);
////                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(),
////                        "Server started Successful!", "Server Successfully running on port " + Integer.parseInt(portField.getText()));
//
//
//            }
//        });
//
//        promptButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                server.promptClient();
//            }
//        });
//
//
//    }
//
//    public void callshowAlert(String s,GridPane gridPane) {
//        System.out.println("this has been called with"+s);
//        showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(),
//                "Server started Successful!", "Server Successfully running on port " + s);
//    }
//    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
//        Alert alert = new Alert(alertType);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.initOwner(owner);
//        alert.setResizable(true);
//        alert.onShownProperty().addListener(e -> {
//            Platform.runLater(() -> alert.setResizable(false));
//        });
//
//        alert.show();
//    }

}