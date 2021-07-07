//Time Complexity:O(N)
//Space Complexity:O(N)

class Solution {
    int total;
    Map<Integer,Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        map=new HashMap();
        for(Employee e:employees){
            map.put(e.id,e);
        }
        helper(employees,id);
        return total;
    }
    private void helper(List<Employee> employees, int id){
        Employee e=map.get(id);
        total+=e.importance;
        for(Integer nums:e.subordinates){
            helper(employees,nums);
        }
    }
    
}