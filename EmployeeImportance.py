#Time Complexity:O(n)
#Space Complexity:O(n)
#Leetcode Submission:Successful
#Problem Faced ::Wasnt able to think of hashmap or any other data structure to use

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
        m={e.id:e for e in employees}
        def helper(eid):
            emp=m[eid]
            return(emp.importance+sum(helper(eid)for eid in emp.subordinates))
        return helper(id)