


/*

Given a 2D grid map of '1's (island) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacet lands horizontally or vertically.
All for edges of the grid are surrounded by water.

Example:

Input
11110
11010
11000
00000

Output: 1

Input
11000
11000
00100
00011

Output: 3
 */

/*

Given two sorted arrays A1 and A2 of size M and N respectively, return the median of the two sorted arrays.

public int median(int[] A1, int[] A2)

Try to decrease complexity below O(m+n)
 */

public class EpamSecondInterview {


    public static void main(String[] args) {

        int[][] grid= new int[][] {
                {1,1,1,1,0},
                {1,1,0,1,0},
                {1,1,0,0,0},
                {0,0,0,0,0}
        };

        System.out.println(countIslands(grid));
        int[][] grid2= new int[][]{
                {1,1,0,1,0}
        };
        System.out.println(countIslands(grid2));

    }

    static int countIslands(int[][] grid){
        int r= grid.length;
        int c=0;
        if(r >0){
            c = grid[0].length;
        }
        Integer[][] vis= new Integer[r][c];
        int count=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(vis[i][j] == null && grid[i][j] == 1){
                    dfs(grid,vis,i,j,r,c,count);
                    count++;
                }
            }
        }


        return count;
    }
    static void dfs(int[][] grid,Integer[][] vis,int i,int j,int r,int c ,int mark){
        if( i<0 || j<0 || i>=r || j>=c){
            return ;
        }
        if(vis[i][j] != null){
            return;
        }
        if(grid[i][j] == 0){
            return;
        }
        vis[i][j]=mark;
        dfs(grid,vis,i+1,j,r,c,mark);
        dfs(grid,vis,i-1,j,r,c,mark);
        dfs(grid,vis,i,j+1,r,c,mark);
        dfs(grid,vis,i,j-1,r,c,mark);

    }
}
