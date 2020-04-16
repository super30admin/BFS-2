"""
// Time Complexity : O(n) n-> number of employees
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach
Algorithm explanation
- Create graph using the hashmap from the list of employees
- Method1 - BFS on the given employee id
- Method2 - DFS on the given employee id
"""
"""
# Employee info
class Employee(object):
    def __init__(self, id, importance, subordinates):
        #################
        :type id: int
        :type importance: int
        :type subordinates: List[int]
        #################
        # It's the unique id of each node.
        # unique id of this employee
        self.id = id
        # the importance value of this employee
        self.importance = importance
        # the id of direct subordinates
        self.subordinates = subordinates
"""

class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        def create_graph(employees):
            graph = {}
            for emp in employees:
                emid = emp.id
                if emid not in graph:
                    graph[emid] = emp
            return graph
        
        
        emp_graph = create_graph(employees)
        print(emp_graph)
        #run bfs
        total_importance = 0
        q = [id]
        visited = set()
        while q:
            emp_id = q.pop(0)
            empobj = emp_graph[emp_id]
            total_importance+=empobj.importance
            for empid in emp_graph[emp_id].subordinates:
                if empid not in visited:
                    q.append(empid)
                    visited.add(empid)
        return total_importance



        #Method2 - DFS
        self.total_importance=0
        def dfs(empid):
            empobj = emp_graph[empid]
            self.total_importance+=empobj.importance
            subordinates = empobj.subordinates
            if subordinates:
                for i in subordinates:
                    dfs(i)
        dfs(id)
        return self.total_importance