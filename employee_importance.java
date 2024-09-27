class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> hmap = new HashMap<>();
        for(Employee e: employees)
        {
            hmap.put(e.id, e);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        int output=0;
        
        while(!queue.isEmpty())
        {
            int cur=queue.poll();
            output+=hmap.get(cur).importance;
            
            for(int sub: hmap.get(cur).subordinates)
            {
                queue.offer(sub);
            }
        }
        return output;
    }
}
