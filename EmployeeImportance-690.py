
# Time Complexity : O(n)
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Store the importance and suboridnated in a map to easy acces and then perform a bfs
# class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        ans = 0
        res = {}
        for employee in employees:
            res[employee.id] = ((employee.importance, employee.subordinates))
        
        queue = [id]
        while queue:
            front = queue.pop(0)
            ans += res[front][0]
            
            for sub in res[front][1]:
                queue.append(sub)
        
        return ans
