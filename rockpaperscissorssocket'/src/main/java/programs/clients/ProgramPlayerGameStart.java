package programs.clients;

import clients.socketClient;

import java.util.Scanner;

public class ProgramPlayerGameStart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        socketClient client = new socketClient();
        client.startConnection("127.0.0.1", 6666);
        while (true){
            String message = scanner.nextLine();
            client.sendMessage(message);
        }
    }
}
