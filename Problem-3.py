# Time Complexity :O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        employees_hash = {}
        #save emp in hash with key as id
        for i in employees:
            employees_hash[i.id] = i
        #put id of imp in stack
        stack = [id]
        #set sol to 0
        sol = 0
        while stack:
            #pop from stack
            curr = stack.pop()
            # add importance to sol
            sol+= employees_hash[curr].importance
            # add all subordinatce to the stack 
            stack = stack+ employees_hash[curr].subordinates
        return sol