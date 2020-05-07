import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Board {
    private Vector<Vector<Double>>  matrix= new Vector<Vector<Double>>(); //Vector is thread safe
    private boolean isFinished = false;
    private int numberOfPlayers = 0;
    private Integer playerTurn = null;
    private int columnsNo = 5;
    private int rowNo = 5;


    Board() {
        for(int i=0;i<rowNo;i++){
            Vector<Double> r=new Vector<>();
            for(int j=0;j<columnsNo;j++){
                r.add(0.0);
            }
            matrix.add(r);
        }
    }

    private boolean checkFinished() {
        int [][] auxMatrix = new int[rowNo][columnsNo];

        for(int j=0;j<columnsNo;j++){
            StringBuilder str = new StringBuilder();
            for(int i=0;i<rowNo;i++){
                str.append(auxMatrix[i][j]);
            }
            //check column
            System.out.println(str.toString());

            final String regex = "(1{3,3})|(2{3,3})";
            final String string = str.toString();

            final Pattern pattern = Pattern.compile(regex);
            final Matcher matcher = pattern.matcher(string);
            if(matcher.find())
                return true;
        }

        for(int i=0;i<rowNo;i++){
            StringBuilder str = new StringBuilder();
            for(int j=0;j<columnsNo;j++){
                str.append(auxMatrix[i][j]);
            }
            //check line
            System.out.println(str.toString());

            final String regex = "(1{3,3})|(2{3,3})";
            final String string = str.toString();

            final Pattern pattern = Pattern.compile(regex);
            final Matcher matcher = pattern.matcher(string);
            if(matcher.find())
                return true;
        }

        int dim = rowNo;
        for( int k = 0 ; k < dim * 2 ; k++ ) {
            StringBuilder str = new StringBuilder();
            for( int j = 0 ; j <= k ; j++ ) {
                int i = k - j;
                if( i < dim && j < dim ) {
                    str.append(auxMatrix[i][j]);
                }
            }
            System.out.println(str.toString());

            final String regex = "(1{3,3})|(2{3,3})";
            final String string = str.toString();

            final Pattern pattern = Pattern.compile(regex);
            final Matcher matcher = pattern.matcher(string);
            if(matcher.find())
                return true;
        }

        for (int n = -rowNo; n <= rowNo; n++) {
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < rowNo; i++){
                if((i-n>=0)&&(i-n<rowNo)){
                    str.append(auxMatrix[i][i-n]);
                }
            }
            System.out.println(str.toString());

            final String regex = "(1{3,3})|(2{3,3})";
            final String string = str.toString();

            final Pattern pattern = Pattern.compile(regex);
            final Matcher matcher = pattern.matcher(string);
            if(matcher.find())
                return true;
        }

        return false;
    }

    public void makeMove(Integer row, Integer column, Double value) {
        Vector<Double> oldRow = matrix.get(row);
        oldRow.set(column, value);
        matrix.set(row, oldRow);

        //check is finished
        isFinished = checkFinished();


        //add history

        if(playerTurn == null) {
            playerTurn = value.intValue() - 1;
        }
        playerTurn += 1;
        playerTurn %= 2;
    }

    public String printBoard() {
        StringBuilder str
                = new StringBuilder();


        for(int i=0;i<rowNo;i++){
            Vector<Double> r=this.matrix.get(i);
            for(int j=0;j<columnsNo;j++){
                System.out.print(r.get(j));
                str.append(r.get(j) + "  ");
            }
            System.out.println();
            str.append("\n");
        }

        return str.toString();
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public Vector<Vector<Double>> getMatrix() {
        return matrix;
    }

    public void setMatrix(Vector<Vector<Double>> matrix) {
        this.matrix = matrix;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public Integer getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(Integer playerTurn) {
        this.playerTurn = playerTurn;
    }
}
