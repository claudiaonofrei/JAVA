import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    public static void main(String[] args){
        Board board = new Board();
        List<Token> tokenList = new ArrayList<>();

        int numberOfTokensOnBoard = 20;
        for(int i=0; i<numberOfTokensOnBoard; i++) {
            Token token = new Token();
            Random random = new Random();
            int integer = random.nextInt(1000);
            token.setValue(integer);
            tokenList.add(token);
        }

        board.setTokenArrayList(tokenList);

        Player player1 = new Player();
        player1.setName("Ioana");
        player1.setBoard(board);
        new Thread(player1).start();

        Player player2 = new Player();
        player2.setName("Claudia");
        player2.setBoard(board);
        new Thread(player2).start();

        System.out.println(board.getTokenArrayList().size());
    }

}