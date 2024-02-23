package lld.games.chess.board;

import lld.games.chess.piece.Piece;

public class Board {
    private int row;
    private int col;

    Place[][] places;
    public Board(int r,int c){
        this.row=r;
        this.col=c;
        places=new Place[row][col];
        initPlaces();
    }
    private void initPlaces(){
        int ind=0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                Color color;
                if(ind%2 ==0){
                    color=Color.WHITE;
                }else{
                    color=Color.BLACK;
                }
                places[i][j]=new Place(i,j,color);
                ind++;
            }
        }
    }
    public Piece getPieceAtPosition(int row,int col){
        return new Piece();
    }

}
