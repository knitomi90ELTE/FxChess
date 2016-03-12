package polygontest.player;

import polygontest.pieces.Piece;
import java.util.LinkedList;
import java.util.List;

public class Player {

    private List<Piece> pieces = new LinkedList<>();
    private int id;
    private int score = 0;

    public Player(int id) {
        this.id = id;
    }

    public boolean isOwner(Piece p){
        return pieces.contains(p);
    }

    public void addPiece(Piece p){
        pieces.add(p);
    }

    public void removePiece(Piece p){
        if(isOwner(p)){
            pieces.remove(p);
        }
    }

    public int getId() {
        return id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
