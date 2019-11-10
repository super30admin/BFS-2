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
        if employees == []:
            return 0
        def helper(id):
            val = importance[id]
            for i in subordinates[id]:
                val = val + helper(i) #recursive call for each subordinates 
            return val   
        #Creating two ditionaries for storing corresponding employee's imp and their direct subordinates
        importance = {} 
        subordinates = {}
        for i in employees:
            importance[i.id] = i.importance
            subordinates[i.id] = i.subordinates
        return  helper(id)