#Time complexity: O(n)
#Space complexity: O(n)
#Works on leetcode: yes
#Approach: The idea here is to create an easy lookup for employees using the ids. Then perform dfs to get the importance of 
#all subordinates for the given employee id. 

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        mapping = {e.id:e for e in employees}
        def dfs(id):
            subordinates_imp = sum(dfs(subid) for subid in mapping[id].subordinates)
            return subordinates_imp + mapping[id].importance
        return dfs(id)
