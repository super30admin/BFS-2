# DFS - Recursive approach : DFS to store the parent and level and once root is null then returned the value
# TC - O(n) & SC 0 O(h)
class Solution:
    x_parent = None
    y_parent = None
    x_depth = None 
    y_depth = None
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.x_parent = None
        self.y_parent = None
        self.x_depth = None 
        self.y_depth = None

        if root == None:
            return False
        self.dfs(root,x,y,0,None)
        if self.x_parent != self.y_parent and self.x_depth == self.y_depth:
            return True
        return False
    def dfs(self,root,x,y,depth,parent):
        #base
        if root == None:
            return
        
        #logic
        if root.val == x:
            self.x_parent = parent
            self.x_depth = depth
        if root.val == y:
            self.y_parent = parent
            self.y_depth = depth
        self.dfs(root.left,x,y,depth+1,root)
        self.dfs(root.right,x,y,depth+1,root)

#BFS approach
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = deque()
        q.append(root)
        while q:
            size = len(q)
            x_found = False
            y_found = False
            for i in range(0,size):
                curr = q.popleft()
                if curr.val == x:
                    x_found = True
                if curr.val == y:
                    y_found = True

                if curr.left != None and curr.right != None:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.left.val == y and curr.right.val == x:
                        return False
                if curr.left != None:
                    q.append(curr.left)
                if curr.right != None:
                    q.append(curr.right)
            if x_found and y_found:
                return True
            if x_found or y_found:
                return False
        return True
    
#S30 python solution
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        queue = deque()
        queue.append(root)
        while len(queue) > 0:
            parentset = set()
            q_size = len(queue)
            for i in range(q_size):
                node = queue.popleft()
                if node.left != None and (node.left.val == x or node.left.val == y):
                       parentset.add(node.val)

                if node.right != None and (node.right.val == x or node.right.val == y):
                       parentset.add(node.val)

                if node.left != None:
                    queue.append(node.left)

                if node.right != None:
                    queue.append(node.right)

            if len(parentset) == 2:
                return True

        return False
