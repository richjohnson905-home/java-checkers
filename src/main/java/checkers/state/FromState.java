package checkers.state;

import checkers.Board;
import checkers.player.Player;

import java.util.Scanner;

public class FromState extends GameState {

    public FromState(Player player) {
        super(player);
    }

    @Override
    public Player doPlay(Board board) {

        System.out.println("FROM STATE");
        Scanner myObj = new Scanner(System.in);
        System.out.println("Select move-from number");
        String choice = myObj.nextLine();
        try {
            int number = Integer.parseInt(choice);
            player.setMoveFromNumber(number, player.getPieces());
            player.changeState(new ToState(player));

        } catch (NumberFormatException e) {
            System.out.println("Number format exception");
        }
        return player;
    }

}
