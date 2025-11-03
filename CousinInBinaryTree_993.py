# Time Complexity : It is O(n) since we are iterating with the list.
# Space Complexity : It is O(h) since are creating the height of the tree.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        queue = deque()
        queue.append(root)
       
        while queue:
            queueLen = len(queue)
            print(queueLen)
            oneChildFound = False
            secondChildFound = False
            for i in range(queueLen):
                deQueueNode = queue.popleft()
                if(deQueueNode != None and deQueueNode.left != None and deQueueNode.left.val==x and deQueueNode.right != None and deQueueNode.right.val==y ):
                    return False 
                if(deQueueNode != None and deQueueNode.left != None and deQueueNode.left.val==y and deQueueNode.right != None and deQueueNode.right.val==x ):
                    return False 
                if deQueueNode != None and deQueueNode.left != None:
                    queue.append(deQueueNode.left)
                if deQueueNode != None and deQueueNode.right != None:
                    queue.append(deQueueNode.right)
    
            for node in queue:
                                           
                if (node.val == x):
                    oneChildFound= True
                if (node.val == y):
                    secondChildFound= True
                if oneChildFound and secondChildFound:
                    return True
        return False