//time complexity:O(n) 
//space complexity:O(n)number of employees in list
/*Approach 
-Maintaining a map for id and its employee object
-going to subordinates and adding importance untill there is no subordinate left
i.e when we have reached leaf of the tree
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EmployeeImportance {
    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    //bfs
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0)return 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id,e);
        }
        Queue<Employee> q = new LinkedList<>();
        q.add(map.get(id));
        int importance=0;
        while(!q.isEmpty()){
            Employee e = q.poll();
            importance += e.importance;
            for(int subord : e.subordinates){
                q.add(map.get(subord));
            }
            
        }
        
        return importance;
    }
    //dfs
    HashMap<Integer, Employee> map;
    int result = 0;
    public int getImportancedfs(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0)return 0;
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
        for(int subord : e.subordinates){
            dfs(subord);
        }
    }

    public static void main(String args[]){
        Employee e1=new Employee();
        e1.id=1;
        e1.importance =5;
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        e1.subordinates = list;
        Employee e2=new Employee();
        e2.id = 2;
        e2.importance=3;
        e2.subordinates = new ArrayList<>();
        Employee e3=new Employee();
        e3.id = 3;
        e3.importance=3;
        e3.subordinates = new ArrayList<>();

        ArrayList<Employee> elist = new ArrayList<>();
        elist.add(e1);
        elist.add(e2);
        elist.add(e3);
        EmployeeImportance obj = new EmployeeImportance();
        System.out.println(obj.getImportance(elist, 1));


    }
}