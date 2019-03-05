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
    private byte[]turns;
    private static byte[][]victory = new byte[][]{
            {-1, 0, 1},
            {1, -1, 0},
            {0, 1, -1}
    };
    public GameServer(){
        clients = new CopyOnWriteArrayList<ClientHandler>();
        turns = new byte[2];
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

    private class ClientHandler extends Thread {
        private Socket clientSocket;
        private BufferedReader in;


        ClientHandler(Socket socket) {
            try {
                this.clientSocket = socket;
                if (clients.size() == 2) {
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    out.println("only two players allowed");
                    clientSocket.close();
                    out.close();
                } else {
                    clients.add(this);
                    System.out.println("New player " + socket.getPort());
                    tellOne(this, "you are the player " + clients.indexOf(this));
                    if (clients.size() == 2) {
                        preGame();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    if (".".equals(inputLine)) {
                        tellAll(this.clientSocket.getPort() + "quit");
                        break;
                    } else {
                        if (clients.size() == 2) {
                            int idx = clients.indexOf(this);
                            turns[idx] = Byte.parseByte(inputLine);
                            if (turns[0] != 0 && turns[1] != 0) {
                                int win = getWinner();
                                if (win != -1) {
                                    tellAll(win + " wins!");
                                } else {
                                    tellAll("Draw");
                                }
                                turns = new byte[2];
                                preGame();
                            }
                        } else {
                            tellOne(this, "wait for second player");
                        }
                    }
                }
                in.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void tellOne(ClientHandler handler, String message) throws IOException{
        PrintWriter out = new PrintWriter(handler.clientSocket.getOutputStream(), true);
        out.println(message);
    }

    private void tellAll(String message) throws IOException{
            for (ClientHandler clientHandler: clients){
                    tellOne(clientHandler, message);
            }
    }

    private void preGame() throws IOException{
            tellAll("Hello! 1 is for rock, 2 is for paper and 3 is for scissors");
        }

        private int getWinner(){
            return victory[turns[0]-1][turns[1]-1];
        }
}
