# Leet code- Employee mportance (690)
#Time complexity -O(N)
#space Complexity -O(N)

#Approach - Created hash map for employee importance and subordinates working under him. 

# Employee info
class Employee(object):
    def __init__(self, id, importance, subordinates):
        # It's the unique id of each node.
        # unique id of this employee
        self.id = id
        # the importance value of this employee
        self.importance = importance
        # the id of direct subordinates
        self.subordinates = subordinates
        
        
class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: Employee
        :type id: int
        :rtype: int
        """
        #edge case:
        if len(employees)==0: return 0
        
        def helper(id):
            val=imp[id]
            for i in sub[id]:
                val=val+helper(i)
            return val 
                
        imp={}
        sub={}
        
        for i in employees:
            imp[i.id]=i.importance
            sub[i.id]=i.subordinates
        return  helper(id)
    
    
# DFS approach 
# Time complexity -O(N)
#space complexity -O(N)


class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: Employee
        :type id: int
        :rtype: int
        """
        self.hashmap={}
        
        #edge case:
        if len(employees)==0: return 0
        
        for employee in employees:
            self.hashmap[employee.id]=employee
        return self.helper(id,self.hashmap,employees)
        
    
    def helper(self,id,hashmap,employee):
        
        res=0
        curr =self.hashmap[id]
        res+=curr.importance
        for subord in curr.subordinates:
            res=res+self.helper(subord,self.hashmap,employee)
        return res
    

#BFS approach
#Time complexity -O(N)
#space complexity -O(N)

from collections import deque
class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: Employee
        :type id: int
        :rtype: int
        """
        hashmap={}
        
        #edge case:
        if len(employees)==0: return 0
        
        for employee in employees:
            hashmap[employee.id]=employee
        
        queue=deque([id])
        res=0
        while queue:
            emp_id=queue.popleft()
            curr=hashmap[emp_id]
            res=res+curr.importance
            for subord in curr.subordinates:
                queue.append(subord)
        return res
                
        
    
            
            