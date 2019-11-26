package checkers;


import checkers.player.Player;

public class App
{
    CheckerGame game = new CheckerGame();

    public static void main( String[] args )
    {
        App app = new App();
        app.runGame(app.game);
    }

    void runGame(CheckerGame game) {
        System.out.println(game.board);
        Player player = game.red;
        while(true) {
            player = player.getState().doPlay(game.board);
            System.out.println(game.board);
            //game.debugPrint();
        }
    }


}
