package view;

import model.Game;
import model.Move;

/**
 * Интерфейс игры
 */
public interface GameView {
    void render(Game game);
    Move inputMove();

}
