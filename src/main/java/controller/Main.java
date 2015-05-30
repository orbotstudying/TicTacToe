package controller;

import model.Game;
import model.UserException;
import view.GameView;
import view.console.ConsoleView;

import java.util.Scanner;

/**
 * Контроллер
 */
public class Main {

    public static void main(String[] args) {
        GameView gameView = new ConsoleView();
        gameView.showMessage("Введите размер поля");
        int size = new Scanner(System.in).nextInt();
        Game game = new Game(size);

        while(!game.isGameFinished()) {
            try {
                if(game.getState() == Game.State.X_MOVE) {
                    gameView.showMessage("Ход крестиков: ");
                } else if(game.getState() == Game.State.O_MOVE) {
                    gameView.showMessage("Ход ноликов");
                }
                game.move(gameView.inputMove());
                game.checkForWinner();
                game.checkForDraw();
                gameView.render(game);
                game.switchState();
            } catch (UserException e) {
                gameView.showMessage(e + "Повторите снова");
            }
        }
    }
}
