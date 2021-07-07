TC: O(n)
SC: O(n)

Runtime: 13 ms, faster than 18.35% of Java online submissions for Employee Importance.
Memory Usage: 47.5 MB, less than 95.24% of Java online submissions for Employee Importance.



class Solution {
    int result;
    public int getImportance(List<Employee> employees, int id) {
      
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees)  
            map.put(e.id,e);
        helper(id,map);
        return result;
        
    }
    private void helper(int id, Map<Integer,Employee> map){
        Employee e = map.get(id);
        System.out.println(e.id);
        
        result += e.importance;
       for(int i: e.subordinates) {
           helper(i,map);
       }
        
        
    }
}
