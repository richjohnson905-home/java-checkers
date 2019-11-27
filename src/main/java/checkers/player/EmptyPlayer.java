package checkers.player;

import checkers.Board;
import checkers.piece.EmptyPiece;
import checkers.piece.Piece;

import java.util.ArrayList;

public class EmptyPlayer {
    ArrayList<EmptyPiece> pieces = new ArrayList<>(8);
    Board board;

    public EmptyPlayer(Board board) {
        this.board = board;
    }

    public void initPiece(Piece piece) {
        pieces.add((EmptyPiece)piece);
        board.updateBoard(piece);
    }

    public void debugPrintEmpty() {
        System.out.println("pieces empty: " + pieces.toString());
    }

    // Test

}
