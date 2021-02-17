#TimeComplexity:O(N) 
#SpaceComplexity: O(max diameter of tree)
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        output=[]
        queue=[root] if root else [] #copy root else return None
        while(queue): 
            newqueue=[]     #create new list to store next level values and copy them to initial queue
            output.append(queue[-1].val) #since we are adding left first and right second the final value is the rightmose value
            for i in queue:
                if (i.left): newqueue.append(i.left)
                if (i.right): newqueue.append(i.right)
            queue=newqueue
        return output
            
        