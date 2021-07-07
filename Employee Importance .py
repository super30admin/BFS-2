
"""
# Employee info
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        # It's the unique id of each node.
        # unique id of this employee
        self.id = id
        # the importance value of this employee
        self.importance = importance
        # the id of direct subordinates
        self.subordinates = subordinates
"""

class Solution:
    # LookUp from the list to find Importance value of each employee O(N) ===> O(N*N) LookUp for all Employees
    # Creating an HASHMAP graph, O(N) ===> O(1) LookUP on each employee_id and [id, importance, subordinates]
    # BFS / DFS on the Employee using lookUp, add the Importance, LookUp its Subordinates Importance

    # BFS 
    # time : O(N)
    # space : O(2N), HashMap (graph) + q 
    
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if employees == None:
            return 0

        # creating a HashMap as a GRAPH for O(1) lookup
        graph = {}
        for employee in employees:
            graph[employee.id] = employee
        
        # BFS on the Employee HashMap graph
        q = [id]
        importanceSum = 0
        while q != []:
            size = len(q)
            for i in range(size):
                root = q.pop(0)
                importanceSum += graph[root].importance
                for sub in graph[root].subordinates:
                    q.append(sub)
        
        return importanceSum




# ================================================================================================================

    # DFS 
    # time : O(N)
    # space : O(1) + Recursive call stack

    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if employees == None:
            return 0

        # creating a HashMap as a GRAPH for O(1) lookup
        g = {}
        for emp in employees:
            g[emp.id] = emp
        
        # DFS
        self.importanceSum = 0
        self.helper(id, g)
        return self.importanceSum
    
    def helper(self, id, g):
        # BASE CASE                         (for loop takes care of the base case)

        # LOGIC
        self.importanceSum += g[id].importance
        subs = g[id].subordinates
        for sub in subs:                     # DFS recurse for every subordinate
            self.helper(sub, g)
                
