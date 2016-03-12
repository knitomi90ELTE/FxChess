package polygontest.gui;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import polygontest.helper.Coord;
import polygontest.pieces.Piece;

public class Tile extends StackPane {

    private boolean selected = false;
    private boolean hasPiece = false;
    private Coord position;
    private Piece piece;
    private ImageView imageView;
    private Rectangle rect;

    public Tile( Coord position) {
        this.position = position;
        initRect();
        initImageView();

    }

    private void initRect(){
        rect = new Rectangle();
        rect.setFill(Paint.valueOf((position.getX()+position.getY()) %2 == 0 ? "white" : "grey"));
        rect.getStyleClass().add("my-tile");
        rect.getStyleClass().add("passive-tile");
        rect.setHeight(99.0);
        rect.setWidth(99.0);
        rect.setMouseTransparent(true);
        this.getChildren().add(rect);
    }

    private void initImageView(){
        imageView = new ImageView();
        imageView.setFitHeight(75.0);
        imageView.setFitWidth(75.0);
        imageView.setPreserveRatio(true);
        imageView.setMouseTransparent(true);
        this.getChildren().add(imageView);
    }


    public void changeState(){
        if(selected){
            rect.getStyleClass().removeAll("active-tile");
            rect.getStyleClass().add("passive-tile");
            selected = false;
        }else{
            rect.getStyleClass().removeAll("passive-tile");
            rect.getStyleClass().add("active-tile");
            selected = true;
        }
    }

    public Coord getPosition() {
        return position;
    }

    public void setPosition(Coord position) {
        this.position = position;
    }

    public Piece getPiece() {
        return piece;
    }

    public void removePiece() {
        this.hasPiece = false;
        this.piece = null;
        this.imageView.setImage(null);
    }

    public void setPiece(Piece piece) {
        this.hasPiece = true;
        this.piece = piece;
        imageView.setImage(piece);
    }

    public void selectTile(){

    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isHasPiece() {
        return hasPiece;
    }

    public void setHasPiece(boolean hasPiece) {
        this.hasPiece = hasPiece;
    }
}
