

/*
    BFS approach
    Time complexity : O(N)
    Space Complexity :O(N)
    worked on leetcode : YES

*/
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
    
}
public class Employee_Importance {
    



    int res = 0;
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map =  new HashMap<>();
        Stack<Integer> q = new Stack<>();
        for(Employee e :  employees){
            if  (!map.containsKey(e.id)){
                map.put(e.id, e);
            }
            if(e.id == id){
                q.add(id);
            }
        }
        
        while(!q.isEmpty()){
            Employee e = map.get(q.pop());
            if (e != null){
                res+=e.importance;
                List<Integer> subList = e.subordinates;
                for(int i = 0;i< subList.size();i++){
                    q.add(subList.get(i)); 
                }
        
            }
        }
        return res;
    }
}