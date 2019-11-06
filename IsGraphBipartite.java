class IsGraphBipartite {
    // Appraoch 1 - Using BFS
    // Time complexity - O(n)
    // Space complexity - O(n)
    // Tested in leetcode
    
    // This functions tries to classify nodes of the graph into two sets such that nodes of any edge are not     // included in same set. Return true if such naming is possible.
    public boolean isBipartite(int[][] graph) {
        if(graph == null || graph.length == 0)
            return false;
        
        // Store the allocated name of each nodes of the graph.
        int[] visited = new int[graph.length];
        
        // Loop through each node of the graph when it is not classified.
        // This loop tracks nodes of disconnected graph as well.
        for(int i=0; i<graph.length; i++){
            if(graph[i].length != 0 && visited[i] == 0){
                visited[i] = 1;
                
                // store the neighbours of the node.
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                
                // loop through all neighbours of the node, assign name if not assigned and return false if                   // naming is not correct as per requirement.
                while(!queue.isEmpty()){
                    int position = queue.poll();
                    for(int node : graph[position])
                        // when neighbour has not been allocated a name
                        if (visited[node] == 0){
                            visited[node] = visited[position] == 1 ? 2 : 1;
                            queue.offer(node);
                        }
                        // when neighbours has same name return false
                        else if(visited[node] == visited[position])
                            return false;
                    }
                }
        }
        return true;
    }
}