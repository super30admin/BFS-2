// Time Complexity : O(N)N=number of employes or number of elements in list of employees . 
// Space Complexity : O(N)N=number of elements in list that are store in Map + recursive call O(maxDepth) => O(n)
// and the worse case is all oranges are rotten.
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//the code uses the dfs  traversal we keep sum result at each call to dfs at the end we return the result;
//Success
//Details 
//Runtime: 4 ms, faster than 99.83% of Java online submissions for Employee Importance.
//Memory Usage: 41 MB, less than 100.00% of Java online submissions for Employee Importance.

class Solution {
    private int result=0;
    public int getImportance(List<Employee> employees, int id) {
        //edge case
        if (employees==null|| employees.size()==0) return 0;
        Map<Integer,Employee> graph= new HashMap<>();
        for (Employee e:employees){
            graph.put(e.id,e);
        }
        dfs(graph, id);
        return result;
    }
    private void dfs(Map<Integer,Employee> graph,int node){
        Employee e= graph.get(node);
        result+=e.importance;
        for (int id:e.subordinates)
            dfs(graph,id);
    }
}