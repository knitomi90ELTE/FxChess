package polygontest.pieces;

import javafx.scene.image.Image;
import polygontest.helper.Coord;

public class Piece extends Image{

    protected int value;
    protected Coord position;
    protected boolean hasMoved = false;

    public Piece(String url, int value, Coord position){
        super(url);
        this.value = value;
        this.position = position;
    }


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
