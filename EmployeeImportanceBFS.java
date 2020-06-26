// Time Complexity: O(n)   n-> num of nodes
// Space Complexity: O(n) n-> employee 1 has all subordinates in the queue

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null) return 0;
        Map<Integer, Employee> map = new HashMap<>();

        for(Employee e : employees){
            map.put(e.id, e);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(id);

        int result = 0;

        while(!q.isEmpty()){

            int eid = q.poll();
            Employee e = map.get(eid);
            result += e.importance;
            for(int subId : e.subordinates){
                q.add(subId);
            }

        }
        return result;
    }
}
