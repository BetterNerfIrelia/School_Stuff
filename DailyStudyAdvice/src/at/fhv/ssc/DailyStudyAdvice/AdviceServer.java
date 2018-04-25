package at.fhv.ssc.DailyStudyAdvice;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AdviceServer {

    String[] _adviceList = {"Uni is Life", "Work hard, play hard", "Just chill"};

    public void justDoIt() {

        try {
            ServerSocket serversocket = new ServerSocket(5000);

            while(true){
                Socket sock = serversocket.accept();

                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String getAdvice(){
        int random = (int) (Math.random() * _adviceList.length);
        return _adviceList[random];
    }

    public static void main(String[] args){
        AdviceServer server = new AdviceServer();
        server.justDoIt();


    }



}
