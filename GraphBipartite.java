/*
Author: Akhilesh Borgaonkar
Problem: Given an undirected graph, return true if and only if it is bipartite.
Approach: Coloring graph makes this problem more intuitive. Using BFS approach to color the edges of graph.
    If neighbour edge has no color, then push it to the queue, color it as opposite of current edge color and traverse its neighbors.
    If neighbour edge color found to be same as current edge color then return false as it cannot be colored.
Time complexity = O(E+V) where E is number of edges and V is number of vertices.
Space complexity = Constant
*/

import java.util.LinkedList;
import java.util.Queue;

public class GraphBipartite {

    public static boolean isBipartite(int[][] graph){

        int[] color = new int[graph.length];
        for(int i=0 ; i<color.length; ++i) {
            if(color[i] == 0){
                Queue<Integer> queue = new LinkedList<Integer>();
                queue.add(i);
                color[i]=1;
                while(!queue.isEmpty()){
                    int curr = queue.remove();
                    int nextColor = -color[curr];
                    int[] neighbours = graph[curr];
                    for (int next : neighbours) {
                        if (color[next] == 0) {
                            queue.add(next);
                            color[next] = nextColor;
                        }
                        if (color[next] != nextColor)
                            return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        if(isBipartite(graph))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
