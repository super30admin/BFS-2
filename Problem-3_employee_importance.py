# APPROACH  1: BFS
# Time Complexity : O(n), n: number of employee records in given list
# Space Complexity : O(n * max size of employee record), due to hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Store all the employee records as value and id as key in hashmap, st access is O(1)
# 2. Start with record of given id. Add it's impotance to total and add it's children to the queue. 
# 3. Keep doing until, the queue is empty. Return total

"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        if employees is None:
            return 0
        
        hashmap_emp, queue, total = {}, deque(), 0
        for emp in employees:
            hashmap_emp[emp.id] = emp
            
        queue.append(id)
        while len(queue) > 0:
            emp_id = queue.popleft()
            total += hashmap_emp[emp_id].importance
            
            for sub_emp_id in hashmap_emp[emp_id].subordinates:
                queue.append(sub_emp_id)
                
        return total
        
        
        
        
# APPROACH 2: DFS
# Time Complexity : O(n), n: number of employee records in given list
# Space Complexity : O(n * max size of employee record), due to hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. maintain total as global variable. Store all the employee records as value and id as key in hashmap, st access is O(1)
# 2. Start with record of given id. Run dfs from here. Keep calling its children in depth wise manner recursively. (like only its' first child's all children gets processed 
#    then go to it's second child and so on
# 3. return total

"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def __init__(self):
        self.total = 0
        self.hashmap_emp = {}
        
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        if employees is None:
            return 0
        
        for emp in employees:
            self.hashmap_emp[emp.id] = emp
        
        self.dfs(id)
        return self.total
    
        
    def dfs(self, emp_id):
        self.total += self.hashmap_emp[emp_id].importance
        for sub_emp_id in self.hashmap_emp[emp_id].subordinates:
            self.dfs(sub_emp_id)
        
