// Time Complexity :O(n)
// Space Complexity :O(n) n-length of the employee list
// Did this code successfully run on Leetcode :yes
//BFS
class Solution {
    public int getImportance(List<Employee> employees, int id) {
     if(employees==null) return 0;
     int result=0;
     HashMap<Integer,Employee> map=new HashMap<>();
     Queue<Integer> q=new LinkedList<>();
     q.add(id);
        for(Employee e:employees)
        {
            map.put(e.id,e);
        }
        
        while(!q.isEmpty())
        {
            int ide=q.poll();
            Employee temp=map.get(ide);
            List<Integer> list=temp.subordinates;
            result+=temp.importance;
            for(int i:list)
            {
                q.add(i);
            }
        }
        
        
        return result;
    }
}

//DFS
/* TC:O(n)
   SC:O(n)
class Solution {
    int result=0;
    HashMap<Integer,Employee> map;
    public int getImportance(List<Employee> employees, int id) {
     if(employees==null) return 0;
     
     map=new HashMap<>();
        for(Employee e:employees)
        {
            map.put(e.id,e);
        }
        dfs(id);
        return result;
    }
    private void dfs(int id)
    {
        Employee e=map.get(id);
        result+=e.importance;
        List<Integer> list=e.subordinates;
        for(Integer i:list)
        {
            dfs(i);
        }
    }
}
*/