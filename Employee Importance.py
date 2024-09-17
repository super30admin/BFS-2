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
        if(employees == None):
            return 0
        
        hashMap = {}
        total_importance = 0
        
        for _ in range(0, len(employees)):
            hashMap[employees[_].id] = employees[_]
        
        queue = deque()
        queue.append(id)
        
        while(queue):
            top = queue.popleft()
            total_importance += hashMap.get(top).importance
            
            subs = hashMap.get(top).subordinates
            for sub in subs:
                queue.append(sub)
        
        return total_importance
        
