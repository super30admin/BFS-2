/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    // Time Complexity: O(N) --> adding to HashMap,
    //                         and in the queue -> total nodes traversed are n only 
    // Space Complexity:    O(N)  --> num of employees
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0)
            return 0;
        
        HashMap<Integer, Employee> map = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>(); // [[1,2,[2]], [2,3,[1]]]
        Queue<Integer> queue = new LinkedList<>();
        
        // Adding employee objects to hashmap to access thru emp-id
        for(Employee emp : employees){
            map.put(emp.id, emp);
        }
        
        // Adding the given employee to the queue
        queue.add(id);
        
        int size;
        int totalImportance = 0;
        while(!queue.isEmpty()){
            Employee curr = map.get(queue.poll());
            totalImportance += curr.importance;
            visited.add(curr.id);
            for(int i = 0; i < curr.subordinates.size(); i++){
                if(!visited.contains(curr.subordinates.get(i)))
                    queue.add(curr.subordinates.get(i));
                // else
                //     return totalImportance;
            }

        }
        return totalImportance;
    }
}