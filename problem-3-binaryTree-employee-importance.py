"""
Problem:
https://leetcode.com/problems/employee-importance/

Approach: BFS

1. Create a map with key as emp ids and value as employee object for that id
2. Maintain a queue which will initially contain the employee object of the given id
3. pop the item from the que, add the importance value to the global count and add its sub-ordinate object to the que
4. perform step 3 while we have items in the queue

"""

# Time Complexity : O(n) where n is the no employees
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


from collections import deque
class Solution:
    map1 =None
    count = None
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        self.map1 = {}
        self.count = 0
        que = deque()
        
        for emp in employees:
            self.map1[emp.id] = emp
            if emp.id == id:
                que.append(emp)
        
        while(que):
            cur = que.popleft()
            self.count = self.count+cur.importance
            for sub in cur.subordinates:
                que.append(self.map1[sub])
        
        return self.count
            


# Time Complexity : O(n) where n is the no of nodes in the tree
# Space Complexity : O(h) where h is the height of the tree
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No

    map1 =None
    count =None
    
    def dfs(self,id):
        # base condition
        
        # logic
        emp = self.map1[id]
        x = emp.importance
        self.count = self.count+ emp.importance
        for sub in emp.subordinates:
            self.dfs(sub)
    
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        self.map1 ={}
        self.count = 0
        for emp in employees:
            self.map1[emp.id] = emp
        
        self.dfs(id)
        return self.count
        return self.res
        
        
  