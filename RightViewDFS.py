#Time Complexity:O(n)
#Space Complexity:O(h)
#Check if the element exists at particular height, if exists skip else add to the output list
#Traversing root and then left

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    global output
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.output=[]
        self.DFS(root,0)
        return self.output

    def DFS(self, root, depth):
        if root is None:
            return
        if depth>=len(self.output):
            self.output.append(root.val)
        self.DFS(root.right,depth+1)
        self.DFS(root.left,depth+1)