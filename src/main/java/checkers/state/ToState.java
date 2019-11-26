package checkers.state;

import checkers.Board;
import checkers.player.Player;

import java.util.Scanner;

public class ToState extends GameState {

    public ToState(Player player) {
        super(player);
    }

    @Override
    public Player doPlay(Board board) {

        System.out.println("TO STATE");
        Scanner myObj = new Scanner(System.in);
        System.out.println("Select to-move number");
        String choice = myObj.nextLine();
        try {
            int number = Integer.parseInt(choice);
            player.setMoveToNumber(number, player.getPieces());
            player.changeState(new MoveState(player));

        } catch (NumberFormatException e) {
            System.out.println("Number format exception");
        }
        return player;
    }

}
