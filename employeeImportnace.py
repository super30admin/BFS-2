# Time Complexity : O(N) where N is number of ID here it is V+E
#Space Complexity : (O(H)) where H is height of Tree Numer of subordintes
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
        def dfs(id):
            e = d.get(id)
            self.result+=e.importance
            for subid in e.subordinates:
                dfs(subid)
        
        d = {}
        if employees == None:
            return 0
        for e in employees:
            d[e.id] = e
        self.result = 0
        dfs(id)
        return self.result
==========================================================================
# Time Complexity : O(N) where N is number of ID here it is V+E
#Space Complexity : (O(B)) where Breadth of Queue is  Numer of subordintes

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
        d={}
        Queue = []
        if employees == None:
            return 0
        for e in employees:
            d[e.id] = e
        self.result = 0
        Queue.append(id)
        e =d.get(id)
        
        while(len(Queue) > 0):
            size = len(Queue)
            for i in range(size):
                curr = Queue.pop(0)
                e = d.get(curr)
                self.result+=e.importance
                for subid in e.subordinates:
                    Queue.append(subid)
        return self.result
            
                