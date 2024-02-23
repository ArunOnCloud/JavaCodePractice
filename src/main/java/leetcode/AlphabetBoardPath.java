package leetcode;
import java.util.*;

public class AlphabetBoardPath {

    public static void main(String[] args) {
        AlphabetBoardPath alphabetBoardPath= new AlphabetBoardPath();
        System.out.println(alphabetBoardPath.alphabetBoardPath("zfz"));
    }
    public String alphabetBoardPath(String target) {
        String[] arr = new String[]{"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
        char[][] board = new char[6][5];

        for(int i=0;i<6;i++){
            for(int j=0;j<5;j++){
                if(i == 5 && j>=1){
                    continue;
                }
                board[i][j] = arr[i].charAt(j);
            }
        }
        int s=0;
        int e =0;
        String ans="";
        for(int i=0;i<target.length();i++){
            char tar = target.charAt(i);
            int[][] vis = new int[6][5];
            Pair[][] dp = new Pair[6][5];
            Pair p = util(board,s,e,6,5,tar,vis,dp);
           //print(dp,6,5);
            System.out.println(" p str:"+p.str+" val:"+p.val);
            ans = ans+p.str;
            int ind = (int)(tar-'a');
            s = ind/5;
            e= ind%5;
        }
        return ans;

    }

    void print( Pair[][] dp,int r,int c){
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(dp[i][j] != null){
                    System.out.print(" i:"+i+" j:"+j+" str:"+dp[i][j].str +" val:"+dp[i][j].val);
                }
            }
            System.out.println();
        }
    }

    Pair util(char[][] board,int i,int j,int r,int c,char tar,int[][] vis,Pair[][] dp){
        if( i<0 || j<0 || i>=r || j>=c){
            return new Pair("",Integer.MAX_VALUE);
        }
        if( i == 5 && j>0){
            return new Pair("",Integer.MAX_VALUE);
        }
        if(vis[i][j] == 1 ){
            return new Pair("",Integer.MAX_VALUE);
        }
        if( tar != board[i][j]){
            // return new Pair("",Integer.MAX_VALUE);
        }
        if( tar == board[i][j]){
            return new Pair("!",1);
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }

        vis[i][j]=1;

        Pair ans= null;
        Pair u = util(board,i-1,j,r,c,tar,vis,dp);
        if( u.val != Integer.MAX_VALUE){
            u = new Pair("U" + u.str,u.val+1);
        }
        Pair d = util(board,i+1,j,r,c,tar,vis,dp);
        if( d.val != Integer.MAX_VALUE){
            d = new Pair("D" + d.str,d.val+1);
        }
        Pair l = util(board,i,j-1,r,c,tar,vis,dp);
        if( l.val != Integer.MAX_VALUE){
            l = new Pair("L" + l.str,l.val+1);

        }
        Pair ri = util(board,i,j+1,r,c,tar,vis,dp);
        if( ri.val != Integer.MAX_VALUE){
            ri = new Pair("R" + ri.str,ri.val+1);

        }
        vis[i][j]=0;
        ans = getMin(List.of(u,d,l,ri));
        if(ans.val != Integer.MAX_VALUE){
            dp[i][j] = new Pair(ans.str, ans.val);
        }
        if(dp[i][j] != null){
            if(dp[i][j].val > ans.val){
                dp[i][j] = new Pair(ans.str,ans.val);
            }
        }else{
            dp[i][j] = ans;
        }
//        if(i==0 && j == 1  ){
//            if(dp[i][j].str.equals("UR!"))
//            System.out.println("");
//        }

        return new Pair(ans.str,ans.val);


    }
    Pair getMin(List<Pair> list){
        Pair min = new Pair("",Integer.MAX_VALUE);
        for(Pair p: list){
            if(min.val > p.val){
                min = new Pair(p.str,p.val);
            }
        }
        //if()
      //  System.out.println(" str:"+min.str+" len:"+min.val);
        return min;
    }
}
class Pair{
    int val;
    String str;
    Pair(String s,int val){
        this.str=s;
        this.val = val;
    }
}
