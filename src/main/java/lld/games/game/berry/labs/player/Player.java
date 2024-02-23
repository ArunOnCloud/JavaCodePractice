package lld.games.game.berry.labs.player;

import lld.games.game.berry.labs.SnakeAndLadderGame;

public interface Player {
    String getId();
    String getName();
    int getPosition();
    void setPosition(int position);
    void playturn();

    void setSnakeAndLadderGame(SnakeAndLadderGame snakeAndLadderGame);
    SnakeAndLadderGame getSnakeAndLadderGame();
    public void joinGame(String gameKey);
    public String createGame(SnakeAndLadderGame snakeAndLadderGame);
    public void inviteFriends(Player player,String gameKey);
    public void startGame(String gameKey);
}
