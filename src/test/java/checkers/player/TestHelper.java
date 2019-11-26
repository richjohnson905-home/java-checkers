package checkers.player;

import checkers.Board;
import checkers.piece.*;

/*
  01  02  03  04
05  06  07  08
  09  10  11  12
13  14  15  16
  17  18  19  20
21  22  23  24
  25  26  27  28
29  30  31  32
 */

public class TestHelper {

    Board board;
    EmptyPlayer empty;
    RedPlayer red;
    BlackPlayer black;

    public TestHelper(Board board, RedPlayer red, BlackPlayer black, EmptyPlayer empty) {
        this.board = board;
        this.red = red;
        this.black = black;
        this.empty = empty;
    }

    void initNewGameBoard() {
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
