package games.game.berry.labs.player;

import games.game.berry.labs.Dice;
import games.game.berry.labs.SnakeAndLadderGame;
import lombok.Data;

@Data
public class PlayerImpl implements Player{

    private String id;
    private String name;
    private int position;

    private Dice dice;
    private SnakeAndLadderGame snakeAndLadderGame;
    public int rollDice(){
      return dice.rollDice();

    }

    public  PlayerImpl(String id,String name,int pos,Dice dice){
        this.id=id;
        this.name=name;
        this.position=pos;
        this.dice= dice;
    }

    public void playturn(){
        snakeAndLadderGame.updateTurn(this,rollDice());
    }



}
