public class Player implements Runnable {
    private String name;
    private int points;
    private Board board;

    public void setName(String name) {
        this.name=name;
    }
    public void setBoard(Board board){
        this.board=board;
    }

    @Override
    public synchronized void run() {
        Token token = this.board.removeToken();
        while(token != null) {
            System.out.println(name + " " + token.toString() + "    " + token.getValue());
            token = this.board.removeToken();
        }
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }
}