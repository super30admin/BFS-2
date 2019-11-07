class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees.size() == 0) return 0;
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id, e);
        }
        
        return helper(map, id);
    }
    
    private int helper(Map<Integer,Employee> map, int id){
        Employee current = map.get(id);
        int result = current.importance;
        for(int subId : current.subordinates){
            result += helper(map, subId);
        }
        
        return result;
    }
}