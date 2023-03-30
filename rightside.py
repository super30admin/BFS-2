#TC-O(n)
#SC-O(n)
#logic-keep a global list and do dfs travel from left to right child,in every level
#check if len(list)==level,if yes append the current node to it else replace existing level node
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    global li
    li = []
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        global li
        li = []
        def dfs(root,level):
            global li
            if not root:
                return
            if level == len(li):
                li.append(root.val)
            else:
                li[level]=root.val
            dfs(root.left,level+1)
            dfs(root.right,level+1)
        dfs(root,0)
        return li

