package polygontest.pieces;

import javafx.scene.image.Image;
import polygontest.helper.Coord;
import polygontest.player.Player;

public abstract class Piece extends Image{

    protected int value;
    protected Coord position;
    protected boolean hasMoved = false;
    protected Player owner;

    public Piece(String url){
        super(url);
    }

    public abstract boolean canMoveThere(Coord c);

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Coord getPosition() {
        return position;
    }

    public void setPosition(Coord position) {
        this.position = position;
    }


}
