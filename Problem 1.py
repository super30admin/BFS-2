# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Iterative Recursive Time: O(n)
# Iterative Recursive Time: O(n) # If we include recursive stack while doing the recursion.
class Solution(object):
    def __init__(self):
        self.arr = []
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root == None:
            return []
        q = []
        q.append(root)
        size = 0
        ans = []
        while len(q) != 0:
            size = len(q)
            curr = None
            for i in range(size):
                curr = q.pop(0)
                if curr.left != None:
                    q.append(curr.left)
                if curr.right != None:
                    q.append(curr.right)
            ans.append(curr.val)
        return ans
            
                    
                
            
    def helper(self, root, level):
        if root == None:
            return
        if len(self.arr) <= level:
            self.arr.append(root.val)
        if root.right != None:
            self.helper(root.right, level+1)
        if root.left != None:
            self.helper(root.left, level+1)
        return
        
        
