package polygontest.helper;

import polygontest.pieces.*;
import polygontest.player.Player;

public class PieceGenerator {

    private static final String WPawn = "polygontest/resources/pieces/WPawn.png";
    private static final String WRook = "polygontest/resources/pieces/WRook.png";
    private static final String WKnight = "polygontest/resources/pieces/WKnight.png";
    private static final String WBishop = "polygontest/resources/pieces/WBishop.png";
    private static final String WQueen = "polygontest/resources/pieces/WQueen.png";
    private static final String WKing = "polygontest/resources/pieces/WKing.png";

    private static final String BPawn = "polygontest/resources/pieces/BPawn.png";
    private static final String BRook = "polygontest/resources/pieces/BRook.png";
    private static final String BKnight = "polygontest/resources/pieces/BKnight.png";
    private static final String BBishop = "polygontest/resources/pieces/BBishop.png";
    private static final String BQueen = "polygontest/resources/pieces/BQueen.png";
    private static final String BKing = "polygontest/resources/pieces/BKing.png";


    public static Piece getPiece(Player p, Coord c){
        int row = c.getY();
        int col = c.getX();

        boolean b = (row == 0);

        if(row == 7 || row == 0){
            if(col == 0 || col == 7){
                return new Rook(b ? BRook : WRook, c, p);
            }else if(col == 1 || col == 6){
                return new Knight(b ? BKnight : WKnight, c, p);
            }else if(col == 2 || col == 5){
                return new Bishop(b ? BBishop : WBishop, c, p);
            }else if(col == 4){
                return new King(b ? BKing : WKing, c, p);
            }else{
                return new Queen(b ? BQueen : WQueen, c, p);
            }
        }else{
            return new Pawn((row == 1) ? BPawn : WPawn, c, p);
        }

    }



}
