#LC 690 - Employee Importance
#Time Complexity - O(n)
#Space Complexity - O(n)
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
        adj = dict()
        for emp in employees:
            adj[emp.id] = emp
        self.ans = 0
        def dfs(id):
            self.ans = self.ans + adj[id].importance
            for emp in adj[id].subordinates:
                dfs(emp)
        dfs(id)
        return(self.ans)