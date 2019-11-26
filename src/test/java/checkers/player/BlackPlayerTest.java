package checkers.player;

import checkers.Board;
import checkers.piece.EmptyPiece;
import checkers.piece.Piece;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackPlayerTest {
    Board board = new Board();
    RedPlayer red = new RedPlayer(board);
    public BlackPlayer testObject = new BlackPlayer(board);
    public EmptyPlayer empty = new EmptyPlayer(board);
    TestHelper helper = new TestHelper(board, red, testObject, empty);

    @Test
    public void shouldFindMoves() throws Exception {
        helper.initNewGameBoard();
        System.out.println(board);

        testObject.findMoves();
        Piece p1 = board.testGetByNumber(21);
        Piece p2 = board.testGetByNumber(22);
        Piece p3 = board.testGetByNumber(23);
        Piece p4 = board.testGetByNumber(24);
        assertEquals(1, p1.getMoves().size());
        assertEquals(2, p2.getMoves().size());
        assertEquals(2, p3.getMoves().size());
        assertEquals(2, p4.getMoves().size());
        assertEquals("BLA 0", p1.testGetDisplayString());
        assertEquals("BLA 1", p2.testGetDisplayString());
        assertEquals("BLA 2", p3.testGetDisplayString());
        assertEquals("BLA 3", p4.testGetDisplayString());
        System.out.println(board);
        System.out.println("======================================");
        testObject.setMoveFromNumber(1, testObject.getPieces());
        assertEquals("BLACK", p1.testGetDisplayString());
        assertEquals("BL*CK", p2.testGetDisplayString());
        assertEquals("BLACK", p3.testGetDisplayString());
        assertEquals("BLACK", p4.testGetDisplayString());
        Piece e1 = board.testGetByNumber(17);
        Piece e2 = board.testGetByNumber(18);
        assertEquals(" _0_ ", e1.testGetDisplayString());
        assertEquals(" _1_ ", e2.testGetDisplayString());
        System.out.println(board);
        System.out.println("======================================");
    }

}