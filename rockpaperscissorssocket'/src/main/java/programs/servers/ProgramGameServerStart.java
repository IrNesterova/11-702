package programs.servers;

import servers.GameServer;

public class ProgramGameServerStart {
    public static void main(String[] args) {
        GameServer server = new GameServer();
        server.start(6666);
    }
}
