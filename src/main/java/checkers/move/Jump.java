package checkers.move;

import checkers.Board;
import checkers.piece.EmptyPiece;
import checkers.piece.Piece;

import java.util.ArrayList;

public class Jump extends MoveBase {
    ArrayList<EmptyPiece> additionalTo;
    ArrayList<Piece> jumpedPieces = new ArrayList<>();

    public Jump(Piece from, EmptyPiece to) {
        super(from, to);
    }

    @Override
    public String toString() {
        return "From: " + from.toString() + " ToEmpty: " + to.toString();
    }

    public void addJumpedPiece(Piece p) {
        jumpedPieces.add(p);
    }

    public ArrayList<Piece> getJumpedPieces() {
        return jumpedPieces;
    }

    public void doJump(Board board) {
        EmptyPiece fromTmp = new EmptyPiece(from.getCoord());
        from.switchPlacesWith(to);
        to.switchPlacesWith(fromTmp);
        board.updateBoard(from);
        board.updateBoard(to);

        removeJumpedPieces(board);
    }

    private void removeJumpedPieces(Board board) {
        for (Piece p:jumpedPieces) {
            EmptyPiece e = new EmptyPiece(p.getCoord());
            board.updateBoard(e);
        }
    }


}
