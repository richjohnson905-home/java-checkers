package checkers.player;

import checkers.Board;
import checkers.move.Jump;
import checkers.move.Move;
import checkers.piece.EmptyPiece;
import checkers.piece.Piece;
import checkers.state.GameState;

import java.util.ArrayList;

public abstract class Player {
    // attributes
    ArrayList<Piece> pieces = new ArrayList<>(12);
    Move theMove;
    Jump theJump;
    Player nextPlayer;
    GameState state;
    int moveNumber;
    Board board;

    // abstract
    abstract Piece getLeft(Piece piece);
    abstract Piece getRight(Piece piece);

    public Player(Board board) {
        this.board = board;
    }

    public void debugPrint() {
        if (theMove != null) {
            System.out.println("theMove: " + theMove.toString());
        }
        if (state != null) {
            System.out.println("state: " + state.toString());
        }
        System.out.println("moveNumber: " + moveNumber);
        System.out.println("base player: " + this.toString());
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

    public void initPiece(Piece piece) {
        pieces.add(piece);
        board.updateBoard(piece);
    }

    public GameState getState() {
        return state;
    }

    public GameState changeState(GameState state) {
        this.state = state;
        return state;
    }

    public Move getTheMove() {
        return theMove;
    }

    public Jump getTheJump() {
        return theJump;
    }

    public void setNextPlayer(Player nextPlayer) {
        moveNumber = -1;
        this.nextPlayer = nextPlayer;
        for (Piece p:pieces)
            p.clear();
    }

    public Boolean findJumps() {
        int ctr = 0;
        Boolean jump = false;
        for(Piece p:pieces) {
            Piece left = getLeft(p);
            Piece right = getRight(p);
            if (left.isEnemy(p)) {
                Piece leftOfEnemy = getLeft(left);
                if (leftOfEnemy.isEmpty()) {
                    Jump j = new Jump(p, (EmptyPiece)leftOfEnemy);
                    p.addJump(j, ctr);
                    j.addJumpedPiece(left);
                    jump = true;
                }
            }
            if (right.isEnemy(p)) {
                Piece rightOfEnemy = getRight(right);
                if (rightOfEnemy.isEmpty()) {
                    Jump j = new Jump(p, (EmptyPiece)rightOfEnemy);
                    p.addJump(j, ctr);
                    j.addJumpedPiece(right);
                    jump = true;
                }
            }
            if (jump) {
                ctr++;
            }
        }
        return jump;
    }

    public void findMoves() {
        int ctr = 0;
        for(Piece p:pieces) {
            Piece left = getLeft(p);
            Piece right = getRight(p);
            if (left.isEmpty()) {
                Move m = new Move(p, (EmptyPiece)left);
                p.addMove(m, ctr);
            }
            if (right.isEmpty()) {
                Move m = new Move(p, (EmptyPiece)right);
                p.addMove(m, ctr);
            }
            if (left.isEmpty() || right.isEmpty()) {
                ctr++;
            }
        }
    }

    public void setMoveFromNumber(int moveNumber) {
        for (Piece r:pieces) {
            if (r.getMoveNumber() == moveNumber) {
                r.setSelected();
                int ctr = 0;
                for (Move m:r.getMoves()) {
                    if (m.getFrom().getMoveNumber() == moveNumber) {
                        m.getEmptyTo().addMove(m, ctr++);
                    }
                }
            } else {
                r.setUnselected();
            }
        }
        this.moveNumber = moveNumber;
    }

    public void setJumpFromNumber(int moveNumber) {
        for (Piece r:pieces) {
            if (r.getMoveNumber() == moveNumber) {
                r.setSelected();
                int ctr = 0;
                for (Jump j:r.getJumps()) {
                    if (j.getFrom().getMoveNumber() == moveNumber) {
                        j.getEmptyTo().addJump(j, ctr++);
                    }
                }
            } else {
                r.setUnselected();
            }
        }
        this.moveNumber = moveNumber;
    }

    public void setMoveToNumber(int moveNumber) {
        for (Piece r:pieces) {
            if (r.isSelected()) {
                for (Move m : r.getMoves()) {
                    if (m.getEmptyTo().getMoveNumber() == moveNumber) {
                        m.getEmptyTo().setSelected();
                        theMove = m;
                    } else {
                        m.getEmptyTo().setUnselected();
                    }
                }
            }
        }
    }

    public void setJumpToNumber(int moveNumber) {
        for (Piece r:pieces) {
            if (r.isSelected()) {
                for (Jump j : r.getJumps()) {
                    if (j.getEmptyTo().getMoveNumber() == moveNumber) {
                        j.getEmptyTo().setSelected();
                        theJump = j;
                    } else {
                        j.getEmptyTo().setUnselected();
                    }
                }
            }
        }
    }

    public void clearMoves() {
        theMove = null;
        theJump = null;
        moveNumber = -1;
        for (Piece r:pieces) {
            r.clearMoves();
        }
    }
}
