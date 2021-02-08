// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach: uing bfs and dictionary and storing the popped elements subordinates in queue


class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        
        dic = {}
        
        for employee in employees:
            dic[employee.id] = employee
        
        sum = 0
        q = deque()
        res = dic[id]
        q.append(id)
        
        while q:
            p = q.popleft()
            sum += dic[p].importance
            
            for i in dic[p].subordinates:
                q.append(i)
        return sum
