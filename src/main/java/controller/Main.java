package controller;

import model.Game;
import model.UserException;
import view.GameView;
import view.console.ConsoleView;
import view.swing.SwingView;

/**
 * Контроллер
 */
public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        GameView gameView = new ConsoleView();
        GameView gui = new SwingView();
        while(!game.isGameFinished()) {
            try {
                if(game.getState() == Game.State.X_MOVE) {
                    System.out.println("Ход крестиков: ");
                } else if(game.getState() == Game.State.O_MOVE) {
                    System.out.println("Ход ноликов");
                }
                game.move(gameView.inputMove());
                gameView.render(game);
                game.checkForWinner();
                game.switchState();
            } catch (UserException e) {
                System.out.println(e + "Повторите снова");
            }
        }
    }
}
