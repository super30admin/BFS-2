// Time complexity: O(n)
// Space complexity: O(n)

/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
        Queue<Employee> q = new LinkedList<>();
        HashMap<Integer, Employee> map = new HashMap<>();
            
        for(int i = 0; i<employees.size(); i++){
            map.put(employees.get(i).id, employees.get(i));
            if(employees.get(i).id == id){
                q.add(employees.get(i));
            }
        }
        int sum = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++ ){
                Employee front = q.poll();
                sum += front.importance;
                List<Integer> subs = map.get(front.id).subordinates;
                if(subs != null || subs.size() != 0){
                    for(int sub_id: subs){
                        q.add(map.get(sub_id));
                    }
                }
            }
        }     
        return sum;
    }
}
