package checkers;

import checkers.piece.Coord;
import checkers.piece.NullPiece;
import checkers.piece.Piece;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Board {
    Piece[][] board = new Piece[8][8];
    HashMap<Integer, Coord> coordMap = new HashMap<>();

    public Board() {
        coordMap.put(1, new Coord(0, 1));
        coordMap.put(2, new Coord(0, 3));
        coordMap.put(3, new Coord(0, 5));
        coordMap.put(4, new Coord(0, 7));

        coordMap.put(5, new Coord(1, 0));
        coordMap.put(6, new Coord(1, 2));
        coordMap.put(7, new Coord(1, 4));
        coordMap.put(8, new Coord(1, 6));

        coordMap.put(9, new Coord(2, 1));
        coordMap.put(10, new Coord(2, 3));
        coordMap.put(11, new Coord(2, 5));
        coordMap.put(12, new Coord(2, 7));

        coordMap.put(13, new Coord(3, 0));
        coordMap.put(14, new Coord(3, 2));
        coordMap.put(15, new Coord(3, 4));
        coordMap.put(16, new Coord(3, 6));

        coordMap.put(17, new Coord(4, 1));
        coordMap.put(18, new Coord(4, 3));
        coordMap.put(19, new Coord(4, 5));
        coordMap.put(20, new Coord(4, 7));

        coordMap.put(21, new Coord(5, 0));
        coordMap.put(22, new Coord(5, 2));
        coordMap.put(23, new Coord(5, 4));
        coordMap.put(24, new Coord(5, 6));

        coordMap.put(25, new Coord(6, 1));
        coordMap.put(26, new Coord(6, 3));
        coordMap.put(27, new Coord(6, 5));
        coordMap.put(28, new Coord(6, 7));

        coordMap.put(29, new Coord(7, 0));
        coordMap.put(30, new Coord(7, 2));
        coordMap.put(31, new Coord(7, 4));
        coordMap.put(32, new Coord(7, 6));

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    board[i][j] = new NullPiece(new Coord(i, j));
                }
            }
        }
    }

    public Piece getPiece(int i, int j) {
        return board[i][j];
    }

    public Coord getCoord(int number) {
        return coordMap.get(number);
    }

    public Integer getNumber(Coord value) {
        for (Map.Entry<Integer, Coord> entry : coordMap.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void updateBoard(Piece piece) {
        board[piece.getCoord().getI()][piece.getCoord().getJ()] = piece;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(row(i));
        }
        return sb.toString();
    }

    private String row(int i) {
        if (i % 2 == 0) {
            return rowEven(i);
        } else {
            return rowOdd(i);
        }
    }

    private String rowEven(int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(board[row][i]);
        }
        sb.append("\n\n");
        return sb.toString();
    }

    private String rowOdd(int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(board[row][i]);
        }
        sb.append("\n\n");
        return sb.toString();
    }

    // TEST
    public Piece testGetByNumber(int number) {
        Coord c = getCoord(number);
        return board[c.getI()][c.getJ()];
    }
}
