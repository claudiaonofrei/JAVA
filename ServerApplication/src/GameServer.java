import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    private static final int PORT = 8100;
    private ServerSocket serverSocket;
    private boolean running = true;

    private void init() {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        running = true;
    }

    private void waitForClients() {
        while (running) {
            System.out.println(" Waiting client... ");
            try {
                Socket clientSocket = serverSocket.accept();
                new ClientThread(clientSocket, this).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        GameServer server = new GameServer();
        server.init();
        server.waitForClients();
    }
}