package sample;

import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    int port;
//    Socket s;
//    public  Server(int port) {
//        this.port = port;
//    }
//
//    public String StartServer(){
//        try{
//
//            ServerSocket ss = new ServerSocket(port);
//            Controller controller=new Controller();
//            controller.setProceedings("controller.proceedings.setText(\"Sever running on port \n"+ port);
//
////             s = ss.accept();
////            sendSucessAlert(s);
//
//
//
//            return "Successfully connected to a Client";
//        }catch(Exception ex){
//
//            System.out.println("Server run into an error"+ex);
//            return "Successfully connected to a Client "+ex.toString();
//        }
//    }
//    public String promptClient(){
//        try{
//
//            System.out.println("Client Connected");
//            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//            String str = br.readLine();
//            System.out.println("client Data: " + str);
//
//            return "Successfully connected to a Client";
//        }catch(Exception ex){
//
//            System.out.println("Server run into an error"+ex);
//            return "Successfully connected to a Client "+ex.toString();
//        }
//    }
//
//    public void sendSucessAlert(Socket s){
//        try {
//            String resp = "Sucessfully Connected to the server \n";
//            OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
//            PrintWriter out = new PrintWriter(os);
//            out.write(resp);
//            out.flush();
//        }
//        catch(Exception ex){
//            System.out.println("Run into an exception "+ ex.toString());
//        }
//    }
////    public static void main(String[] args) {
////        try {
////            System.out.println("server is started");
////            ServerSocket ss = new ServerSocket(9999);
////            System.out.println("Server is waiting for client request");
////            Socket s = ss.accept();
////            System.out.println("client Connected");
////            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
////            String str = br.readLine();
////            System.out.println("client Data: "+str);
////
////        } catch (Exception ex) {
////            System.out.println("Error on serve side is " + ex);
////        }
////    }

}
