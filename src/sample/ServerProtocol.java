package sample;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ServerProtocol {
    String fromClient;
    String admNo;
    String name;
    String course;
    String faculty;

    public String handleClientData(String data) {
        String[] clientData = null;
        if (data != null && data.contains("Admission Number")) {
            clientData = data.split(",", 4);

            assert clientData != null;
            admNo = clientData[0];
            name = clientData[1];
            course = clientData[2];
            faculty = clientData[3];

            fromClient = admNo + "\n\t\t" + name + "\n\t\t" + course + "\n\t\t" + faculty;

        } else {
            fromClient = data;
        }

        return fromClient;
    }
}
