//time complexity: O(n) hashmap will have all employees
//space complexity: O(n) where n is the number of employees 
//executed on leetcode: yes
/*Approach 
-Maintaining a map for id and its employee object
-going to subordinates and adding importance untill there is no subordinate left
i.e when we have reached leaf of the tree
*/

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size()==0) return 0;
        int result = 0;
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer,Employee> map = new HashMap<>();
        for(Employee e: employees)
        {
            map.put(e.id,e);
        }
        q.add(id);
        while(!q.isEmpty())
        {
            int curr_id = q.poll();
            result+=map.get(curr_id).importance;
            for(int subordiante_id: map.get(curr_id).subordinates)
            {
                q.add(subordiante_id);
            }
        }
        return result;
    }
    
}