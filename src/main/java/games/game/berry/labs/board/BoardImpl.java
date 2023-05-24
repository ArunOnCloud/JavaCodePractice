package games.game.berry.labs.board;

import games.game.berry.labs.board.ladder.Ladder;
import games.game.berry.labs.board.snack.Snake;

import java.util.HashMap;
import java.util.Map;

public class BoardImpl implements Board {

    Map<Integer, Snake> snakes =new HashMap<>();
    Map<Integer, Ladder> ladders= new HashMap<>();

    int startPostion;
    int endPosition;

    public BoardImpl(int start,int end){
        this.startPostion=start;
        this.endPosition=end;
    }

    public boolean addSnack(Snake snack){
        int start=snack.getStart();
        if(isSnackExistAtPosition(start) || isLadderExistAtPosition(start)){
            return false;
        }
        snakes.put(start,snack);
        return true;
    }

    public boolean addLadder(Ladder ladder){
        int start=ladder.getStart();
        if(isSnackExistAtPosition(start) || isLadderExistAtPosition(start)){
            return false;
        }
        ladders.put(start,ladder);
        return true;
    }

    public boolean isSnackExistAtPosition(int position){
        return snakes.get(position) != null;
    }
    public boolean isLadderExistAtPosition(int position){
        return ladders.get(position) != null;
    }

    public Snake getSnake(int position){
        return snakes.get(position);
    }
    public Ladder getLadder(int position){
        return ladders.get(position);
    }




}
