#BFS Approach
# Time Complexity : O(n)
# Space Complexity : O(n)   #Initially it will be n/2 as width of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return
        q = deque()
        q.append(root)
        
        while q:
            size = len(q)
            x_found = False
            y_found = False
            for i in range(size):
                
                curr = q.popleft()
                
                if curr.val == x:
                    x_found = True
                if curr.val == y:
                    y_found = True
                if curr.left is not None and curr.right is not None:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.left.val == y and curr.right.val == x:
                        return False
                if curr.left is not None:
                    q.append(curr.left)
                if curr.right is not None:
                    q.append(curr.right)
                
            if x_found and y_found:
                return True
            if x_found or y_found:
                return False
        return False

                

#DFS Approach
# Time Complexity : O(n)
# Space Complexity : O(h);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.x_parent  = None
        self.y_parent = None
        self.x_depth = 0
        self.y_depth = 0
        

    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:   
        if root is None:
            return False
        self.dfs(root, x, y, 0, None)
        if self.x_depth == self.y_depth and self.x_parent != self.y_parent:
            return True
        else:
            return False
        
    def dfs(self, root, x, y, depth, parent):
        #base
        if not root:
            return
        #logic
        if root.val == x:
            self.x_parent = parent
            self.x_depth = depth
        if root.val == y:
            self.y_parent = parent
            self.y_depth = depth
        if root or root.left:     
            self.dfs(root.left, x, y, depth + 1, root)
        #st.pop()
        if root or root.right:
            self.dfs(root.right, x, y, depth + 1, root)
        #st.pop()
        
