//https://leetcode.com/submissions/detail/640657263/
//BFS: O(nodes + edges)
//O(maximum nodes at single level)
public class Solution {
    public bool IsBipartite(int[][] graph) {
        int[] colors = new int[graph.Length];
        
        Queue<int> q = new Queue<int>();
        //0=nocolor, 1=red, 2=blue
               
        for(int j = 0; j < colors.Length; j++) {
            if(colors[j] == 0) {
                colors[j] = 1;
                q.Enqueue(j);

                while(q.Count > 0) {
                    int node = q.Dequeue();

                    for(int i = 0; i < graph[node].Length; i++) {

                        if(colors[graph[node][i]] == colors[node]) {
                                return false;
                            }
                        if(colors[graph[node][i]] == 0) {
                            colors[graph[node][i]] = colors[node] == 1 ? 2 :1;
                            q.Enqueue(graph[node][i]);
                        }              
                    }
                }
            }
        }
        
       
        return true;
        
    }
}