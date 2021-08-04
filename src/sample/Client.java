package sample;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public String adm;
    public Client(String adm) {
        this.adm=adm;
    }

    public String getAdm() {
        return adm;
    }

    public void setAdm(String adm) {
        this.adm = adm;
    }
    public void communicate(){
        String ip = "localhost";
        int port = 9999;
        try {

            Socket s = new Socket(ip, port);

//            String str = "TEST 1 BUDDY";
            System.out.println("Client communicate called with"+adm);
            OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
            PrintWriter out = new PrintWriter(os);
            os.write(adm);
            os.flush();
            System.out.println("Client finshed");
        } catch (Exception ex) {
            System.out.println("exception encountered is " + ex);
        }
    }

//    public static void main(String[] args) {
//
//        String ip = "localhost";
//        int port = 9999;
//        try {
//            Socket s = new Socket(ip, port);
//
//            String str = "TEST 1 BUDDY";
//            OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
//            PrintWriter out = new PrintWriter(os);
//            os.write(str);
//            os.flush();
//        } catch (Exception ex) {
//            System.out.println("exception encountered is " + ex);
//        }
//    }
}
