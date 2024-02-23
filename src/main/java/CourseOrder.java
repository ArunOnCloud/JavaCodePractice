import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseOrder {


    public static void main(String[] args) {
        CourseOrder courseOrder = new CourseOrder();
        int[][] pre= new int[][]{
                {1,0},{2,0},{3,1},{3,2}
        };

        /*

        0 -> 1

         */
        System.out.println( courseOrder.orderCourses(4,pre));
    }



    public List<Integer> orderCourses(int n, int[][] prerequisites){


        Map<Integer, Set<Integer>> graph= new HashMap<>();

        for(int i=0;i<n;i++){
            graph.put(i,new HashSet<>());
        }
        for(int[] edge: prerequisites){
            int v = edge[1];
            int u = edge[0];
            graph.get(v).add(u);
        }

        int[] vis= new int[n];
        Boolean[] dp = new Boolean[n];
        List<Integer> result = new LinkedList<>();
        for(int i=0;i<n;i++){
            if( dp[i] == null){
                dfs(graph,i,vis,dp,result);
            }
        }
        return result;

    }
    void dfs(Map<Integer,Set<Integer>> graph,int v,int[] vis,Boolean[] dp,List<Integer> result){

        if(vis[v] != 0){
            return;
        }
        if( dp[v] != null){
            return;
        }

        vis[v] = 1;

        for(int e: graph.get(v)){

            if(vis[e] != 0 && dp[e] == false){
                dfs(graph,e,vis,dp,result);
            }
        }
        vis[v] = 0;
        dp[v] = true;
        result.add(v);

    }
}
