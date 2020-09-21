# S30 Big N Problem #62 {Easy}

# LC - 690. 
# Employee Importance

# Time Complexity : O(n) n=no. of employees 
# Space Complexity : O(n) n=no. of employees 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

# Approach 
# create a graph structure using the employees data structure. 
# traverse the graph in BFS manner and calculate the importance at every node. 

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
        
        
        queue=[]
        
        dic={}
        
        for i in range(len(employees)):
            
            dic[employees[i].id]=employees[i]

        
        queue.append(dic[id])
        imp=0
        while queue:
            
            
            length=len(queue)
            
            for i in range(length):
                emp=queue.pop(0)
                imp+=emp.importance
                
                for j in range(len(emp.subordinates)):
                    queue.append(dic[emp.subordinates[j]])
        
        return imp
                
                
                
            
            
        