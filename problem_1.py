# BFS 
# Time Complexity - O(n)
# Space Complexity - O(H)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        result = []
        q = []
        q.append(root)

        while len(q) > 0 : 
            size = len(q)           
            for i in range(size):
                curr = q.pop(0)
                if i == size-1 : 
                    result.append(curr.val)
                if curr.left :
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)

        return result


# DFS right approach 
# Time Complexity - O(n)
# Space Complexity - O(H)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.result = []
        self.helper(root,0)
        return self.result 

    def helper(self,root,level):
        if not root:
            return 

        if len(self.result) == level:
            self.result.append(root.val)
        self.helper(root.right,level+1)
        self.helper(root.left,level+1)


# DFS left and replacing approach 
# Time Complexity - O(n)
# Space Complexity - O(H)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.result = []
        self.helper(root,0)
        return self.result 

    def helper(self,root,level):
        if not root:
            return 

        if len(self.result) == level:
            self.result.append(root.val)

        else :
            self.result[level] = root.val
        self.helper(root.left,level+1)
        self.helper(root.right,level+1)

