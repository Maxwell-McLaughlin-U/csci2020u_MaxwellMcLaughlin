package sample;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.NoSuchElementException;
import java.util.Date;

public class Handeler implements Runnable{

    private Socket socket = null;
    private BufferedReader requestInput = null;
    private DataOutputStream responseOutput = null;
    private TextArea txtOut;

    public Handeler(Socket socket, TextArea txtOut) throws IOException{
        this.socket = socket;
        requestInput = new BufferedReader( new InputStreamReader(socket.getInputStream()));
        responseOutput = new DataOutputStream(socket.getOutputStream());
        this.txtOut = txtOut;
    }


    public void run(){
        //System.out.println("hello");
        try {
            String strInput = requestInput.readLine();


            this.txtOut.appendText(strInput);
            System.out.println(strInput);
            requestInput.close();
            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
