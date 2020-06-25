# Time Complexity : O(n) time, where n is the total number of employees 
# Space Complexity : O(n) space, where n is the total number of employees
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Employee:
    def __init__(self, id, importance, subordinates):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

class Solution:
    # 1) BFS method 
    # def getImportance(self, employees, id):
    #     if not employees:
    #         return 0 
    #     d = {}
    #     result = 0
    #     for emp in employees:
    #         d[emp.id] = emp 
    #     q = [id]
        
    #     while q:
    #         curr = q.pop(0)
    #         e = d[curr]
    #         result += e.importance
    #         for i in e.subordinates:
    #             q.append(i)
    #     return result
    
    # 2) DFS method 
    result = None 
    map = None 
    def getImportance(self, employees, id):
        if not employees:
            return 0 
        self.map = {}
        self.result = 0 
        for emp in employees:
            self.map[emp.id] = emp 
        self.__dfs(id)
        return self.result 
    
    def __dfs(self,id):
        
        emp = self.map[id]
        self.result += emp.importance 
        for e in emp.subordinates:
            self.__dfs(e)

if __name__ == "__main__":
    s = Solution()
    e1 = Employee(0,0,0)
    e1.id = 1 
    e1.importance = 5 
    e1.subordinates = [2,3]
    
    e2 = Employee(0,0,0)
    e2.id = 2 
    e2.importance = 3 
    e2.subordinates = []
    
    e3 = Employee(0,0,0)
    e3.id = 3 
    e3.importance = 3 
    e3.subordinates = []
    
    id = 1 
    employees = [e1,e2,e3]
    res = s.getImportance(employees,id)
    print(res)