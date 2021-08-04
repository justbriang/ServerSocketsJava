package sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
    public void startServer(){

    }

    @Override
    public void run() {
        try {
            System.out.println("server is started");
            ServerSocket ss = new ServerSocket(9999);
            System.out.println("Server is waiting for client request");
            Socket s = ss.accept();
            System.out.println("client Connected");
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String str = br.readLine();
            System.out.println("client Data: "+str);

        } catch (Exception ex) {
            System.out.println("Error on serve side is " + ex);
        }
    }
//    public static void main(String[] args) {
//        try {
//            System.out.println("server is started");
//            ServerSocket ss = new ServerSocket(9999);
//            System.out.println("Server is waiting for client request");
//            Socket s = ss.accept();
//            System.out.println("client Connected");
//            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//            String str = br.readLine();
//            System.out.println("client Data: "+str);
//
//        } catch (Exception ex) {
//            System.out.println("Error on serve side is " + ex);
//        }
//    }

}
