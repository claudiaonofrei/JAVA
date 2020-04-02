import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Token>tokenArrayList = new ArrayList<>();

    public List<Token> getTokenArrayList() {
        return tokenArrayList;
    }

    public void setTokenArrayList(List<Token> tokenArrayList) {
        this.tokenArrayList = tokenArrayList;
    }

    public void addToken(Token token) {
        this.tokenArrayList.add(token);
    }

    public Token removeToken() {
        if(tokenArrayList.size() > 0) {
            Token token = tokenArrayList.remove(tokenArrayList.size() - 1);
            return token;
        } else {
            return null;
        }
    }
}
