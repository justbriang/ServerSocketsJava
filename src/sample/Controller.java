package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.input.MouseEvent;


import java.io.*;
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
        } else if (s.isConnected()) {
            String resp = "Server is requesting for data \n";
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
                proceedings.appendText("A port number is required\n");
                return;
            }

            if (Integer.parseInt(port.getText()) > 65535) {
                proceedings.appendText("Port entered is invalid\n");
                return;
            }

            ss = new ServerSocket(Integer.parseInt(port.getText()));

            proceedings.appendText("Server running on port " + port.getText() + "\n");
            proceedings.appendText("Server waiting for client ...\n");
            stopbtn.visibleProperty().setValue(Boolean.TRUE);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        s = ss.accept();

                        if (s.isConnected()) {
                            sendData.visibleProperty().setValue(Boolean.TRUE);
                            proceedings.appendText("\nClient Successfully connected\n");
                            String resp = "Connection Successful \nServer is requesting for data \n";
                            sendSucessAlert(resp);

                            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

                            while (!(s.isClosed())) {
                                String str;
                                ServerProtocol handleData = new ServerProtocol();
                                while ((str = br.readLine()) != null) {
                                    if (str.contains("Admission Number")) {
                                        sendSucessAlert("Details well Received!\n");
                                    }
                                    proceedings.appendText("Client:\t" + handleData.handleClientData(str) + "\n");
                                }

                                // Check for client disconnection
                                if (br.read() == -1) {
                                    // Notify via terminal, close connection
                                    System.out.println("Client disconnected. Socket closing...");
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
            proceedings.appendText("\n-----\n\n" + ex + "\n\n-----\n");
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
            proceedings.appendText("\n-----\n\n" + ex + "\n\n-----\n");
        }
    }

    public void sendSucessAlert(String resp) {
        try {
            OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
            PrintWriter out = new PrintWriter(os);
            out.write(resp);
            out.flush();
            proceedings.appendText(resp + "\n");
        } catch (Exception ex) {
            proceedings.appendText("\n-----\n\n" + ex + "\n\n-----\n");
        }
    }
}
