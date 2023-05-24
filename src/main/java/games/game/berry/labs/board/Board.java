package games.game.berry.labs.board;

import games.game.berry.labs.board.ladder.Ladder;
import games.game.berry.labs.board.snack.Snake;

public interface Board {

    public boolean addSnack(Snake snack);
    public boolean addLadder(Ladder ladder);
    public boolean isSnackExistAtPosition(int position);
    public boolean isLadderExistAtPosition(int position);

    public Snake getSnake(int position);
    public Ladder getLadder(int position);

}
