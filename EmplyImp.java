/*
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// nope

// Your code here along with comments explaining your approach
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
      //create graph of id, employee obj.
      //no need to create seen array since all children only have one parent.
      //so we will never encounter walked node more than once.
        HashMap<Integer, Employee> graph = new HashMap<>();
        int ret = 0;
        Queue<Integer> qu = new LinkedList<>();
        for(Employee emp : employees){
           graph.put(emp.id, emp);
        }

        //use bfs to compute importance from given node(id),
        //to the very last child.
        qu.add(id);
        while(!qu.isEmpty()){
            Employee emp = graph.get(qu.poll());
            ret += emp.importance;
            List<Integer> slist = emp.subordinates;
            for(int ids : slist){
                qu.add(ids);
            }
        }
        return ret;
    }
}
