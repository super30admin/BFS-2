# // Time Complexity :O(N)
# // Space Complexity : O(D) --> leaf nodes for BFS, O(H)--> height for DFS
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

##we do a normal level order traversal and if come across a node whose vsalue matches with x or y with update the found and parent
## in the end of level we check if xfound and yfound and then compare their parents
class solution:
    def cousinsBFS(self, root, x,y):

        queue = collections.deque()

        queue.append(root, None)

        while queue:
            qsize = len(queue)
            x_found = False
            y_found = False
            x_parent = None
            y_parent = None
            for i in range(qsize):
                curr_node, parent = queue.popleft()

                if curr_node.val == x:
                    x_found = True
                    x_parent = parent
                if curr_node.val == y:
                    y_found = True
                    y_parent = parent
                
                if curr_node.left:
                    queue.append([curr_node.left, curr_node])
                    queue.append([curr_node.right, curr_node])
                
            if x_found and y_found:
                return x_parent != y_parent

            if x_found or y_found:
                return False

        return False    
## here we do the bfs without considering the parents. so instead of calculating the validity and parents after putting them in the queue
## we will check if they are not cousins and return 
    def cousinsBFS_without_parent(self, root, x, y):

        queue = collections.deque()
        queue.append(root)

        while queue:
            qsize = len(queue)
            x_found = False
            y_found = False

            for i in range(qsize):
                curr = queue.popleft()

                if curr.val == x:
                    xfound = True
                
                if curr.val ==y:
                    yfound = True
                
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
            if x_found or y_found: return False
        
        return False
## In dfs we maintain a the depth along with parents. at the end of the dfs we see if depth is same and parents are different.
    def cousinsDFS(self, root, x, y):
        self.x_parent = None
        self.y_parent = None
        self.x_depth = -1
        self.y_depth =-2
        self.helper(root,x,y,0,None)
        return self.x_depth == self.y_depth and self.y_parent == self.x_parent
    def helper(self, root, x,y, depth, parent):
        ## base
        if root ==None: return
        ##logic

        if root.val == x:
            self.x_depth = depth
            self.x_parent = parent
        if root.val == y:
            self.y_depth=depth
            self.y_parent = parent
        
        if self.x_parent == None or self.y_parent == None:
            self.helper(root.left,x,y,depth+1, root)
        if self.x_parent == None or self.y_parent == None:
            self.helper(root.right, x, y, depth+1, root)
        



