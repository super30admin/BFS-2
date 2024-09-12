/**
Problem: Employee Importance
Did it run on LeetCode : Yes

Time Complexity: O(n), where n is the size of the employees list.
Space Complexity : O(n), where n is the size of the employees list.(as we use a hashmap additionally)

Approach 1 : BFS
1. We put the employee IDs as keys in the hashmap, and the employee object as values.
2. Then, we first add the given ID to the queue. 
3. Later, we add the subordinates of the given id and add their importance scores to get the result.

Approach 2: DFS 
It's the same approach, but we implement it using DFS
*/


//BFS
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int result = 0;
        if(employees == null || employees.size() == 0) {
            return 0;
        }
        HashMap<Integer, Employee> hm = new HashMap<>();
        for(Employee e : employees) {
            hm.put(e.id, e);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()) {
            int eId = q.poll();
            Employee e = hm.get(eId);
            result += e.importance;
            for(int subId : e.subordinates) {
                q.add(subId);
            }
        }
        return result;
    }
}

//DFS
class Solution {
    int result;
    HashMap<Integer, Employee> hm;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) {
            return 0;
        }
        hm = new HashMap<>();
        for(Employee e : employees) {
            hm.put(e.id, e);
        }
        dfs(id);
        return result;
    }
    public void dfs(int id) {
        Employee e = hm.get(id);
        result += e.importance;
        for(int subId : e.subordinates) {
                dfs(subId);
        }
    }
}
