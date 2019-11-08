# Passed on leetcode(690)
# Time - O(N), space - O(N)
# BFS Approach, add the root to queue first and remove root and add its subordinates level by level.
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
class Solution:
    def getImportance(self, employees, id):
        """
        :type employees: Employee
        :type id: int
        :rtype: int
        """
        if not employees or len(employees) == 0: return 0
        map = {} # hashmap with id as key
        queue = []
        for e in employees: # iterate through all employees
            map[e.id] = e
        queue.append(id) # append the given id to queue at the beginning
        result = 0
        while queue: # iterate through queue each time
            eid = queue.pop(0)
            e = map[eid]
            result += e.importance
            for subId in e.subordinates: # iterate through subordinates list and add them to queue one by one.
                queue.append(subId)
        return result