package polygontest.pieces;

import polygontest.helper.Coord;
import polygontest.player.Player;

public class Pawn extends Piece {

    public Pawn(String url, Coord c, Player player) {
        super(url);
        this.value = 1;
        this.position = c;
        this.owner = player;
    }

    @Override
    public boolean canMoveThere(Coord c) {
        return true;
    }
}
