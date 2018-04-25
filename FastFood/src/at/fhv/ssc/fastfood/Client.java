package at.fhv.ssc.fastfood;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by sebastian on 05.09.2017.
 */
public class Client {

    public Client(String host, int port){

        try(Socket socket = new Socket(host,port);) {
            @SuppressWarnings("resource")
            Scanner stdIn = new Scanner(System.in);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String input = null;
            System.out.println("Connection established!");

            while ((input = stdIn.nextLine()) != null) {
                out.println(input);
            }
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Client("localhost", 4444);
    }
}
