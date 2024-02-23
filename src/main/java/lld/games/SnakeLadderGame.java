package lld.games;

import lombok.Data;

import java.util.*;

public class SnakeLadderGame {

    int WINNIG_POSITION;
    int START_POSITION;
    List<Player> playerList;
    Dice dice;
    Board board;

    public static void main(String[] args){

        Dice dice =new Dice();
        Player player1=new Player(1,"arun");
        player1.setPosition(0);
        Player player2=new Player(2,"some");
        player2.setPosition(0);
        List<Player> players=new LinkedList<>();
        players.add(player1);
        players.add(player2);

        Board board1=new Board(100);
        board1.addLadder(10,45);
        board1.addLadder(23,89);
        board1.addLadder(29,98);
        board1.addSnake(95,10);
        board1.addSnake(65,12);
        board1.addSnake(30,5);
        SnakeLadderGame snakeLadderGame=new SnakeLadderGame();
        snakeLadderGame.WINNIG_POSITION=100;
        snakeLadderGame.START_POSITION=0;
        snakeLadderGame.dice=dice;
        snakeLadderGame.playerList=players;
        snakeLadderGame.board=board1;
        snakeLadderGame.startGame();


    }
    SnakeLadderGame(){

    }

    int rollDice(){
        return dice.rollDice();
    }
    void movePlayer(Player player,int position){
        int newPosition= player.getPosition()+ position;
        if( newPosition > WINNIG_POSITION){
            System.out.println("Cant move");
        }else{
            if(board.isLadderPresent(newPosition)){
               Ladder ladder= board.getLadder(newPosition);
                player.setPosition(ladder.end);
            }else if( board.isSnakePresent(newPosition)){
                Snake snake=board.getSnake(newPosition);
                player.setPosition(snake.end);
            }else{
                player.setPosition(newPosition);
            }
        }
    }
    boolean isGameEnd(int position){
        return WINNIG_POSITION == position;
    }

    void startGame(){

        int ind=0;
        while(true){
            int playerIndex= ind%playerList.size();
            int number= rollDice();
            Player player=playerList.get(playerIndex);
            movePlayer(playerList.get(playerIndex),number);
            System.out.println(" dice:"+number+" player:"+player.name+" position:"+player.position);
            if(isGameEnd(player.position)){
                System.out.println("player"+ playerIndex +" wins");
                break;
            }
            ind++;

        }
    }


}
class  Dice{
    private Random random;
    Dice(){
        random=new Random();
    }
    int rollDice(){
        int val= random.nextInt(6);
        return val+1;
    }
}
@Data
class Player{
    int id;
    String name;
    Player(int id,String name){
        this.id=id;
        this.name=name;
    }
    int position;
    public void setPosition(int position){
        this.position=position;
    }


}

class Board{
    int[] places;

    Map<Integer,Snake> snakes;
    Map<Integer,Ladder>  ladderList;

    Board(int n){
        places=new int[n];
        snakes=new TreeMap<>();
        ladderList=new TreeMap<>();


    }
    boolean addSnake(int start,int end){

        Snake snake=new Snake(start,end);
        if( snakes.containsKey(start) ){
            return false;
        }else{
            snakes.put(start,snake);
            return true;
        }
    }
    boolean addLadder(int start,int end){
        Ladder ladder=new Ladder(start,end);
        if(ladderList.containsKey(start)){
            return false;
        }else{
            ladderList.put(start,ladder);
            return true;
        }
    }
    boolean isSnakePresent(int position){
        return snakes.containsKey(position);
    }
    boolean isLadderPresent(int position){
        return ladderList.containsKey(position);
    }
    Snake getSnake(int position){
        return snakes.get(position);
    }
    Ladder getLadder(int position){
        return ladderList.get(position);
    }

}
class Snake{
    int start;
    int end;
    Snake(int start,int end){
        this.start=start;
        this.end=end;
    }

}
class Ladder{
    int start;
    int end;
    Ladder(int start,int end){
        this.start=start;
        this.end=end;
    }

}
