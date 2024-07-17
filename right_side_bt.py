# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    hashmap={}
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:

        if root is None: return []
        result=[]
        #if travelling bfs, need queue to store, the while loop and the 
        #levels is in the for loop after measuring the size of the queue

        queue=deque([])
        queue.append(root)
        while queue:
            size= len(queue)
            #that is each level's length
            #we need last elem of each level
            result.append(queue[-1].val)
            
            #building the queue
            for i in range(0,size):
                curr= queue.popleft()
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)       

        return result