//Time:O(N)
//Space:O(N)

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();

        for (Employee emp : employees)
            map.put(emp.id, emp);

        int output = 0;

        Queue<Integer> queue = new LinkedList<>();

        queue.add(id);

        while (!queue.isEmpty()) {

            int front = queue.poll();

            output += map.get(front).importance;

            for (int subs : map.get(front).subordinates) {
                queue.add(subs);
            }
        }

        return output;
    }
}