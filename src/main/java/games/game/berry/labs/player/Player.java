package games.game.berry.labs.player;

import games.game.berry.labs.SnakeAndLadderGame;

public interface Player {
    String getId();
    String getName();
    int getPosition();
    void setPosition(int position);
    void playturn();

    void setSnakeAndLadderGame(SnakeAndLadderGame snakeAndLadderGame);
    SnakeAndLadderGame getSnakeAndLadderGame();
}
