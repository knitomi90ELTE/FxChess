package polygontest.pieces;

import polygontest.helper.Coord;
import polygontest.player.Player;

public class Bishop extends Piece {

    public Bishop(String url, Coord c, Player player) {
        super(url);
        this.value = 3;
        this.position = c;
        this.owner = player;
    }

    @Override
    public boolean canMoveThere(Coord c) {
        return false;
    }
}
