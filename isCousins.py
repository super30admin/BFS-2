# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time Complexity: O(n)
#Space Complexity:O(h)-recursive stack
# Leetcode:yes

#DFS Solution:

# Algorithm:
# 1. Create global varibale depth and parent. 
# 2. Check if the x and y values given macth the root we are operating on, else move to their children by increasing the depth. If the match is found update parent and depth.
# 3. return truew if the depth matches and parents do not match
class Solution:

    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        self.dfs(root, x, 0, 0)
        x_depth = depth_res
        x_parent = parent_res
        self.dfs(root, y, 0, 0)
        return x_depth == depth_res and x_parent != parent_res
        
    def dfs(self,root, value, depth, parent):
            if not root: return
            if root.val == value:
                global depth_res
                global parent_res
                depth_res = depth
                parent_res = parent
                return
           
            self.dfs(root.left, value, depth+1, root.val)
            self.dfs(root.right, value, depth+1, root.val)
        
# BFS Solution:
class Solution:

    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        # if not root:
        #     return False
       
        q=[root]
        while q:
            x_found=False
            y_found=False
            for i in range(len(q)):
                curr=q.pop(0)
                if curr.val==x:
                    x_found=True
                if curr.val==y:
                    y_found=True
                if curr.left and curr.right:
                    if (curr.left.val==x and curr.right.val==y):
                        return False
                    if (curr.right.val==x and curr.left.val==y):
                        return False
                if curr.right:
                    q.append(curr.right)
                if curr.left:
                    q.append(curr.left)
            if x_found and y_found:
                return True
        return False
                
        
