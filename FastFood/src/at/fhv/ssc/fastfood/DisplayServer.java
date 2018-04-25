package at.fhv.ssc.fastfood;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by sebastian on 05.09.2017.
 */
public class DisplayServer {

   private FastFood _fastfood;

   public DisplayServer(int port, FastFood fastfood) {
       _fastfood = fastfood;

       try (ServerSocket ss = new ServerSocket(port);) {
           Socket socket = ss.accept();
           Scanner in = new Scanner(socket.getInputStream());

           String input = null;
           while ((input = in.nextLine()) != null) {
               fastfood.setMeal(input);
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
    public static void main(String[] args){
       FastFood f = new FastFood();
       new DisplayServer(4444,f );
    }





}
