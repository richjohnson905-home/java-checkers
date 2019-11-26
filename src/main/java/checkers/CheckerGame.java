package checkers;

import checkers.piece.*;
import checkers.player.BlackPlayer;
import checkers.player.EmptyPlayer;
import checkers.player.RedPlayer;
import checkers.state.FindMovesState;

public class CheckerGame {
    public Board board = new Board();
    public RedPlayer red = new RedPlayer(board);
    public BlackPlayer black = new BlackPlayer(board);
    public EmptyPlayer empty = new EmptyPlayer(board);

    public CheckerGame() {
        red.setNextPlayer(black);
        black.setNextPlayer(red);
        red.changeState(new FindMovesState(red));
        initBoard();
    }

    public void debugPrint() {
        red.debugPrint();
        black.debugPrint();
        red.debugPrintRed();
        black.debugPrintBlack();
        empty.debugPrintEmpty();
    }

    private void initBoard() {
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 8; j++) {
//                board.board[i][j] = (i + j) % 2 == 0 ? addRed(new RedPiece(new Coord(i, j))) : new NullPiece(new Coord(i, j));
//            }
//        }
//        for (int i = 3; i < 5; i++) {
//            for (int j = 0; j < 8; j++) {
//                board.board[i][j] = (i + j) % 2 == 0 ? addEmpty(new EmptyPiece(new Coord(i, j))) : new NullPiece(new Coord(i, j));
//            }
//        }
//        for (int i = 5; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                board.board[i][j] = (i + j) % 2 == 0 ? addBlack(new BlackPiece(new Coord(i, j))) : new NullPiece(new Coord(i, j));
//            }
//        }
        for (int i = 1; i < 13; i++) {
            addRed(new RedPiece(board.getCoord(i)));
        }
        for (int i = 13; i < 21; i++) {
            addEmpty(new EmptyPiece(board.getCoord(i)));
        }
        for (int i = 21; i < 33; i++) {
            addBlack(new BlackPiece(board.getCoord(i)));
        }
    }

    private RedPiece addRed(RedPiece redPiece) {
        red.initPiece(redPiece);
        return redPiece;
    }
    private EmptyPiece addEmpty(EmptyPiece emptyPiece) {
        empty.initPiece(emptyPiece);
        return emptyPiece;
    }
    private BlackPiece addBlack(BlackPiece blackPiece) {
        black.initPiece(blackPiece);
        return blackPiece;
    }
}
