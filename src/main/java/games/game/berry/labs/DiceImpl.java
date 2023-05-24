package games.game.berry.labs;

import java.util.Random;

public class DiceImpl implements Dice{

    Random random=new Random();
    public int rollDice(){
        int val= random.nextInt(6);
        return val+1;
    }
}
