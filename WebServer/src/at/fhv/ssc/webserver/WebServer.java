package at.fhv.ssc.webserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class WebServer {

    public WebServer(int port) {

        try (ServerSocket ss = new ServerSocket(port)) {
            while (true) {
                Socket socket = ss.accept();

                PrintStream out = new PrintStream(socket.getOutputStream(), true);
                Scanner in = new Scanner(socket.getInputStream());

                String input = null;
                StringBuilder sb = new StringBuilder();
                while (!(input = in.nextLine()).isEmpty()) {
                    sb.append(input + " ");
                }
                System.out.println(sb);
                String str = sb.toString();

                if (str.matches("^GET .+ HTTP/1.1 Host: .+")) {

                    String[] parts = str.split(" ");
                    String document = parts[1];                                         //  /Text1.html    ODER      http://localhost/Text1.html

                    if (document.matches("^h.+")) {                               //  http://localhost/Text1.html

                        String doc = document.substring(document.indexOf("/") + 1);    //  localhost/Text1.html
                        document = doc.substring(doc.indexOf("/") - 1);                //  /Text1.html
                    }

                    StringBuilder pat = new StringBuilder();
                    pat.append("files");                                              //  files
                    pat.append(document);                                             //  files/Text1.html
                    String path = pat.toString();

                    File file = new File(path);
                    if (file.exists()) {

                        FileInputStream freader = new FileInputStream(file);
                        out.println("HTTP/1.1 200 OK");
                        out.println("");

                        int count = 0;
                        byte[] buffer = new byte[9999];
                        while ((count = freader.read(buffer)) > 0) {
                            out.write(buffer, 0, count);
                        }
                        out.println("");
                        socket.close();
                    } else {
                        File notfound = new File("files/404.gif");
                        FileInputStream freader = new FileInputStream(notfound);
                        out.println("HTTP/1.1 404 NOT FOUND");
                        out.println("");

                        int count = 0;
                        byte[] buffer = new byte[9999];
                        while ((count = freader.read(buffer)) > 0) {
                            out.write(buffer, 0, count);
                        }
                        out.println("");
                        socket.close();
                    }
                } else {
                    out.println("HTTP/1.1 400 BAD REQUEST");
                    out.println("");
                    out.println("400 Bad Request!");
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


