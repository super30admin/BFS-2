# Time Complexity: O(V+E) where V is the number of employees and E is the number of edges(subordinate relationships)
# Space Complexity: O(V+E)
# Approach: Model the problem as an adjacency list. Create a map of employees: importance and employees: subordinates. Perform a bfs on this graph starting from the given employee id. Keep adding the importance of the subordinates as you traverse the graph.
"""
# Definition for Employee.
class Employee(object):
    def __init__(self, id, importance, subordinates):
    	#################
        :type id: int
        :type importance: int
        :type subordinates: List[int]
        #################
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        # Importance Map
        imp_map = collections.defaultdict(int)
        # Employee-Subordinate Adjacency List
        sub_map = collections.defaultdict(list)
        for employee in employees:
            imp_map[employee.id] = employee.importance
            sub_map[employee.id] = employee.subordinates
            
        imp = 0
        q = collections.deque([id])
        while q:
            current_employee = q.popleft()
            imp += imp_map[current_employee]
            # For each subordinate, incrementally add up importances while doing a BFS traversal
            for sub in sub_map[current_employee]:
                q.append(sub)
        return imp
        