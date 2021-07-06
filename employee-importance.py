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
        dic={}
        # print(employees)
        for emp in employees:
            dic[emp.id]=emp
        imp=0
        from collections import deque
        q=deque()
        q.append(id)
        while q:
            length=len(q)
            for i in range(length):
                popp=q.popleft()
                for i in dic[popp].subordinates:
                    q.append(i)
                imp+=dic[popp].importance
        return imp
    #n-arry tree or graph-O(v+e) space-o(v(dic)+e(queue))