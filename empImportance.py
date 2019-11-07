# Definition for a binary tree node.
# LeetCode 609 - Successful
# BFS approach

# Employee info
class Employee:
    def __init__(self, id, importance, subordinates):
        # It's the unique id of each node.
        # unique id of this employee
        self.id = id
        # the importance value of this employee
        self.importance = importance
        # the id of direct subordinates
        self.subordinates = subordinates

class Solution:

    def getImportance(self, employees, id):
        """
        :type employees: Employee
        :type id: int
        :rtype: int
        """
        #edge case
        if len(employees) == 0:
            return 0
        totalImp = 0
        #hashmap with emp_id and emp
        map = {}
        for i in range(len(employees)):
            map[employees[i].id] = employees[i]
        #to store emp_id and its subordinates ids
        queue = []
        queue.append(id)

        while len(queue) != 0:
            size = len(queue)
            for i in range (size):
                #fetch emp_id
                empid = queue.pop(0)
                #fetch emp for the emp_id and add its importance
                totalImp += map[empid].importance
                #fetch emp for the emp_id and add its subordinates
                subordi = map[empid].subordinates
                #iterate over the subordinates list and add it to queue
                for sub in subordi:
                    queue.append(sub)
        return totalImp

obj = Solution()
e1 = Employee(1, 5, [2, 3])
e2 = Employee(2, 3, [])
e3 = Employee(3, 3, [])
print(obj.getImportance([e1,e2,e3],1))
