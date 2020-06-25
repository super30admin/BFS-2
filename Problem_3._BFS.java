// Time complexity - O(n)
// Space complexity - O(n) {Map and Queue}

// BFS

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
        if(employees == null){
            return 0;
        }
        HashMap<Integer,Employee> map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id,e);
        }
        
        int result = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            int curr = q.poll();
            Employee e = map.get(curr);
            result += e.importance;
            for(int s : e.subordinates){
                q.add(s);
            }
        }
        return result;
    }
}
