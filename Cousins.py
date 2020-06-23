---------------------------------- Cousins Iterative ---------------------------------------------
# Time Complexity : O(N) N is the nodes
# Space Complexity : O(N/2) ~ O(N) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here we can iterate through the binary tree and maintain a depth of the node as well as parent of the node. when ever the node value equals to x,
# we can assign levelx and parentx and same for y. Once we have levelx and levely, we can check weather they are equal or not 
# and then check parents are not equal. If this conditions satisfies, we can return True else False


class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root:
            return False
        
        queue = collections.deque([(root, 1, None)])
        levelx = 0
        levely = 0
        parentx = None
        parenty = None
        
        while queue:
            curr, level, parent = queue.popleft()
            if curr.val == x:
                levelx = level
                parentx = parent
            
            if curr.val == y:
                levely = level
                parenty = parent
            
            if levelx and levely:
                if levelx == levely and parentx != parenty:
                    return True
                else:
                    False
            
            if curr.left:
                queue.append((curr.left, level+1, curr))
            if curr.right:
                queue.append((curr.right, level+1, curr))
                
                
---------------------------------- Cousins Recursive ---------------------------------------------
# Time Complexity : O(N) N is the nodes
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here we can iterate through the binary tree and maintain a depth of the node as well as parent of the node.
# We can also maintain global variables of levelx, parentx and levely and parenty. when ever the node value equals to x,
# we can assign levelx and parentx and same for y. Once we have levelx and levely, we can check weather they are equal or not 
# and then check parents are not equal. If this conditions satisfies, we can return True else False
               
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root:
            return False
        
        self.levelx = 0
        self.levely = 0
        parentx = None
        parenty = None
        self.cousins = False
        def dfs(root, level, parent):
            if root.val == x:
                self.levelx = level
                self.parentx = parent
                
            if root.val == y:
                self.levely = level
                self.parenty = parent
                
            if self.levelx and self.levely:    
                if self.levelx == self.levely and self.parentx != self.parenty:
                    self.cousins = True
                else:
                    self.cousins = False
            
            if root.left:
                dfs(root.left, level+1, root)
            if root.right:
                dfs(root.right, level+1, root)
        
        dfs(root, 1, None)
        return self.cousins