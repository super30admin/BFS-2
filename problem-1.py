# Leetcode Execution: YES
# TimeComplexity:O(n)
# Space Complexity:O(n) 



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # def __init__(self):
    #     self.level=0
    #     self.result=[]
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        # pretty staright forward, we loop through the given tree as  bfs and add only the last element of the level to the result and then return result
        if root==None:
            return
        result=[]
        queue=[root]
        count=1
        while(queue):
            node=None
            while(count>0):
                
                node=queue.pop(0)
                
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
                count-=1
            count=len(queue)
            result.append(node.val)
        return result
                    