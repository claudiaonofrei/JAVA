import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientThread extends Thread {
    private Socket socket = null;
    private final GameServer server;

    final static List<Board> boardList = new ArrayList<Board>();
    Board clientGame = null;
    Integer playerId = null;

    public ClientThread(Socket socket, GameServer server) {
        this.socket = socket;
        this.server = server;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //client -> server stream
            PrintWriter out = new PrintWriter(socket.getOutputStream()); //server -> client stream


            while(true) {
                String request = in.readLine();
                System.out.println(clientGame);
                String response = execute(request);
                System.out.println(response);
                out.println(response);
                out.flush();
            }
        }
        catch (IOException e) {
            System.err.println("Communication error...  " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) { System.err.println (e); }
        }
    }
    private String execute(String request) throws IOException {
        System.out.println("Server received the request " + request );

        if (request.equals("create game")) {
            Board board = new Board();
            boardList.add(board);
            int boardIndex = boardList.indexOf(board);
            return Integer.toString(boardIndex);

        } else if (request.startsWith("join game")) {
            Integer boardIndex = Integer.parseInt(request.split(" ")[2]);

            if(boardIndex < boardList.size()) {
                if (clientGame == null) {
                    Board auxBoard = boardList.get(boardIndex);
                    if(auxBoard.getNumberOfPlayers() < 2) {
                        auxBoard.setNumberOfPlayers(auxBoard.getNumberOfPlayers() + 1);

                        clientGame = boardList.get(boardIndex);

                        playerId = auxBoard.getNumberOfPlayers();

                        return "U have joined game number " + boardIndex.toString();
                    } else {
                        return "Incearca alt joc. In acest joc au intrat deja 2 persoane.";
                    }
                } else {
                    return "Esti deja intr-un joc.";
                }
            } else {
                return "Acest joc nu exista.";
            }


        } else if(request.startsWith("make move")) {
            Integer row = Integer.parseInt(request.split(" ")[2]);
            Integer column = Integer.parseInt(request.split(" ")[3]);


            if (clientGame != null) {
                if(clientGame.getNumberOfPlayers() == 2) {
                    if (!clientGame.isFinished()) {
                        System.out.println(playerId + " " + clientGame.getPlayerTurn() );

                        if(clientGame.getPlayerTurn() == null || clientGame.getPlayerTurn() + 1 == playerId) {
                            clientGame.makeMove(row, column, Double.valueOf(playerId));
                            String boardString = clientGame.printBoard();
                            return boardString.replace("\n", "*");
                        } else {
                            return "Nu este randul tau.";
                        }
                    } else {
                        clientGame = null;
                        playerId = null;
                        return "Game is already finished :(";
                    }
                }
                else {
                    return "There are not yet 2 players.";
                }
            } else {
                return "You haven't joined any game. Do you want to? :>";
            }
        }
        return "Done";
    }
}
