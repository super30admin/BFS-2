# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#DFS 
#TC: O(N) , n is nodes in Btree
#SC: O(N)
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
            
        self.parent_x = None
        self.parent_y = None
        self.depth_x, self.depth_y = 0,0
        
        def dfs(root, parent, x, y, depth):
            #base
            if root is None:
                return
            #logic
            if root.val == x:
                self.parent_x = parent
                self.depth_x = depth
                
            if root.val == y:
                self.parent_y = parent
                self.depth_y = depth
                
            if not self.parent_x or not self.parent_y:
                dfs(root.left,root, x, y, depth+1)
            if not self.parent_x or not self.parent_y:
                dfs(root.right,root, x, y, depth+1)
            
        dfs(root, None,x, y, 0)
        return self.parent_x != self.parent_y and self.depth_x == self.depth_y

#BFS 
#TC: O(N) , n is nodes in Btree
#SC: O(N)    
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        q = deque()
        pq = deque()
        
        q.append(root)
        pq.append(None)
        
        while q:
            size = len(q)
            x_found = False
            y_found = False
            parent_x = None
            parent_y = None
            
            for i in range(0, size):
                curr = q.popleft()
                currP = pq.popleft()
                
                if curr.val == x:
                    x_found = True
                    parent_x = currP
                  
                if curr.val == y:
                    y_found = True
                    parent_y = currP
                    
                if curr.left:
                    q.append(curr.left)
                    pq.append(curr)
                    
                if curr.right:
                    q.append(curr.right)
                    pq.append(curr)
                    
            if x_found and y_found:
                return parent_x != parent_y
            
        
            