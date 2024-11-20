# Time Complexity : Add - O(N)
# Space Complexity :O(N), N is the no. of employees
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. I have used hashmap to maintain the adjacency list and then used BFS
'''

from collections import defaultdict, deque
class Solution:
    
    def __init__(self):
        # self.importance_dict = {}
        self.sub_dict = defaultdict(lambda : [])
        
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        if employees == [] or len(employees) < 1:
            return
        
        for emp in employees:
            
            if emp.id not in self.sub_dict:
                self.sub_dict[emp.id] = [emp.subordinates, emp.importance]
            else:
                self.sub_dict[emp.id][0].append(emp.subordinates)
                
        
        queue = deque()
        queue.append(self.sub_dict[id])
        
        total_import = 0
        while queue:
            
            root = queue.pop()
            total_import += root[1]
            
            for sub in root[0]:
                queue.append(self.sub_dict[sub])
            
        return total_import
            
                
        