package polygontest.gui;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import polygontest.helper.Coord;
import polygontest.helper.PieceGenerator;
import polygontest.pieces.King;
import polygontest.pieces.Piece;
import polygontest.player.Player;

public class ChessGrid extends GridPane{


    Statusbar statusbar;

    private Piece selectedPiece = null;
    private Tile selectedTile = null;

    private Player PlayerLight;
    private Player PlayerDark;

    private int playerOnTurn = 0;
    private Player[] players;

    public ChessGrid(Statusbar statusbar) {
        this.statusbar = statusbar;
        initPlayers();
        initField();
        initListener();
    }

    private void initPlayers() {
        PlayerLight = new Player(0);
        PlayerDark = new Player(1);
        players = new Player[]{PlayerLight, PlayerDark};
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
                    movePiece(clicked);
                }
            }
        });
    }

    private void setSelectionsNull(){
        selectedPiece = null;
        selectedTile = null;
    }

    private void handleMoveError(){
        selectedTile.changeState();
        setSelectionsNull();
        showInvalidMoveError();
    }

    private void movePiece(Tile clicked) {
        if(clicked.isHasPiece()){
            Piece clickedPiece = clicked.getPiece();
            if(currentPlayer().isOwner(clickedPiece)){
                if(clickedPiece.equals(selectedPiece)){
                    selectedTile.changeState();
                    setSelectionsNull();
                }else{
                    handleMoveError();
                }
                return;
            } else {
                if(clickedPiece instanceof King){
                    handleMoveError();
                    return;
                }
                otherPlayer().removePiece(clickedPiece);
                currentPlayer().setScore(currentPlayer().getScore() + clickedPiece.getValue());
            }
        }
        selectedTile.removePiece();
        clicked.setPiece(selectedPiece);
        selectedTile.changeState();
        setSelectionsNull();
        playerOnTurn = (playerOnTurn + 1) % 2;
        statusbar.updateScores(PlayerLight.getScore(), PlayerDark.getScore());
        statusbar.switchActive(playerOnTurn);

    }

    private void selectPiece(Tile clicked) {

        if(clicked.isHasPiece()){
            Piece p = clicked.getPiece();
            if(currentPlayer().isOwner(p)){
                selectedTile = clicked;
                selectedTile.changeState();
                selectedPiece = clicked.getPiece();
            } else {
                showInvalidSelectionError();
            }
        }else{
            System.err.println("No piece on " + clicked.getPosition().toString());
        }



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

    private Player currentPlayer(){
        return players[playerOnTurn];
    }
    private Player otherPlayer(){
        return players[(playerOnTurn+1)%2];
    }

    private void showInvalidSelectionError() {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Érvénytelen kijelölés");
        alert.show();
    }

    private void showInvalidMoveError() {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Szabálytalan lépés");
        alert.show();
    }

    private void showReservedTileError() {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Foglalt mező");
        alert.show();
    }


}
