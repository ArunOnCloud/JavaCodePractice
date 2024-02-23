package lld.games.game.berry.labs.player;

import lld.games.game.berry.labs.Dice;
import lld.games.game.berry.labs.GameBerryLabs;
import lld.games.game.berry.labs.SnakeAndLadderGame;
import lombok.Data;

@Data
public class PlayerImpl implements Player{

    private String id;
    private String name;
    private int position;

    private Dice dice;
    private SnakeAndLadderGame snakeAndLadderGame;

    private GameBerryLabs gameBerryLabs;
    public int rollDice(){
      return dice.rollDice();

    }

    public  PlayerImpl(String id,String name,int pos,Dice dice,GameBerryLabs gameBerryLabs){
        this.id=id;
        this.name=name;
        this.position=pos;
        this.dice= dice;
        this.gameBerryLabs=gameBerryLabs;
    }

    public void playturn(){
        snakeAndLadderGame.updateTurn(this,rollDice());
    }

    public String createGame(SnakeAndLadderGame snakeAndLadderGame){
        String gameKey=gameBerryLabs.createGame(this,snakeAndLadderGame);
        return gameKey;
    }

    public void inviteFriends(Player player,String gameKey){
        player.joinGame(gameKey);
    }
    public void joinGame(String gameKey){
        gameBerryLabs.joinGame(this,gameKey);
    }
    public void startGame(String gameKey){
        gameBerryLabs.startGame(gameKey);
    }



}
