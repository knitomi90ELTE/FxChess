package polygontest.pieces;

import polygontest.helper.Coord;
import polygontest.player.Player;

public class Rook extends Piece {

    public Rook(String url, Coord c, Player player) {
        super(url);
        this.value = 5;
        this.position = c;
        this.owner = player;
    }

    @Override
    public boolean canMoveThere(Coord c) {
        return false;
    }
}
