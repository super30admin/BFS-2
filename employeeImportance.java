//time complexity: O(N+M) where N is the number of employees and M is the average number of subordinates of an employee
//space complexity: O(N);
import java.util.*;
class ESolution {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Integer> empMap = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int total=0;
        for(int i=0; i < employees.size(); i++)     //O(N)
        {
            empMap.put(employees.get(i).id, i);
        }
       
        q.add(id);
        
        while(!q.isEmpty())                     //O(N+M)
        {
            Employee e= employees.get(empMap.get(q.poll()));
            total+=e.importance;
            List<Integer> sub=e.subordinates;
            
            for(int s: sub)
            {
                q.add(s);
            }
        }
        return total;
    }
}