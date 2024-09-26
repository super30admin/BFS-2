/* Time complexity: O(n)
space complexity: O(n)
*/

class Solution{
    public int getImportance(List<Employee> employees, int id){
        if(employees == null || employees.size == 0) return 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees){
            map.add(e.id, e);
        }
        int result = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            //int size = q.size();
            int eid = q.poll();
            Employee e = map.get(eid);
            result += e.importance;
            for(int subID : e.subordinates){
                q.add(subID);
            }
        }
        return result;
    }
}