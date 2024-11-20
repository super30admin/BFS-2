#993. Cousins in Binary Tree
# Time Complexity : O(n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes
class Solution:
    x_parent = TreeNode
    y_parent = TreeNode
    x_depth = 0
    y_depth = 0
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root:
            return False
        self.dfs(root,None,0,x,y)
        return self.x_parent != self.y_parent and self.x_depth == self.y_depth
    def dfs(self,root,parent,depth,x,y):
        if not root:
            return
        if root.val == x:
            self.x_parent = parent
            self.x_depth = depth
        if root.val == y:
            self.y_parent = parent
            self.y_depth = depth
        self.dfs(root.left,root,depth+1,x,y)
        self.dfs(root.right,root,depth+1,x,y)

class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root:
            return False
        queue = []
        queue.append(root)
        while queue:
            size = len(queue)
            x_found = False
            y_found = False
            for i in range(size):
                curr = queue.pop(0)
                if curr.val == x:
                    x_found = True
                    #print(curr.val)
                if curr.val == y:
                    y_found = True
                     
                if curr.left and curr.right:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.left.val == y and curr.right.val == x:
                        return False
            if curr.left:
                queue.append(curr.left)
            if curr.right:
                queue.append(curr.right)
        if x_found and y_found:
            return True
        if x_found or y_found:
            return False
        return False