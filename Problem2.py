# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name: Cousins in Binary Tree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        x_found = False
        y_found = False

        q = [root] # queue
        pq = [None]  # parent queue

        while q:
            size = len(q)
            for i in range(size):
                curr = q.pop(0)
                parent = pq.pop(0)

                if curr.val == x:
                    x_found = True
                    x_parent = parent
                if curr.val == y:
                    y_found = True
                    y_parent = parent
                if curr.left != None:
                    q.append(curr.left)
                    pq.append(curr)
                if curr.right != None:
                    q.append(curr.right)
                    pq.append(curr)

            if x_found and y_found:
                return x_parent != y_parent
            if x_found or y_found:
                return False
            
        return True


