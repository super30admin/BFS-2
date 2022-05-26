# Time Complexity: O(N)
# Space Complexity: O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = list()
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.result = list()
        if root is None:
            return self.result
        
        q = list()
        q.append(root)
        while len(q) != 0:
            size = len(q)
            for i in range(size):
                curr = q.pop(0)
                if i == size-1:
                    self.result.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
        return self.result

#Using DFS - right and left

# Time Complexity: O(N)
# Space Complexity: O(H), height

#If we do right recursive then left, don't have to overwrite elements
#If we do left recursive then right, we have to overwrite elements because right elements comes later as we need the right side view of the tree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = list()
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.result = list()
        if root is None:
            return self.result
        self.dfs(root, 0)
        return self.result

    
    def dfs(self, root, level):
        if root is None:
            return
        
        if level == len(self.result):
            self.result.append(root.val)
        self.dfs(root.right, level+1)
        self.dfs(root.left, level+1)
        

#Using DFS - left and right

# Time Complexity: O(N)
# Space Complexity: O(H), height

#If we do right recursive then left, don't have to overwrite elements
#If we do left recursive then right, we have to overwrite elements because right elements comes later as we need the right side view of the tree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = list()
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.result = list()
        if root is None:
            return self.result
        self.dfs(root, 0)
        return self.result

    
    def dfs(self, root, level):
        if root is None:
            return
        
        if level == len(self.result):
            self.result.append(root.val)
        else:
            self.result[level] = root.val
        self.dfs(root.left, level+1)
        self.dfs(root.right, level+1)
        