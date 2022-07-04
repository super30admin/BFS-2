#Time Complexity: O(n)
#Space Complexity: recursive stack space O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#DFS
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.li=[]
        self.dfs(root,0)
        return self.li
    def dfs(self,root,level):
        if root==None:
            return
        if len(self.li)==level:
            self.li.append(root.val)    
        self.dfs(root.right,level+1)
        self.dfs(root.left,level+1)

#DFS from left side where we are replacing the left value with the right
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.result=[]
        self.dfs(root,0)
        return self.result
    def dfs(self,root,level):
        if root==None:
            return
        if len(self.result)<=level:
            self.result.append(root.val)
        else:
            self.result[level]=root.val
        self.dfs(root.left,level+1)
        self.dfs(root.right,level+1)
            

# BFS
# Time Complexity:O(n)
#Space Complexity:O(n)

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.result=[]
        if root==None:
            return self.result
        q=deque()
        q.append(root)
        while q:
            size=len(q)
            for i in range(size):
                curr=q.popleft()
                if i==size-1:
                    self.result.append(curr.val)
                if curr.left!=None:
                    q.append(curr.left)
                if curr.right!=None:
                    q.append(curr.right)
        return self.result
            
        