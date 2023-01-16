# BFS - TC  & SC - O(n)
# Time Complexity : O(n) where n is the number of nodes in the tree Space used by the code is reduced because we are not creating a new queue for every level
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if (root == None): 
            return None
        q = deque()
        q.append(root)

        res = []

        while (q):
            temp = len(q) #all ele in particular level
            tempq = [] #nodes present in that level
            
            for i in range(temp):
                curr = q.popleft()
                tempq.append(curr.val)
                
                if (curr.left != None) :
                    q.append(curr.left)
                
                if curr.right != None:
                    q.append(curr.right)
            res.append(tempq[-1]) # Append the values of that level to the result
        return res

        

# DFS - TC O(n) & SC O(h)  
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:         
        res = []
        if root == None:
            return res
        self.dfs(root,0,res)
        return res

    def dfs(self,root,depth,res):
        if root == None:
            return 

        if depth == len(res):
            res.append(root.val)
        self.dfs(root.right,depth +1, res)
        self.dfs(root.left, depth +1, res)
        