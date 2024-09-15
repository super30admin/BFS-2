// Time Complexity :  O(N) no of employees
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    int ans = 0;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;
        HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        dfs(map, id);
        return ans;
    }
    private int dfs(HashMap<Integer, Employee> map, int id){
        Employee e = map.get(id);
        ans += e.importance;
        for(Integer subid: e.subordinates){
            dfs(map, subid);
        }
        return ans;
    }
}