# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# All TC passed on leetocde

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:

        #DFS appraoch starting right side
        #Time complexity - O(n)
        #Space cpmplexity - o(h) where h is height of tree
        if not root:
            return []
        self.res = []

        def helper(root, level):
            if not root:
                return
            if level == len(self.res):
                self.res.append(root.val)
            helper(root.right, level+1)
            helper(root.left, level+1)
        
        helper(root, 0)
        return self.res

#-------------------------------------OR----------------------------------------

        #DFS approach starting left side
        #Time complexity - O(n)
        #Space cpmplexity - o(h) where h is height of tree
        if not root:
            return []
        self.res = []

        def helper(root, level):
            if not root:
                return
            
            if level == len(self.res):
                self.res.append(root.val)
            else:
                self.res[level] = root.val
            helper(root.left, level+1)
            helper(root.right, level+1)
        
        helper(root, 0)
        return self.res

#-------------------------------------OR----------------------------------------

        #BFS approach
        #Time complexity - O(n)
        #Space cpmplexity - o(n) max size queue can reach is n/2 leaf nodes
        if not root:
            return []
        res = []
        queue = collections.deque()
        queue.append(root)
        while queue:
            res.append(queue[-1].val)
            for i in range(len(queue)):
                cur = queue.popleft()

                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)
        return res
            
        