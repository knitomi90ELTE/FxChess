package polygontest.pieces;

import polygontest.helper.Coord;
import polygontest.player.Player;

public class King extends Piece {

    public King(String url, Coord c, Player player) {
        super(url);
        this.value = 0;
        this.position = c;
        this.owner = player;
    }


    @Override
    public boolean canMoveThere(Coord c) {
        if((c.getX() == position.getX()+1 || c.getX() == position.getX()-1 || c.getX() == position.getX()) &&
           (c.getY() == position.getY()+1 || c.getY() == position.getY()-1 || c.getY() == position.getY())){
            return true;
        }
        return false;
    }
}
