package view.console;

import model.Cell;
import model.Game;
import model.Move;
import view.GameView;

import java.util.Scanner;

/**
 * Запуск консольного варианта игры
 */
public class ConsoleView implements GameView {
    private static final String SEPARATOR = "====================";
    public ConsoleView() {
        System.out.println("Игра Крестики-нолики");
        System.out.println(SEPARATOR);
    }

    public void render(Game game) {
        if(game.getState() == Game.State.X_MOVE) {
            System.out.println("===Ход крестиков!===");
        } else if(game.getState() == Game.State.O_MOVE) {
            System.out.println("====Ход ноликов!====");
        }
        for(int i = 0; i < game.getSize(); i++) {
            System.out.print(" ___");
        }
        System.out.println();
        for(int i = 0; i < game.getSize(); i++) {
            for(int j = 0; j < game.getSize(); j++) {
                if(game.getField()[j][i] == Cell.X) {
                    System.out.print("|_X_");
                }
                if(game.getField()[j][i] == Cell.O) {
                    System.out.print("|_O_");
                }
                if(game.getField()[j][i] == Cell.EMPTY) {
                    System.out.print("|___");
                }
            }
            System.out.println("|");
        }
        System.out.println();
        System.out.println(SEPARATOR);

        if(game.getState() == Game.State.O_WINS) {
            System.out.println("***===Нолики победили!===***");
        } else if(game.getState() == Game.State.X_WINS) {
            System.out.println("***===Крестики победили!===***");
        } else if(game.getState() == Game.State.DRAW) {
            System.out.println("===Ничья :(===");
        }
        System.out.println(SEPARATOR);
    }

    @Override
    public Move inputMove() {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        return new Move(x, y);
    }
}
