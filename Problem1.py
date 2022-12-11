#Time Complexity :- O(n)
#Space Complexity :- O(h)

#Solution 1  using dfs :- 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = []
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.result = []
        if root is None:
            return self.result
        self.dfs(root, 0)
        return self.result
    
    def dfs(self, root, lvl):
        if root is None:
            return
        if lvl == len(self.result):
            self.result.append(root.val)
        self.dfs(root.right, lvl+1)
        self.dfs(root.left, lvl+1)


#Solution 2 : Using BFS 

#Time Complexity :- O(n)
#Space Complexity :- O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    arrayData = []
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        arrayData = []
        rightData = []
        if root is None:
            return 
        arrayData.append(root)
        while len(arrayData) > 0:
            size = len(arrayData)
            rightData.append(arrayData[size-1].val)
            for i in range(size):
                root = arrayData.pop(0)
                if root  and root.left is not None:
                    arrayData.append(root.left)
                if root and root.right is not None:
                    arrayData.append(root.right)
        return rightData