package polygontest.gui;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import polygontest.helper.Coord;
import polygontest.helper.PieceGenerator;
import polygontest.pieces.Piece;
import polygontest.player.Player;

/**
 * Created by knizner on 2016.03.12..
 */
public class ChessGrid extends GridPane{


    private Piece selectedPiece = null;
    private Tile selectedTile = null;

    private Player PlayerLight;
    private Player PlayerDark;

    private int playerOnTurn = 0;



    public ChessGrid() {
        initPlayers();
        initField();
        initListener();
    }

    private void initPlayers() {
        PlayerLight = new Player(0);
        PlayerDark = new Player(1);
    }

    private void initField(){
        final int size = 8 ;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col ++) {
                Coord c = new Coord(col, row);
                Tile tile = new Tile(c);
                if(row == 0 || row == 1){
                    Piece p = PieceGenerator.getPiece(c);
                    tile.setPiece(p);
                    PlayerDark.addPiece(p);
                }

                if(row == 6 || row == 7){
                    Piece p = PieceGenerator.getPiece(c);
                    tile.setPiece(p);
                    PlayerLight.addPiece(p);
                }

                this.add(tile, col, row);
            }
        }
    }




    private void initListener(){
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                Tile clicked = getClicked(e);
                if(clicked == null){ //jó helyre kattintott
                    return;
                }



                if(selectedPiece == null){ //nincs kiválasztva bábú
                    selectPiece(clicked);
                } else { //van kiválasztva bábú

                    if(!clicked.isHasPiece()){ //olyan helyre akarja rakni, ahol nincs bábú
                        movePiece(clicked);
                    }else{ //rossz helyre akarja rakni
                        showAlertMessage();
                    }
                    selectedTile.changeState();
                    selectedPiece = null;
                    selectedTile = null;

                }
            }
        });
    }

    private void showAlertMessage() {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Foglalt mező", ButtonType.CLOSE);
        alert.show();
    }

    private void movePiece(Tile clicked) {
        selectedTile.removePiece();
        clicked.setPiece(selectedPiece);
    }

    private void selectPiece(Tile clicked) {
        selectedTile = clicked;
        selectedTile.changeState();
        selectedPiece = selectedTile.getPiece();
    }

    private Tile getClicked(MouseEvent e){
        for( Node node: getChildren()) {
            if( node instanceof Tile) {
                if( node.getBoundsInParent().contains(e.getSceneX(),  e.getSceneY())) {
                    return (Tile) node;
                }
            }
        }
        return null;
    }

    private void debug(String message){
        System.out.println(message);
    }


}
