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

from collections import deque


class Solution:
    def getImportanceBFS(self, employees: List['Employee'], id: int) -> int:
        """
            https://leetcode.com/problems/employee-importance/
            // Time Complexity : O(n)
                'n' is the number of employees
            // Space Complexity : O(n)
            // Did this code successfully run on Leetcode : Yes
            // Any problem you faced while coding this : No
            // Three line explanation of solution in plain english :
                - Restructure into { employee_id : Employee Object}
                - Level order traversal
        """
        imp = 0
        if not employees:
            return imp

        emp = {}
        # restructure data
        for employee in employees:
            emp[employee.id] = employee

        # level order traversal
        queue = deque()
        queue.append(id)
        while queue:
            cur = queue.pop()
            imp += emp[cur].importance
            for sub in emp[cur].subordinates:
                queue.append(sub)
        return imp

    imp = 0
    emp = {}

    def getImportance(self, employees: List['Employee'], id: int) -> int:
        """
            https://leetcode.com/problems/employee-importance/
            // Time Complexity : O(n)
                'n' is the number of employees
            // Space Complexity : O(h)
                Max depth in the employee hierarchy
            // Did this code successfully run on Leetcode : Yes
            // Any problem you faced while coding this : No
            // Three line explanation of solution in plain english :
                - Restructure into { employee_id : Employee Object}
                - Level order traversal
        """

        if not employees:
            return self.imp

        # restructure data
        for employee in employees:
            self.emp[employee.id] = employee

        self._helper(id)
        return self.imp

    def _helper(self, id):

        self.imp += self.emp[id].importance

        # logic
        for sub_id in self.emp[id].subordinates:
            self._helper(sub_id)