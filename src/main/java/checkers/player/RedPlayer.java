package checkers.player;

import checkers.Board;
import checkers.piece.Piece;

public class RedPlayer extends Player {

    public RedPlayer(Board board) {
        super(board);
    }

    public void debugPrintRed() {
        System.out.println("red player pieces red: " + pieces.toString());
    }

    @Override
    Piece getLeft(Piece piece) {
        return piece.getSE(board);
    }

    @Override
    Piece getRight(Piece piece) {
        return piece.getSW(board);
    }

    // TEST

}
