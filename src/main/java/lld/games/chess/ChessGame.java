package lld.games.chess;

import lld.games.chess.board.Board;
import lld.games.chess.enums.GameState;
import lld.games.chess.piece.Piece;
import lld.games.chess.player.Player;

public class ChessGame {

    Board board;
    Player player1;
    Player player2;
    GameState gameState;

    int currentTurnIndex;
    private boolean isMoveValid(Player player, Piece piece,int r,int c){

        return true;
    }
    void makeMoveOfPlayer(Player player,Piece piece,int r,int c){

    }
    public  void buildGame(){

    }
    public void playNextTurn(){

    }
    private boolean isGameEnd(){
        return false;
    }

    public void startGame(){

    }


}
