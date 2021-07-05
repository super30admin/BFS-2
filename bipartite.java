//recursive dfs
//Time complexity:O(V+E)
//Space Complexity:O(V+E)
//In this approach, I'll be creating a colors array, where in I'll try to color my neighbors in an alternate manner. If I couldn't color in an alternate fashion, that means they are are not biparite. If I could, then they are. In the first approach, i used recursive DFS to do these operations, where a dfs helper function will take in the graph, colors , an input color, 1 for red and -1 for blue, 0 for uncolored. and the current node. 
//This code was executed successfully and got accepted in leetcode. 
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] colors=new int[n];
        for(int i=0;i<n;i++){
            if(colors[i]==0&&!dfs(graph,colors,1,i)){
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int[][] graph,int[] colors,int color, int node){
        if(colors[node]!=0){
            return colors[node]==color;
        }
        colors[node]=color;
        for(int neighbor:graph[node]){
           if(!dfs(graph,colors,-color,neighbor)){
               return false;
           }
        }
        return true;
    }
}

//Iterative DFS
//Time complexity:O(V+E)
//Space Complexity:O(V+E)
//This problem uses the same approach as before, but instead of a recursion, an iterative DFS approach has been used to solve the problem. A stack is used to keep track of the colored and uncolored nodes and the same conditions are checked here again in an iterative manner until the stack goes empty.
//This code was executed successfully and got accepted in leetcode. 

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] colors=new int[n];
        for(int i=0;i<graph.length;i++){
            if(colors[i]==0){
                Stack<Integer> stack=new Stack();
                stack.push(i);
                colors[i]=1;
                while(!stack.isEmpty()){
                    int node=stack.pop();
                    for(int neighbor:graph[node]){
                        if(colors[neighbor]==0){
                            stack.push(neighbor);
                            colors[neighbor]=-colors[node];
                        }
                        else if(colors[neighbor]==colors[node]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

//BFS
//Time complexity:O(V+E)
//Space Complexity:O(V+E)
//This approach is amost the same as the previous with the stack data structure being replaced by queue data structure making ity a BFS approach. 
//This code was executed successfully and got accepted in leetcode. 

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] colors=new int[n];
        for(int i=0;i<graph.length;i++){
            if(colors[i]==0){
                Queue<Integer> queue=new LinkedList<>();
                queue.add(i);
                colors[i]=1;
                while(!queue.isEmpty()){
                    int node=queue.poll();
                    for(int neighbor:graph[node]){
                        if(colors[neighbor]==0){
                            queue.add(neighbor);
                            colors[neighbor]=-colors[node];
                        }
                        else if(colors[neighbor]==colors[node]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}