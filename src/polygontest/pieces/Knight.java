package polygontest.pieces;

import polygontest.helper.Coord;
import polygontest.player.Player;

public class Knight extends Piece {

    public Knight(String url, Coord c, Player player) {
        super(url);
        this.value = 3;
        this.position = c;
        this.owner = player;
    }

    @Override
    public boolean canMoveThere(Coord c) {
        return  ((c.getX() == position.getX() + 1) && (c.getY() == position.getY() + 2)) ||
                ((c.getX() == position.getX() + 1) && (c.getY() == position.getY() - 2)) ||
                ((c.getX() == position.getX() - 1) && (c.getY() == position.getY() + 2)) ||
                ((c.getX() == position.getX() - 1) && (c.getY() == position.getY() - 2)) ||
                ((c.getX() == position.getX() + 2) && (c.getY() == position.getY() + 1)) ||
                ((c.getX() == position.getX() + 2) && (c.getY() == position.getY() - 1)) ||
                ((c.getX() == position.getX() - 2) && (c.getY() == position.getY() + 1)) ||
                ((c.getX() == position.getX() - 2) && (c.getY() == position.getY() - 1));
    }
}
