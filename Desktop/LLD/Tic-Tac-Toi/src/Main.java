import models.GameStatus;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("======= TicTokToi Game =======");
        TicTacToiGame game = new TicTacToiGame();
        game.initializeGame();
        GameStatus status = game.startGame();
        switch (status) {
            case WIN:
                System.out.println(game.winnder.name + " won the game");
                break;
            case DRAW:
                System.out.println("Game dow");
                break;
            default:
                System.out.println("Game ends");
                break;
        }
    }
}