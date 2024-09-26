// Time Complexity : O(Vertexes+Edges)
// Space Complexity : O(Vertexes+Edges)
// Three line explanation of solution in plain english

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int result=0;
        q.add(id);
        for(Employee e:employees){
            map.put(e.id,e);
        }
        

        while(!q.isEmpty()){
            int tmp = q.poll();
            result+=map.get(tmp).importance;
            for(int neigh:map.get(tmp).subordinates){
                if(set.add(neigh))
                    q.add(neigh);
            }
        }
        
        return result;
        
    }
}

// Time Complexity : O(Vertexes+Edges)
// Space Complexity : O(Vertexes+Edges)
// Three line explanation of solution in plain english

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int result=0;
        q.add(id);
        for(Employee e:employees){
            map.put(e.id,e);
        }
        set.add(id);
        
        return helper(result,map,id,set);
        
    }
    
    public int helper(int result, Map<Integer,Employee> map, int id,Set<Integer> set){
        // while(!q.isEmpty()){
            // int tmp = q.poll();
            result+=map.get(id).importance;
            for(int neigh:map.get(id).subordinates){
                if(set.add(neigh))
                    result = helper(result,map,neigh,set);
            }
        // }
        
        return result;
    }
}