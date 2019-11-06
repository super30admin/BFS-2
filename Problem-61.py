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