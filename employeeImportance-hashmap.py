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
        
        def helper(map1, id):
            curr = map1[id]
            result = curr.importance
            for subid in curr.subordinates:
                result += helper(map1, subid)
            return result        
        map1 = {}
        for e in employees:
            map1[e.id] = e
        return helper(map1,id)