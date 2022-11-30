# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        ## BFS Solution:
        ## T.C = O(n)
        ## S.C = O(h)
        
        q = [root]
        x_found = False
        y_found = False
        
        while q:
            
            for i in range(len(q)):
                root = q.pop(0)
                if root.val == x:
                    x_found = True
                if root.val == y:
                    y_found = True
                if root.left and root.right:
                    if root.left.val == x and root.right.val == y:
                        return False
                    if root.left.val == y and root.right.val == x:
                        return False
                if root.left:
                    q.append(root.left)
                if root.right:
                    q.append(root.right)
                    
            if x_found and y_found:
                return True
            if x_found or y_found:
                return False
        
        
        ##########################################
        ## DFS Solution:
        ## T.C = O(n)
        ## S.C = O(h)
        
        parents = []
        x_y_lvl = []
        
        def dfs(root, parent, lvl):
            if not root:
                return
            
            if root.val == x:
                parents.append(parent)
                x_y_lvl.append(lvl)
            
            if root.val == y:
                parents.append(parent)
                x_y_lvl.append(lvl)
            
            if len(parents)<2:
                dfs(root.left, root, lvl + 1)
                dfs(root.right, root, lvl + 1)
        
        dfs(root, None, 0)
        
        return x_y_lvl[0] == x_y_lvl[1] and parents[0].val != parents[1].val
        