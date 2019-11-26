package checkers.move;

import checkers.Board;
import checkers.piece.EmptyPiece;
import checkers.piece.Piece;

public class Move extends MoveBase {

    public Move(Piece from, EmptyPiece to) {
        super(from, to);
    }

    @Override
    public String toString() {
        return "From: " + from.getCoord().getI() + "," + from.getCoord().getJ() + " ToEmpty: " + to.getCoord().getI() + "," + to.getCoord().getJ();
    }

    public void doMove(Board board) {
        EmptyPiece fromTmp = new EmptyPiece(from.getCoord());
        from.switchPlacesWith(to);
        to.switchPlacesWith(fromTmp);
        board.updateBoard(from);
        board.updateBoard(to);
    }
}
