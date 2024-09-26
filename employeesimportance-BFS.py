"""BFS approach"""

#Accepted on Leetcode
#Time complexity - O(N) as we are visiting every node from id
#Space complexity - O(N) for the hashmap and queue


"""
# Employee info
class Employee(object):
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
class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: Employee
        :type id: int
        :rtype: int
        """
        #Edge case:
        if employees == [] or len(employees) == 0:
            return 0
        map1 = {}
        for i in employees:
            map1[i.id] = i
        q = deque()
        q.append(id)
        res = 0
        while len(q) > 0:
            eid = q.popleft()
            res = res + map1[eid].importance
            for subid in map1[eid].subordinates:
                q.append(subid)
        return res