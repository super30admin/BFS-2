# Time Complexity : O(n) 
# Space Complexity : O(n) 
# where n is the number of nodes in the tree



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
     # bfs solution
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        queue = deque([root])
        while queue:
            size = len(queue)
            x_flag = False
            y_flag = False
            for i in range(size):
                ele = queue.popleft()
                if ele.val == x:
                    x_flag = True
                if ele.val == y:
                    y_flag = True
                if ele.left is not None and ele.right is not None:
                    if ele.left.val == x and ele.right.val == y:
                        return False
                    if ele.left.val == y and ele.right.val == x:
                        return False
                if ele.left is not None:
                    queue.append(ele.left)
                if ele.right is not None:
                    queue.append(ele.right)
                
            if x_flag and y_flag:
                return True
            if x_flag or y_flag:
                return False
        return False

 # Dfs solution
class Solution:
    def __init__(self):
            self.x_parent = TreeNode()
            self.y_parent = TreeNode()
            self.xLevel = 0
            self.yLevel = 0
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        
        self.dfs(root, None, 0, x, y)
        return (self.x_parent != self.y_parent and self.xLevel == self.yLevel)
                
        
    def dfs(self,root, parent,level,x,y):
            
            if root == None:
                return
            if root.val == x:
                self.x_parent = parent
               
                self.xLevel = level
                
            if root.val == y:
                self.y_parent = parent
                self.yLevel = level
                
            self.dfs(root.left, root,level+1,x,y)
            self.dfs(root.right,root, level+1,x,y)