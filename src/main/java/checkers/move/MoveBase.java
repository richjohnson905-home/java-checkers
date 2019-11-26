package checkers.move;

import checkers.piece.EmptyPiece;
import checkers.piece.Piece;

public abstract class MoveBase {
    int moveNumber;
    Piece from;
    EmptyPiece to;

    MoveBase(Piece from, EmptyPiece to) {
        this.from = from;
        this.to = to;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public Piece getFrom() {
        return from;
    }

    public EmptyPiece getEmptyTo() {
        return to;
    }
}
