# Time Complexity: O(N)
# Space Complexity: O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root is None:
            return False
        queue = list()
        queue.append(root)

        while len(queue)!=0:
            x_found = False
            y_found = False
            size = len(queue)
            for i in range(size):
                curr = queue.pop(0)
                if curr.val==x:
                    x_found = True
                if curr.val==y:
                    y_found = True

                if (curr.left!=None and curr.right!=None):
                    # if both are the children of current node=>they are not cousins
                    if curr.left.val==x and curr.right.val==y:
                        return False
                    if curr.left.val==y and curr.right.val==x:
                        return False

                if curr.left!=None:
                    queue.append(curr.left)
                if curr.right!=None:
                    queue.append(curr.right)
            # if at the end of each level both are found and they dont have the same parent then they are cousins
            # else if only one is found=> both don't lie on the same level=> not cousins
            if x_found and y_found:
                return True
            if x_found or y_found:
                return False

# Here we perform a DFS and check if both the elements found have the same level
# and dont have the same parent
    # DFS Solution
    # def __init__(self):
    #     self.x_parent = None
    #     self.x_lvl = None
    #     self.y_parent = None
    #     self.y_lvl = None
    # def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
    #     self.dfs(root,None,0,x,y)
    #     return (self.x_lvl==self.y_lvl and self.x_parent!=self.y_parent)

    # def dfs(self,root,parent,level,x,y):
    #     if root is None:
    #         return
    #     if root.val==x:
    #         self.x_parent = parent
    #         self.x_lvl = level
    #     if root.val==y:
    #         self.y_parent = parent
    #         self.y_lvl = level

    # it means that both have been found and further iterations are not needed
    #     if self.x_lvl!=None and self.y_lvl!=None:
    #         return

    #     self.dfs(root.left,root,level+1,x,y)
    #     if self.x_lvl!=None and self.y_lvl!=None:
    #         return
    #     self.dfs(root.right,root,level+1,x,y)
    #     if self.x_lvl!=None and self.y_lvl!=None:
    #         return False
