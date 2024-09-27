# Passed on leetcode(690)
# Time - O(N), space - O(N)
# DFS approach
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
# employees is a class, iterate over it and save it to hashmap. Id is being hashkey and employee class objects are value.
        map = {}
        for e in employees:
            map[e.id] = e
        return self.helper(map, id)
    # As being a DFS solution(need helper function, for recursion)
    def helper(self, map, id):
        curr = map[id] # getting the id to process and get the importance
        result = curr.importance # get the importance
        for subId in curr.subordinates: # loop over it's subordinates.
            result += self.helper(map, subId) # add the importance of subordinates to the result using recurrsion.
        return result