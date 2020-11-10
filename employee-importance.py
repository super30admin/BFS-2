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
        imp_map = collections.defaultdict(int)
        sub_map = collections.defaultdict(list)
        for employee in employees:
            imp_map[employee.id] = employee.importance
            sub_map[employee.id] = employee.subordinates
            
        imp = 0
        q = collections.deque([id])
        while q:
            current_employee = q.popleft()
            imp += imp_map[current_employee]
            for sub in sub_map[current_employee]:
                q.append(sub)
        return imp
            
            