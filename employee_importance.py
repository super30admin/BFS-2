"""
Add all employees to a hashmap. Simple BFS over all employees starting 
from id and keep a running count of importance

Time complexity - O(n)
Space complexity - O(n)

"""
# Employee info
class Employee:
    def __init__(self, id, importance, subordinates):
        # It's the unique id of each node.
        # unique id of this employee
        self.id = id
        # the importance value of this employee
        self.importance = importance
        # the id of direct subordinates
        self.subordinates = subordinates
"""
from collections import deque

class Solution:
    def getImportance(self, employees, id):
        """
        :type employees: Employee
        :type id: int
        :rtype: int
        """
        employee_map = {}
        for e in employees :
           employee_map[e.id] = e
        
        total_importance = 0
        queue = deque()
        queue.append(employee_map[id])
        while queue :
            e = queue.popleft()
            total_importance += e.importance
            for c in e.subordinates :
                queue.append(employee_map[c])
        
        return total_importance
        
            
