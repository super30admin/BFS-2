Time Complexity: O(n)
Space Complexity: O(n)
Ran successfully on leetcode?: yes

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int totalImportance = 0;
        
        for(Employee employee : employees){
            map.put(employee.id, employee);
        }
        
        queue.add(id);
        
        while(!queue.isEmpty()){
            int currId = queue.poll();
            Employee currEmployee = map.get(currId);
            totalImportance += currEmployee.importance;
            
            for(Integer subordinate : currEmployee.subordinates){
                queue.add(subordinate);
            }
        }
        
        return totalImportance;
    }
}
