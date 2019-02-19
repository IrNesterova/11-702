package clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class socketClient {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port){
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            new Thread(recieverMessagesTask).start();
        } catch (Exception e){
            throw new IllegalStateException(e);
        }
    }
    public void sendMessage(String message){
        out.println(message);
    }

    private Runnable recieverMessagesTask = new Runnable() {
        public void run() {
            while (true) {
                try {
                    String response = in.readLine();
                    if (response != null){
                        System.out.println(response);
                    }
                } catch (IOException e){
                    throw new IllegalStateException(e);
                }
            }
        }
    };

    public void stopConnection(){
        try{
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e){
            throw new IllegalStateException(e);
        }
    }
}
