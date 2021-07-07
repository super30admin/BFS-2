'''
Solution
1.  The problem can be solved using one of the 3 methods (BFS using Queue or DFS using Stack or DFS using Recursion).
    Maintain a HashMap to store children or subordinates of all Employees.
2.  Using a Queue, just add the importance whenever an Employee object is added to the queue.
3.  In DFS (Iterative or Recursive), again add importance whenever an Employee object is added to the Stack (or
    Recursice Stack).

--- Passed all testcases on Leetcode successfully for all three solutions.

Time Complexity: O(n) in all 3 solutions, where n is the number of employees
Space Complexity: O(n) in BFS using Queue and O(h) in DFS approaches
'''


from collections import deque

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


class EmployeeImportance_Queue(object):
    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        #   edge case check
        if (employees == None or len(employees) == 0):
            return 0

        #   HashMap to store corresponding children nodes (subordinates)
        childrenMap = {}
        for employee in employees:
            childrenMap[employee.id] = employee

        #   initializations
        queue = deque([id])
        total = 0

        #   process each node while putting its children in the Queue (BFS) and add the importance to the final total.
        while (len(queue) > 0):

            frontId = queue.popleft()

            total += childrenMap[frontId].importance

            for subOrdinate in childrenMap[frontId].subordinates:
                queue.append(subOrdinate)

        return total


class EmployeeImportance_Recursion(object):

    def __init__(self):
        self.childrenMap = {}
        self.total = 0

    def __getImportanceHelper(self, id):

        #   additional computation required during Recursion (add importance to the final total)
        self.total += self.childrenMap[id].importance

        #   Recursion on each child (subordinate)
        for subOrdinate in self.childrenMap[id].subordinates:
            self.__getImportanceHelper(subOrdinate)

        return

    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        #   edge case check
        if (employees == None or len(employees) == 0):
            return 0

        #   HashMap to store corresponding children nodes (subordinates)
        for employee in employees:
            self.childrenMap[employee.id] = employee

        #   main function call
        self.__getImportanceHelper(id)

        return self.total


class EmployeeImportance_Stack(object):

    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        #   edge case check
        if (employees == None or len(employees) == 0):
            return 0

        #   HashMap to store corresponding children nodes (subordinates)
        childrenMap = {}
        for employee in employees:
            childrenMap[employee.id] = employee

        #   initializations
        total = 0
        stack = deque([[id, 0]])

        while (len(stack) > 0):

            top = stack[-1]
            topId = top[0]
            topCount = top[1]

            #   process each child and add it to the stack
            if (topCount < len(childrenMap[topId].subordinates)):
                stack[-1][1] += 1
                stack.append([childrenMap[topId].subordinates[topCount], 0])

            #   if all children are processed, add the importance to total and pop from the stack
            elif (topCount == len(childrenMap[topId].subordinates)):
                total += childrenMap[topId].importance
                stack.pop()

        return total