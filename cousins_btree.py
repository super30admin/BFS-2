"""
// Time Complexity : O(n) 
// Space Complexity : O(maxDepth)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
Algorithm explanation
Method1 - DFS
- Idea is to update the depth and parent if the root.val matches x
and similarly for y
- Return true if depths are same and parents are different

Method2 - BFS
- Add the (root,parent,level) to queue with the start 
- Use the size based mechanism to track the level 
- update the level and parent of x and y if the root.val matches x and y 
- Return true if depths are same and parents are different
"""
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        #Method1 - DFS with using depth and parent pointers
        self.parent_x = None
        self.parent_y = None
        self.depth_x = None
        self.depth_y = None
        
        
        def dfs(root,x,y,parent,depth):
            if not root:
                return
            
            if root.val == x and not self.parent_x:
                self.depth_x = depth
                self.parent_x = parent
            
            if root.val == y and not self.parent_y:
                self.depth_y = depth
                self.parent_y = parent
            dfs(root.left,x,y,root,depth+1)
            dfs(root.right,x,y,root,depth+1)

        dfs(root,x,y,None,0)
        if self.depth_x == self.depth_y and self.parent_x != self.parent_y:
            return True
        return False
        
        #Method2 - BFS with only tracking parent
        def bfs(root,x,y):
            queue = [(root,None,0)]
            parent_x = None
            parent_y = None
            depth_x = -1
            depth_y = -1
            while queue:
                size = len(queue)
                for i in range(size):
                    root,parent,level = queue.pop(0)
                    if root.val == x and not parent_x:
                        parent_x = parent
                        depth_x = level
                    
                    if root.val == y and not parent_y:
                        parent_y = parent
                        depth_y = level
                    
                    if root.left:
                        queue.append((root.left,root,level+1))
                    
                    if root.right:
                        queue.append((root.right,root,level+1))
            return True if depth_x == depth_y and parent_x != parent_y else False
        
        return bfs(root,x,y)