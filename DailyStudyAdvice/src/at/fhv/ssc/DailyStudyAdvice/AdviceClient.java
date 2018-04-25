package at.fhv.ssc.DailyStudyAdvice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class AdviceClient {

    public void justDoIt() {

        try {
            Socket s = new Socket("localhost", 5000);

            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));

            String advice = reader.readLine();
            System.out.println("Always remember: " + advice);

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        AdviceClient client = new AdviceClient();
        client.justDoIt();
    }
}
