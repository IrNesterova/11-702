package servers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameServer {
    private List<ClientHandler> clients;
    public GameServer(){
        clients = new CopyOnWriteArrayList<ClientHandler>();
    }

    public void start(int port){
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);

        } catch (IOException e){
            throw new IllegalStateException(e);
        }

        while (true){
            try {
                new ClientHandler(serverSocket.accept()).start();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private class ClientHandler extends Thread{
        private Socket clientSocket;
        private BufferedReader in;
        private BufferedReader in_1;
        private BufferedReader in_2;

        ClientHandler(Socket socket){
            this.clientSocket = socket;
            clients.add(this);
            System.out.println("New player " + socket.getPort());

        }


        public void run(){
            try{
                if (clients.size()>=2) {
                    System.out.println("Hello! This is RPS game, type R for rock, P for paper, S for scissors.");

                    //in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    in_1 = new BufferedReader(new InputStreamReader(clients.get(0).clientSocket.getInputStream()));
                    in_2 = new BufferedReader(new InputStreamReader(clients.get(1).clientSocket.getInputStream()));

                    String inputLine;
                    String inputLine_1;
                    String inputLine_2;
                    while ((inputLine_1 = in_1.readLine()) != null && (inputLine_2 = in_2.readLine()) != null) {
                        if (".".equals(inputLine_1) && ".".equals(inputLine_2)) {
                            for (ClientHandler client : clients) {
                                PrintWriter out = new PrintWriter(client.clientSocket.getOutputStream(), true);
                                out.println("bye");
                            }
                            break;
                        }  else if (("R".equals(inputLine_1) && "S".equals(inputLine_2)) || ("S".equals(inputLine_1) && "P".equals(inputLine_2))
                                || ("P".equals(inputLine_1) && "R".equals(inputLine_2))) {
                            for (ClientHandler client : clients) {
                                PrintWriter out = new PrintWriter(client.clientSocket.getOutputStream(), true);
                                out.print("Player" + clients.get(0).clientSocket.getPort() + "won");
                            }
                        } else {
                            for (ClientHandler clientHandler : clients) {
                                PrintWriter out = new PrintWriter(clientHandler.clientSocket.getOutputStream(), true);
                                out.print("Player" + clients.get(1).clientSocket.getPort() + "won");
                            }
                        }
                    }
                    in_1.close();
                    in_2.close();
                    clientSocket.close();
                }

            } catch (Exception e){
                throw new IllegalStateException(e);
            }
        }
    }
}