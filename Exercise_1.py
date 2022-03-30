# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

    #DFS
    # Time Complexity : O(N)
    # Space Complexity : O(N)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root == None:
            return None
        result = []
        def helper(root, level):
            # base case
            if root == None:
                return
         
            # logic
            if len(result)==level:
                result.append(root.val)
            else:
                result[level] = root.val
                
            
            helper(root.left, level+1)
            helper(root.right, level+1)
            
            
            
        helper(root, 0)
        return (result)


    # BFS
    # Time Complexity : O(N)
    # Space Complexity : O(N)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No

class Solution(object):
    
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        q=[root]
        result = []
        
        while(q):
            size = len(q)
            for i in range(len(q)):
                curr=q.pop(0)
                if i == size-1:
                    result.append(curr.val)
                
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                
        return(result)