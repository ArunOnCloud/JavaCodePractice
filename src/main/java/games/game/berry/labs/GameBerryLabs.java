package games.game.berry.labs;

import games.game.berry.labs.board.Board;
import games.game.berry.labs.board.BoardBuilder;

import games.game.berry.labs.board.ladder.LadderImpl;
import games.game.berry.labs.board.snack.SnakeImpl;
import games.game.berry.labs.player.Player;
import games.game.berry.labs.player.PlayerImpl;

import java.util.HashMap;
import java.util.Map;

public class GameBerryLabs {


    SnakeAndLadderGame snackAndLadderGame;
    Map<String, SnakeAndLadderGame> gameMap=new HashMap<>();

    public String createGame(Player player,Board board){
        //BoardImpl board=buildBoard();

        String gameKey= "first";
        Dice dice=new DiceImpl();
        SnakeAndLadderGame snackAndLadderGame1= new SnakeAndLadderGame(board,player,100,0);
        player.setSnakeAndLadderGame(snackAndLadderGame1);

       gameMap.put(gameKey,snackAndLadderGame1);
       return gameKey;
    }

    public void joinGame(Player player,String passKey){
        SnakeAndLadderGame snakeAndLadderGame=gameMap.get(passKey);
        snakeAndLadderGame.addPlayer(player);
        player.setSnakeAndLadderGame(snakeAndLadderGame);
    }
    public void startGame(String passKey){
        gameMap.get(passKey).startGameOops();
    }

//    public static void main(String[] args){
//        GameBerryLabs gameBerryLabs=new GameBerryLabs();
//        BoardImpl board=gameBerryLabs.buildBoard();
//        Dice dice=new DiceImpl();
//        Player player=new PlayerImpl("1","arun",0,dice);
//        SnakeAndLadderGame snackAndLadderGame1= new SnakeAndLadderGame(board,player,100,0);
//        player.setSnakeAndLadderGame(snackAndLadderGame1);
//        Player player2=new PlayerImpl("2","dipak",0,dice);
//        Player player3=new PlayerImpl("3","ashish",0,dice);
//        snackAndLadderGame1.addPlayer(player2);
//        snackAndLadderGame1.addPlayer(player3);
//        player2.setSnakeAndLadderGame(snackAndLadderGame1);
//        player3.setSnakeAndLadderGame(snackAndLadderGame1);
//        snackAndLadderGame1.startGameOops();
//    }

    public static void main(String[] args){
        GameBerryLabs gameBerryLabs=new GameBerryLabs();
        Dice dice=new DiceImpl();
        Player player=new PlayerImpl("1","arun",0,dice);
        Board board= new BoardBuilder(0,100).addLadder(new LadderImpl(10,45))
                .addLadder(new LadderImpl(19,85))
                .addLadder(new LadderImpl(28,87))
                .addLadder(new LadderImpl(56,98))
                .addSnack(new SnakeImpl(95,20))
                .addSnack(new SnakeImpl(43,7))
                .addSnack(new SnakeImpl(58,34))
                .addSnack(new SnakeImpl(81,9))
                .build();
        String gameCode=gameBerryLabs.createGame(player,board);
        Player player2=new PlayerImpl("2","ashish",0,dice);
        Player player3=new PlayerImpl("3","Dipak",0,dice);
        gameBerryLabs.joinGame(player2,gameCode);
        gameBerryLabs.joinGame(player3,gameCode);
        gameBerryLabs.startGame(gameCode);
    }
}
