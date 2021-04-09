package server;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.Handeler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    private ServerSocket serverSocket = null;
    private int port;
    public TextArea txtOut;

    public Server(int port, TextArea txtOut) throws IOException {
        serverSocket = new ServerSocket(port);
        this.port = port;
        this.txtOut = txtOut;
        port = 8080;


    }

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        this.port = port;
        this.txtOut = txtOut;
    }

    public void handleRequests() throws IOException{
        System.out.println("Listening to port: "+port);

        // creating a thread to handle each of the clients
        while(true){
            Socket clientSocket = serverSocket.accept();
            Handeler handler = new Handeler(clientSocket,txtOut);
            Thread handlerThread = new Thread(handler);
            handlerThread.start();
        }

    }



    public static void main(String[] args) {
        int port = 8080;
        // port to listen default 8080, or the port from the argument
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        try {
            //Instantiating the HttpServer Class
            Server server = new Server(port);
            // handle any requests from the port
            server.handleRequests();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

