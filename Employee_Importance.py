"""
Time Complexity : getImportance_BFS - O(n)
                  getImportance_DFS - O(n)
Space Complexity :getImportance_BFS - O(n)
                  getImportance_DFS - O(n) [O(h) - stack space]
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : none
"""


# Employee info
class Employee:
    def __init__(self, id, importance, subordinates):
        """
        :type id: int
        :type importance: int
        :type subordinates: List[int]
        """
        # It's the unique id of each node.
        # unique id of this employee
        self.id = id
        # the importance value of this employee
        self.importance = importance
        # the id of direct subordinates
        self.subordinates = subordinates


from queue import Queue

class Solution:
    def getImportance_BFS(self, employees, id):
        """
        :type employees: Employee
        :type id: int
        """
        if not employees or len(employees) == 0:
            return 0
        
        hashmap = {}
        q = Queue()
        
        for e in employees:
            if e.id not in hashmap:
                hashmap[e.id] = e
        
        q.put(hashmap[id])
        imp = 0
        while not q.empty():
            emp = q.get()
            imp += emp.importance
            for i in emp.subordinates:
                q.put(hashmap[i])
                
        return imp
    
    def getImportance_DFS(self, employees, id):
        if not employees or len(employees) == 0:
            return 0
        
        hashmap = {}
        for e in employees:
            if e.id not in hashmap:
                hashmap[e.id] = e
        
        self.dfs(hashmap, hashmap[id])
        return self.imp
        
    def dfs(self, hashmap, employee):
        for emp_id in employee.subordinates:
            self.dfs(hashmap, hashmap[emp_id])
        self.imp += employee.importance
        return
    