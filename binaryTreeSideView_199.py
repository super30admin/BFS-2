# Time Complexity : It is O(n) since we are iterating with the list.
# Space Complexity : It is O(h) since are creating the height of the tree.
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result=[]
        if root == None:
            return result

        queue = deque()
        queue.append(root)

        while queue:
            queueLen = len(queue)            
            level =[]        
            for i in range(queueLen):
                rootDeque = queue.popleft() 
                   
                if level == [] and rootDeque != None:
                    result.append(rootDeque.val)  
                    level.append(rootDeque.val) 
                if rootDeque != None and rootDeque.right != None:
                    queue.append(rootDeque.right) 

                if rootDeque != None and rootDeque.left != None:
                    queue.append(rootDeque.left)   
        return result