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
    private static final String DELIMITTER = "====================";
    public ConsoleView() {
        System.out.println("Игра Крестики-нолики");
        System.out.println(DELIMITTER);
    }

    public void render(Game game) {
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
        System.out.println(DELIMITTER);
    }

    @Override
    public Move inputMove() {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        return new Move(x, y);
    }
}
