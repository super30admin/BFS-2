#DFS approach
Time complexity - O(n)
space complexity - O(h)
Done on Leetcode: Yes
Problems faced: None
Description:
As the inputs are connected we solve this using DFS approach.for every employee sum the importance with the importance of its subordinates.
from collections import deque
class Solution(object):
    def __init__(self):
        self.result=0
        self.d=dict()
    def dfs(self,id):
        emp=self.d[id]
        subord=emp.subordinates
        self.result=self.result+emp.importance
        for j in subord:
            self.dfs(j)
        return self.result
        
    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        if len(employees)==0:
            return 0
        for j in employees:
            self.d[j.id]=j
        return self.dfs(id)
#BFS approach
Time complexity - O(n)
space complexity - O(n/2)
Done on Leetcode: Yes
Problems faced: None
Description:
we do this using BFS approach .FOr all the employees we sum up their importance.
from collections import deque
class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        if len(employees)==0:
            return 0
        d=dict()
        for j in employees:
            d[j.id]=j
        result=0
        queue=deque([id])
        while len(queue)!=0:
            empid=queue.popleft()
            emp=d[empid]
            subord=emp.subordinates
            imp=emp.importance
            result=result+imp
            if len(subord)!=0:
                for j in subord:
                    queue.append(j)
        return result
                    
            
        
        
                
        
                    
            
        
        
        