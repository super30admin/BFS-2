Executed in Leetcode-yes
Time Complexity-0(n)
space Complexity-o(n)
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> emps= new HashMap<>();
        for(Employee e: employees){
            emps.put(e.id,e);
        }
        int totalImp=0;
        Queue<Integer> q= new LinkedList<Integer>();
        q.add(id);
        while(!q.isEmpty()){
            Employee cur = emps.get(q.poll());
            totalImp+=cur.importance;
            for(Integer sob:cur.subordinates){
                q.add(sob);
            }
        }
        return totalImp;
    }
}
