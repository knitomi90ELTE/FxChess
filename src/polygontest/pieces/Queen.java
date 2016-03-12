package polygontest.pieces;

import polygontest.helper.Coord;
import polygontest.player.Player;

public class Queen extends Piece {

    public Queen(String url, Coord c, Player player) {
        super(url);
        this.value = 10;
        this.position = c;
        this.owner = player;
    }

    @Override
    public boolean canMoveThere(Coord c) {
        return false;
    }
}
