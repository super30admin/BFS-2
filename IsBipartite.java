/*
The time complexity is O(N) and the space complexity is O(N)
Here we start from a node when its not previously visited we give it 0. The for its neighbours we give 1. For any of its
neighbours if we have colour same as current node colour then return false;

Yes, the solution passed all the test cases in leetcode.
 */
class Solution {
    public boolean isBipartite(int[][] graph) {

        HashMap<Integer,Integer> colorMap = new HashMap<>();

        Queue<Integer> queue = new LinkedList<>();



        for(int i=0;i<graph.length;i++){
            if(!colorMap.containsKey(i)){
                queue.add(i);
                colorMap.put(i,0);
            }
            while(queue.size()>0){
                int temp = queue.poll();
                int presentColor = colorMap.get(temp);
                for(Integer vertex:graph[temp]){
                    if(!colorMap.containsKey(vertex)){
                        colorMap.put(vertex,presentColor^1);
                        queue.add(vertex);
                    }
                    else if(colorMap.get(vertex)==presentColor){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}