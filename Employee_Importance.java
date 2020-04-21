// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i < employees.size();i++){
            Employee emp = employees.get(i);
            map.put(emp.id, i);
        }
        
        q.add(id);
        while(!q.isEmpty()){
            Integer empIndex = map.get(q.poll());
            Employee emp = employees.get(empIndex);
            if(emp!=null){
                sum+=emp.importance;
                if(emp.subordinates!=null){
                    for(int sub:emp.subordinates){
                        q.add(sub);
                    }
                }
            }
        }
        
        return sum;
    }
}