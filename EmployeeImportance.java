/**
 * TC: O(V+E) SC: O(V+E)
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
    int sum;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null) return 0;
        HashMap<Integer,Employee> map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id,e);
        }
        sum = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        while(!q.isEmpty()){
            Employee curr = map.get(q.poll());
            sum+= curr.importance;
            if(curr.subordinates != null){    
                for(Integer i: curr.subordinates){
                    q.offer(i);
                }
            }
        }
        return sum;
    }
}