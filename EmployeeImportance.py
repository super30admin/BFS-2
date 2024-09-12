// Time Complexity : O(V+E)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// // Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        hashMap={}
        queue=[]
        impSum=0
        for i in employees:
            hashMap[i.id]=[i.importance,i.subordinates]
            if i.id==id:
                queue=[id]
                
        while len(queue)!=0: #binary level order Traversal 
            element=queue.pop(0)
            temp=hashMap[element]
            impSum+=temp[0]
            size=len(temp[1])
            for i in range(size): #goes to subordinates for every employee added in the queue
                queue.append(temp[1][i])
        return impSum # returns final sum
 