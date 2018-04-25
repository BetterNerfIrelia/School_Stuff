package at.fhv.ssc.htmlbrowser;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter URL: ");
        String url = in.next();
        Webbrowser browser = new Webbrowser(url);         //        Webbrowser browser = new Webbrowser("www.apache.org/foundation/");
        in.close();
    }
}
