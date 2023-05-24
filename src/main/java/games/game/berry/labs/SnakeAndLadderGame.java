package games.game.berry.labs;

import games.game.berry.labs.board.Board;
import games.game.berry.labs.board.ladder.Ladder;
import games.game.berry.labs.board.snack.Snake;
import games.game.berry.labs.player.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*

Requirements
    Design class diagram for snake and ladders multiplayer game.
    One of the players creates a room and shares the roomCode with up to 3 of his friends.
    These friends join the room with the roomCode provided and once all the players are ready, the room creator can start the game.
	Each of the players have 1 token each.
	And they start at position 1 on the board and the first one to reach position 100 will win the game.
	Players will roll an unbiased dice one by one in a predetermined order, the token of the player will be moved ahead by the number with the dice outcome.
	If the token stops on the start of the ladder then the token moves up to the end of the ladder.
	Similarly, if the player lands at the face of the snake, then the token moves down to the position where the end of the snake tail lies.
	First one who reaches the position 100 wins the game.

Other points to consider:
    The board is set up with the snake and ladders using several of the predefined configurations of snakes and ladders.
    There will be different types of snakes, ladders which appear differently on the board.


Future scope
   These points are optional points to be considered during the design,
   these ideas may or may not be implemented by the product in future.
   There can be multiple game modes introduced in future which can have different configurations like
   Multiple dice to be rolled by player at once as opposed to single dice.
   Multiple dice to be owned by each player and first one to reach all his/her tokens to 100 wins.
   Special type of snake (If you land on it, you will not only go to the end of tail but also lose next turn)
   and ladder (If you land on it, you will go to the top of the ladder and get an extra turn) can be introduced.
   Shape of the board can change in new modes but the numbering will continue to be 1 to 100.

Expected from candidate
Well designed and extensible class diagram of the game with clear indication of fields,
functions (their return type, params, access specifiers) and relationship between classes.
A write up or a sequence diagram for the important flows of the game.

 */
public class SnakeAndLadderGame {

    Board board;

    List<Player> players=new LinkedList<>();
    int WINNIG_POSITION;
    int START_POSITION;
    int playerTurnIndex;

    Dice dice=new Dice() {
        Random random=new Random();
        @Override
        public int rollDice() {
            return random.nextInt(6)+1;

        }
    };

    public SnakeAndLadderGame(Board board, Player player, int winningPosition, int startPosition){
        this.players.add(player);
        this.board=board;
        WINNIG_POSITION=winningPosition;
        START_POSITION=startPosition;
    }

    public void startGameOops(){
        int ind=playerTurnIndex% players.size();
        Player player=players.get(ind);
        player.playturn();
    }


    void movePlayer(Player player, int position){
        int newPosition= player.getPosition()+ position;
        if( newPosition > WINNIG_POSITION){
            System.out.println("Cant move");
        }else{
            if(board.isLadderExistAtPosition(newPosition)){
                Ladder ladder= board.getLadder(newPosition);
                player.setPosition(ladder.getEnd());

            }else if( board.isSnackExistAtPosition(newPosition)){
                Snake snake=board.getSnake(newPosition);
                player.setPosition(snake.getEnd());
            }else{
                player.setPosition(newPosition);
            }
        }
    }
    public void addPlayer(Player player){
        players.add(player);
    }

    boolean isGameEnd(int position){
        return WINNIG_POSITION == position;
    }

    public void updateTurn(Player player,int diceOutcome){
        System.out.println("player "+player.getName()+ " dice:"+diceOutcome);
        movePlayer(player,diceOutcome);

        if(isGameEnd(player.getPosition())){
            System.out.println("player " + player.getName() +" wins");
            return;
        }else{
            playNextTurn();
        }
    }

    public void playNextTurn(){
        playerTurnIndex++;
        int index=playerTurnIndex%players.size();
        Player player=players.get(index);
        player.playturn();
    }


}
