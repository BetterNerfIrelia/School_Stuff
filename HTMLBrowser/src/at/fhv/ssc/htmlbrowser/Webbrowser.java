package at.fhv.ssc.htmlbrowser;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Webbrowser {

    private Client _client;
    private String _hostText;               //    Host: www.apache.org
    private String _documentText;           //    GET /foundation/ HTTP/1.1
    private String _host;                   //    www.apache.org
    private String _document;               //    foundation
    private String _url;                    //    www.apache.org/foundation/

    private class Client {

        private Webbrowser _browser;
        private boolean _headerOver;
        private String _ip;


        public Client(String host, Webbrowser browser) {

            _browser = browser;

            try (Socket socket = new Socket(host, 80);) {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                _ip = (InetAddress.getByName(_browser.getHost()).getHostAddress());
                System.out.println("Connecting to Server " + _browser.getHost() + " at " + _ip);

                out.println(_browser.getDocumentText());
                out.println(_browser.getHostText());
                out.println("");

                Scanner stdIn = new Scanner(socket.getInputStream());
                String input = null;

                while ((input = stdIn.nextLine()) != null) {
                    if (input.isEmpty()) {
                        _headerOver = true;
                    }
                    if (_headerOver) {
                        System.out.println(input);
                    }
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public Webbrowser getBrowser() {
            return _browser;
        }

        public void setBrowser(Webbrowser browser) {
            _browser = browser;
        }

        public String getIp() {
            return _ip;
        }

        public void setIp(String ip) {
            _ip = ip;
        }
    }

    public Webbrowser(String url) {

        _url = url;
        urlIntoHost(url);
        _client = new Client(_host, this);
    }

    private void urlIntoHost(String url) {

        StringBuilder host = new StringBuilder();
        StringBuilder document = new StringBuilder();

        if (url.indexOf("/") == -1) {

            _host = url;
            _document = "";

            document.append("GET / HTTP/1.1");
            _documentText = document.toString();

        } else {

            _host = url.substring(0, url.indexOf(("/")));
            _document = url.substring(url.indexOf("/"));


            document.append("GET /" + _document + " HTTP/1.1");
            _documentText = document.toString();
        }

        host.append("Host: " + _host);
        _hostText = host.toString();
    }

    public Client getClient() {
        return _client;
    }

    public void setClient(Client client) {
        _client = client;
    }

    public String getHost() {
        return _host;
    }

    public void setHost(String host) {
        _host = host;
    }

    public String getDocument() {
        return _document;
    }

    public void setDocument(String document) {
        _document = document;
    }

    public String getHostText() {
        return _hostText;
    }

    public void setHostText(String hostText) {
        _hostText = hostText;
    }

    public String getDocumentText() {
        return _documentText;
    }

    public void setDocumentText(String documentText) {
        _documentText = documentText;
    }

    public String getUrl() {
        return _url;
    }

    public void setUrl(String url) {
        _url = url;
    }
}

