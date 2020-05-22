package com.ds.rani.bfs;

import java.util.*;

public class EmployeeImportance {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    /***********************BFS Solution**********************/
    //Time complexity:o(n)
    //Space complexity:o(w) where w is the width of the graph

    public int getImportance(List<Employee> employees, int id) {
        int totalImportance = 0;
        if(employees==null || employees.size() ==0)
            return 0;

        //create map for easy lookup
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(map.get(id).id);
        while (!queue.isEmpty()) {
            Employee e = map.get(queue.poll());
            totalImportance += e.importance;
            for (int subordinate : e.subordinates) {
                queue.add(subordinate);
            }
        }
        return totalImportance;
    }


    /***********************DFS Solution**********************/
    //Time complexity:o(n)
    //Space complexity:o(h) where h is the height of the graph
    public int getImportanceDFS(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0)
            return 0;

        //create map for easy lookup
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put( employee.id, employee );
        }

        return dfs(map,id);
    }
    private int dfs(Map<Integer, Employee> map, int rootId) {

        Employee root = map.get(rootId);
        int total = root.importance;

        for (int subordinate : root.subordinates) {
            total += dfs(map, subordinate);
        }
        return total;
    }
}
