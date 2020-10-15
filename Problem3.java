/*

Time Complexity : O(N)
Space Complexity: O(N)

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
        
        HashMap<Integer,Employee> hmap = new HashMap<>();
        for(Employee e: employees)
        {
            hmap.put(e.id,e);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        int output = 0;
        
        while(!queue.isEmpty())
        {
            int curr = queue.poll();
            output += hmap.get(curr).importance;
            for(int sub: hmap.get(curr).subordinates)
            {
                queue.offer(sub);
            }
        }
        return output;        
    }
}