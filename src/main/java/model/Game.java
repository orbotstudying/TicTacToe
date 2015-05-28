package model;

/**
 * Состояние игры
 */
public class Game {


    /**
     * Размер поля
     */
    final int size;
    /**
     * Поле игры
     * Координаты отсчитываем от
     * верхнего левого угла
     */
    final Cell[][] field;
    /**
     * Состояние игры
     */
    State state = State.X_MOVE;

    private Move lastMove;

    public Game(int size) {
        this.size = size;
        field = new Cell[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                field[x][y] = Cell.EMPTY;
            }
        }
    }

    public Game() {
        this(3);
    }

    public int getSize() {
        return size;
    }

    /**
     * Ход
     *
     * @param move - объект с ходом
     */
    public void move(Move move) throws UserException {
        int x = move.x;
        int y = move.y;
        if (x < 0 || x >= size)
            throw new UserException("x за пределами поля");
        if (y < 0 || y >= size)
            throw new UserException("y за пределами поля");
        if (field[x][y] != Cell.EMPTY)
            throw new UserException("Ячейка занята x = " + x + " y = " + y);

        switch (state) {
            case X_MOVE:
                field[x][y] = Cell.X;
                break;
            case O_MOVE:
                field[x][y] = Cell.O;
                break;
            default:
                throw new UserException("Ход невозможен!");
        }
        lastMove = move;
    }

    public enum State {
        X_MOVE("Ход крестиков"),
        O_MOVE("Ход ноликов"),
        X_WINS("Крестики выиграли"),
        O_WINS("Нолики выиграли"),
        DRAW("Ничья");

        public final String name;

        State(String name) {
            this.name = name;
        }
    }

    public boolean isGameFinished() {
        if(state == State.X_WINS || state == State.O_WINS || state == State.DRAW)
            return true;
        else
            return false;
    }

    public void switchState() {
        if(!isGameFinished()) {
            if(state == State.X_MOVE) {
                state = State.O_MOVE;
            } else if(state == State.O_MOVE) {
                state = State.X_MOVE;
            }
        }
    }

    public State getState() {
        return state;
    }

    public Cell[][] getField() {
        return this.field;
    }

    public void checkForWinner() {
        boolean gameFinished = true;
        Cell checkedValue = null;

        if(state == State.X_MOVE) {
            checkedValue = Cell.X;
        } else if(state == State.O_MOVE) {
            checkedValue = Cell.O;
        }
        int count = 0;
        for(int i = 0; i < getSize(); i++) {
            if(field[i][lastMove.y] == checkedValue) {

            }
        }
    }
}
