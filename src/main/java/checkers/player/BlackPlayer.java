package checkers.player;

import checkers.Board;
import checkers.piece.Piece;

public class BlackPlayer extends Player {

    public BlackPlayer(Board board) {
        super(board);
    }

    public void debugPrintBlack() {
        System.out.println("pieces black: " + pieces.toString());
    }

    @Override
    Piece getLeft(Piece piece) {
        return piece.getNW(board);
    }

    @Override
    Piece getRight(Piece piece) {
        return piece.getNE(board);
    }

    // TEST

}
