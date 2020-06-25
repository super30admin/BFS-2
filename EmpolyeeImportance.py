//BFS Approcah
//Time Complexity: O(n)
//Space Complexity:O(n)
// Did the code run successfully on leet code: Yes

"""
# Definition for Employee.
class Employee(object):
    def __init__(self, id, importance, subordinates):
    	#################
        :type id: int
        :type importance: int
        :type subordinates: List[int]
        #################
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        res = 0
        hashmap = {}
        for e in employees:
            # print(e.id)
            hashmap[e.id] = e
        q = deque([id])
        # print(hashmap)
        # print(q)
        
        # print(len(q))
        while(len(q)):
                 
                currid = q.popleft()
                print(currid)
                node = hashmap[currid]
                res = res+node.importance
                print(res)
                for i in range(len(node.subordinates)):
                    q.append(node.subordinates[i])
        return res           
                
