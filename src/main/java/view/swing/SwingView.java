package view.swing;

import model.Game;
import model.Move;
import view.GameView;

import javax.swing.*;

/**
 * Отображение игры в Swing интерфейсе
 */
public class SwingView implements GameView {
    public SwingView() {
        JFrame frame = new JFrame("Игра Крестики-нолики");
        frame.setContentPane(new MainForm().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void render(Game game) {

    }

    @Override
    public Move inputMove() {
        return null;
    }

    @Override
    public void showMessage(String message) {

    }
}
