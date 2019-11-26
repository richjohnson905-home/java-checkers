package checkers.player;

import checkers.Board;
import checkers.piece.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class RedPlayerTest {

    Board board = new Board();
    RedPlayer testObject = new RedPlayer(board);
    public BlackPlayer black = new BlackPlayer(board);
    public EmptyPlayer empty = new EmptyPlayer(board);
    TestHelper helper = new TestHelper(board, testObject, black, empty);

    @Test
    public void shouldFindMoves() throws Exception {
        helper.initNewGameBoard();
        System.out.println(board);

        testObject.findMoves();
        Piece p1 = board.testGetByNumber(9);
        Piece p2 = board.testGetByNumber(10);
        Piece p3 = board.testGetByNumber(11);
        Piece p4 = board.testGetByNumber(12);
        assertEquals(2, p1.getMoves().size());
        assertEquals(2, p2.getMoves().size());
        assertEquals(2, p3.getMoves().size());
        assertEquals(1, p4.getMoves().size());
        assertEquals(" RE 0", p1.testGetDisplayString());
        assertEquals(" RE 1", p2.testGetDisplayString());
        assertEquals(" RE 2", p3.testGetDisplayString());
        assertEquals(" RE 3", p4.testGetDisplayString());
        System.out.println(board);
        System.out.println("======================================");
        testObject.setMoveFromNumber(1, testObject.getPieces());
        assertEquals(" RED ", p1.testGetDisplayString());
        assertEquals(" R*D ", p2.testGetDisplayString());
        assertEquals(" RED ", p3.testGetDisplayString());
        assertEquals(" RED ", p4.testGetDisplayString());
        Piece e1 = board.testGetByNumber(14);
        Piece e2 = board.testGetByNumber(15);
        assertEquals(" _1_ ", e1.testGetDisplayString());
        assertEquals(" _0_ ", e2.testGetDisplayString());
        System.out.println(board);
        System.out.println("======================================");
        testObject.setMoveToNumber(0, testObject.getPieces());
        assertEquals(" ___ ", e1.testGetDisplayString());
        assertEquals(" _*_ ", e2.testGetDisplayString());
    }

    @Test
    public void testCoordMap() {
        Coord first = new Coord(0, 1);
        assertEquals(board.getNumber(first).intValue(), 1);
    }

}