# // Time Complexity :O(N) we would have to visit each node for BFS and DFS
# // Space Complexity : O(D) --> leaf nodes for BFS, O(H)--> height for DFS
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
## In BFS solution we addpend each level to our queue but we only add the last element in the level to our result as 
## that will be the rightmost element.
class solution:
    def bfs(self, root):
        res = []

        queue=collections.deque()

        queue.append(root)

        while queue:

            qsize = len(queue)
            for i in range(qsize):
                curr = queue.pop()

                if i == qsize-1:
                    res.append(curr)
                
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
        
        return res
## In DFS however we need to go deep in the branch, so in the first way what we do is instead of branching to left first
## we branch to right and if len of res == level of our node we append it . This way we make sure only right is going.
## in case we have to do left first then we amend the value in a particular level as we traverse through the tree.
    def dfs(self, root):
        self.res = []
        self.helper(root, 0)
        return self.res
    
    def helper(self, root, level):

        ##base
        if root == None:
            return 
        ##logic

        if len(self.res) == level:
            self.res.append(root.val)

        self.helper(root.right, level+1)

        self.helper(root.left, level+1)
    
    def helper_left_first(self,root, level):

        ## base
        if root == None:
            return

        ##logic
        if len(self.res) == level:
            self.res.append(root.val)
        else:
            self.res[level]= root.val
        self.helper_left_first(root.left, level+1)

        self.helper_left_first(root.right, level+1)
