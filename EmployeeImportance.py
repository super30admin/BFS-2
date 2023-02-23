"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

#All TC passed on leetcode


class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:

         #Here we follow DFS approach. We create an adjacency list with id as key and employee object as value. For each recurrsive call add cur id's importance to res and we perform dfs on cur id's subordinates. 
        #Time complexity - O(V+E) - Traversing max of all ID or edges(subordinates)
        #Space complexity - O(V) - map holds only employee ids, emp object is stores as reference. queue size can max reach to all unique emp ID.

        adjList = {}
        for emp in employees:
            adjList[emp.id] = emp

        self.res = 0
        def dfs(id):
            curEmp = adjList[id]
            self.res += curEmp.importance
            for sub in curEmp.subordinates:
                dfs(sub)


        dfs(id)
        return self.res



#----------------------OR---------------------------------------


        #Here we follow BFS approach. We create an adjacency list with id as key and employee object as value. We add the id given into queue. We iterate over the queue till its not empty. For each iteration we pop id from queue and add its importance to res. Also we add he popped element's subordinates to queue. 
        #Time complexity - O(V+E) - Traversing max of all ID or edges(subordinates)
        #Space complexity - O(V) - map holds only employee ids, emp object is stores as reference. queue size can max reach to all unique emp ID.
        adjList = {}
        for emp in employees:
            adjList[emp.id] = emp
        
        queue = collections.deque()
        queue.append(id)

        res = 0
        while queue:
            curId = queue.popleft()
            curEmp = adjList[curId]
            res += curEmp.importance
            for sub in curEmp.subordinates:
                queue.append(sub)
        return res
