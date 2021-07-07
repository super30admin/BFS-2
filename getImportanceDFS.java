// Time Complexity :O(n) n length of the employees list;
// Space Complexity :O(n) n length of the employees list which is to be added in the HashMap and
// could also be the worst case for the recursive stack
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    int result;
    HashMap<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        result = 0;
        if(employees == null) return 0;
        map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id,e);
        }
        dfs(id);
        return result;
        }
    
    private void dfs(int id){
        Employee e = map.get(id);
        result += e.importance;
        for(int sub : e.subordinates){
            dfs(sub);
        }
    }
        
    }
