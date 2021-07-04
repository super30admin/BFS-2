'''
https://leetcode.com/problems/employee-importance/
Did  it run leetcode: Yes
Problems faced: None

'''

'''
DFS solution
Time Complexity: 0(N)
Space Complexity: 0(N)

'''
class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: Employee
        :type id: int
        :rtype: int
        """
        self.hashMap = dict()
        for employee in employees:
            self.hashMap[employee.id] = employee
        
        return self.dfsHelper(id)
    
    def dfsHelper(self,empId):
        result = 0
        for subId in self.hashMap.get(empId).subordinates:
            result += self.dfsHelper(subId)
        return result+self.hashMap[empId].importance


'''
BFS Solution
Time Complexity: 0(N)
Space Complexity: 0(N)
'''

from collections import deque
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
        if employees==None or len(employees)==0:
            return 0
        
        employeeValues = {}
        for employee in employees:
            empId=employee.id
            employeeValues[empId] = employee
        
        queue = deque([id])
        result = 0
        while queue:
            empId = queue.popleft()
            result += employeeValues[empId].importance
            for subId in employeeValues[empId].subordinates:
                queue.append(subId)
        return result