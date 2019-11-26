package checkers.move;

import checkers.piece.EmptyPiece;
import checkers.piece.Piece;

import java.util.ArrayList;

public class Jump extends MoveBase {
    public ArrayList<EmptyPiece> additionalTo;
    public ArrayList<Piece> jumpedPieces;

    public Jump(Piece from, EmptyPiece to) {
        super(from, to);
    }

    @Override
    public String toString() {
        return "From: " + from.toString() + " ToEmpty: " + to.toString();
    }
}
