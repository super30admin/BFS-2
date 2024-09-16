class Solution {// time and space of O(n)
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id,e);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        int output = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            output += map.get(curr).importance;
            for(int sub:map.get(curr).subordinates){
                queue.add(sub);
            }
        }
        return output;
    }
}