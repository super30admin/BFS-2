# Runs on Leetcode

# BFS
  # Runtime - O(n)
  # Memory - O(n)


class Solution:
    def getImportance(self, employees: List['Employee'], x):
        # edge case
        if not employees:
            return 0
        
        hash_map = {}
        for employee in employees:
            hash_map[employee.id] = (employee.importance, employee.subordinates)
            
        weight = 0 
        queue = []
        queue.append(x)
        
        while(queue):
            popped_element = queue.pop()
            weight += hash_map[popped_element][0]
            temp = hash_map[popped_element][1]
            for i in range(len(temp)):
                queue.append(temp[i])
                
        return weight
