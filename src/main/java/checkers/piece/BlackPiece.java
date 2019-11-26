package checkers.piece;

import checkers.move.Jump;
import checkers.move.Move;

public class BlackPiece extends Piece {
    public BlackPiece(Coord c) {
        super(c, "BLACK");
        displayString = "BLACK";
    }

    @Override
    public Boolean isSelected() {
        return displayString == "BL*CK";
    }

    @Override
    public void setSelected() {
        displayString = "BL*CK";
    }

    @Override
    public void setUnselected() {
        displayString = "BLACK";
    }

    @Override
    public void addMove(Move m, int number) {
        displayString = "BLA " + number;
        moveNumber = number;
        moves.add(m);
    }

    @Override
    public void addJump(Jump j, int number) {
        displayString = "BLA " + number;
        moveNumber = number;
        jumps.add(j);
    }
}
