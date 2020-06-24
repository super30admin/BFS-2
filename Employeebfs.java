//Time Complexity:O(N)
//Space Complexity:O(N)


class Solution {
    public int getImportance(List<Employee> employees, int id) {
         if(employees==null || employees.size()==0){
             return 0;
         }
        Map<Integer,Employee> map=new HashMap();
        for(Employee e:employees){
            map.put(e.id,e);
        }
        Queue<Integer> q=new LinkedList();
        q.add(id);
        int result=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int eid=q.poll();
                Employee e=map.get(eid);
                result+=e.importance;
                for(int j:e.subordinates){
                    q.add(j);
                }
            }
        }
        return result;
    }
}