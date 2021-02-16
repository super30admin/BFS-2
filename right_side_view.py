// Time Complexity: O(n)
// Space Complexity: O(max width of binary tree) due to level-order traversal
// Passed all test cases on Leetcode: Yes


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        
        if(root==None):
            return([])
        
        queue=[]
        res=[]
        queue.append(root)
        
        while(queue):
            size=len(queue)
            for i in range(size):
                popped=queue.pop(0)
                
                if(popped.left):
                    queue.append(popped.left)
                if(popped.right):
                    queue.append(popped.right)
                if(i==size-1):
                    res.append(popped.val)
        return(res)
                