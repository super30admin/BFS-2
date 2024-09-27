//https://leetcode.com/submissions/detail/640578784/
//Time: O(V + E)
//Space: O(n) for storing colors

public class Solution {
    bool isBipartite;
    
    public bool IsBipartite(int[][] graph) {
        isBipartite = true;
        //0 - NoColor, 1 - Red, -1 Blue
        int[] colors = new int[graph.Length];
        
         for(int i = 0; i < graph.Length; i++) {
            if(colors[i] == 0) {
                colors[i] = 1;
                Dfs(graph, colors, i);
            }
        }
        
        return isBipartite;
    }
    
    private void Dfs(int[][] graph, int[] colors, int node) {

        if(!isBipartite) {
            return;
        }
        
        for(int i = 0; i < graph[node].Length; i++) {
             
            if(colors[graph[node][i]] == 0) {
               
               if(colors[node] == 1){
                   colors[graph[node][i]] = -1;
               } else {
                 colors[graph[node][i]] = 1;
               }
               Dfs(graph, colors, graph[node][i]);
                
            } else {
                if(colors[graph[node][i]] == colors[node]) {
                    isBipartite = false;
                    return;
                }                    
            } 
        }        
    }
    
}