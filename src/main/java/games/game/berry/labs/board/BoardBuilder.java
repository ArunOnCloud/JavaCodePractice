package games.game.berry.labs.board;

import games.game.berry.labs.board.ladder.Ladder;
import games.game.berry.labs.board.snack.Snake;

import java.util.HashMap;
import java.util.Map;

public class BoardBuilder {
    private Map<Integer, Snake> snakes=new HashMap<>();

    private Map<Integer, Ladder> ladders= new HashMap<>();

    Board board;
    public BoardBuilder(int start,int end){
        board=new BoardImpl(start,end);

    }
    public BoardBuilder addSnack(Snake snake){
        snakes.put(snake.getStart(),snake);
        return this;
    }
    public BoardBuilder addLadder(Ladder snake){
        ladders.put(snake.getStart(),snake);
        return this;
    }
    public Board build(){
        for(Map.Entry<Integer,Snake> e: snakes.entrySet()){
            if(!board.addSnack(e.getValue())){
                throw new RuntimeException("Snack can not be added "+ e.getValue().getStart()+" , "+e.getValue().getEnd());
            }
        }
        for(Map.Entry<Integer,Ladder> e: ladders.entrySet()){
            if(!board.addLadder(e.getValue())){
                throw new RuntimeException("Ladder can not be added"+ e.getValue().getStart()+" , "+e.getValue().getEnd());
            }
        }
        return board;
    }

}