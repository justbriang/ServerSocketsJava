package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.input.MouseEvent;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public javafx.scene.control.TextField port;
    public javafx.scene.control.TextArea proceedings;
    public Button stopbtn;
    public Button sendData;
    private ServerSocket ss;
    private Socket s;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        stopbtn.visibleProperty().setValue(Boolean.FALSE);
        sendData.visibleProperty().setValue(Boolean.FALSE);
        port.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("\\d*")) {
                    port.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    public void sendMessage(MouseEvent mouseEvent) {
        if (!s.isConnected()) {
            sendData.visibleProperty().setValue(Boolean.FALSE);
        }else if(s.isConnected()){
            String resp = "Server is Requesting for data \n";
            sendSucessAlert(resp);
        }

    }

    public void startServer(MouseEvent mouseEvent) {

        try {
            port.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                    if (!t1.matches("\\d*")) {
                        port.setText(t1.replaceAll("[^\\d]", ""));
                    }
                }
            });

            if (port.getText().isEmpty()) {
//                port.setText("8000");
                proceedings.appendText("A port number is required\n");
                return;

            }
            if (Integer.parseInt(port.getText()) > 65535) {
                proceedings.appendText("Port entered is invalid\n");
                return;
            }
            ss = new ServerSocket(Integer.parseInt(port.getText()));

            proceedings.appendText("Server running on port 8000\n");
            proceedings.appendText("Server waiting for client ...\n");
            stopbtn.visibleProperty().setValue(Boolean.TRUE);
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {

                        s = ss.accept();

                        if (s.isConnected()) {
                            sendData.visibleProperty().setValue(Boolean.TRUE);
                            proceedings.appendText("Client Successfully connected\n");
                            String resp = "Sucessfully Connected to the server \n";
                            sendSucessAlert(resp);
                            while (!(s.isClosed())) {

                                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                                String str = br.readLine();
                                proceedings.appendText(str + "\n");
                                // Check for client disconnection
                                if(br.read() == -1){
                                    // Notify via terminal, close connection
                                    System.out.println("client disconnected. Socket closing...");
                                    s.close();
                                }

                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

            }).start();



        } catch (Exception ex) {
            proceedings.appendText("exception " + ex + " encountered\n");
        }
    }


    public void stopServer(MouseEvent mouseEvent) {

        if (ss.isClosed()) {
            stopbtn.visibleProperty().setValue(Boolean.FALSE);

        }
        try {
            ss.close();

            proceedings.appendText("Server stopped\n");
            stopbtn.visibleProperty().setValue(Boolean.FALSE);
        } catch (Exception ex) {
            proceedings.appendText("exception " + ex + " encountered\n");
        }
    }

    public void sendSucessAlert(String resp) {
        try {

            OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
            PrintWriter out = new PrintWriter(os);
            out.write(resp);
            out.flush();
            proceedings.appendText(resp +"\n");
        } catch (Exception ex) {
            proceedings.appendText("exception " + ex + " encountered\n");
        }
    }
}
