# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    result = []
    def rightSideView(self, root): # DFS T.C->O(N), S.C->O(H)
        """
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """
        self.result = []
        self.dfs(root,0)
        return self.result
    
    def dfs(self,root,level):
        if(root == None): return

        if len(self.result) == level:
            self.result.append(root.val)
        else:
            self.result[level] = root.val
        
        self.dfs(root.left,level+1)
        self.dfs(root.right,level+1)
    
#bfs
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def rightSideView(self, root): # BFS T.C->O(N), S.C->O(N/2)
        """
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """
        result = []

        if root == None: return result
        queue = deque()
        queue.append(root)

        while len(queue) != 0:
            size = len(queue)

            for i in range(size):
                curr = queue.popleft()
                if i == (size - 1):
                    result.append(curr.val)
                if curr.left != None:
                    queue.append(curr.left)
                if curr.right != None:
                    queue.append(curr.right)
        return result
                