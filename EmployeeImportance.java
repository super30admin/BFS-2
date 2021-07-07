/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/

// Time Complexity : O(n) n -> no. of employees
// Space Complexity : O(n) using map as an auxiliary datastructure
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Approach1:DFS
// This problem can be treated as a graph problem. The graph can be a map wherein the subordinates list is the value for the current employee id (key). 
// Elements from subordinate list will be explored in DFS manner and the cumulative importance will be added globally.
/*
class Solution {
    int result;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null) return 0;
        result = 0;
        // creating graph
        Map<Integer, Employee> graph = new HashMap<>();
        for(int i = 0; i < employees.size(); i++) {
            Employee curr = employees.get(i); 
            graph.put(curr.id, curr);   
        }
        //System.out.println(graph);
        // Passing graph and current id to be searched for in graph
        dfs(graph, id);
        return result;
    }
    
    private void dfs(Map<Integer, Employee> graph, int id) {
        // base case
        if(graph.get(id) == null) return; 
        // logic
        Employee e = graph.get(id);
        // add importance
        result += e.importance;
        // perform dfs on all the subordinates
        for(int sub : e.subordinates) {
            dfs(graph, sub);
        }
    }
}
*/

// Time Complexity : O(n) n -> no. of employees
// Space Complexity : O(n) using map as an auxiliary datastructure
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Approach2:BFS
// In BFS approach also, we'll first create a map for mapping each employee with its corresponding Employee data structure.
// The given employee id will be added in queue and each of the subordinates for this id will also be added in queue iteratively. 

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null) return 0;
        int result = 0;
        // creating graph
        Map<Integer, Employee> graph = new HashMap<>();
        for(int i = 0; i < employees.size(); i++) {
            Employee curr = employees.get(i); 
            graph.put(curr.id, curr);   
        }
        //System.out.println(graph);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            Employee e = graph.get(curr);
            result += e.importance;
            for(int sub: e.subordinates)
                queue.offer(sub);
        }
        return result;
    }
}

