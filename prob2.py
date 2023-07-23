# Time Complexity : O(n)
# Space Complexity :O(h)
# Passed on Leetcode: yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import queue
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = queue.Queue()

        if root is None:
            return
        
        if root.val == x or root.val == y:
            return False

        q.put(root)
        hashmap = {}
        while not q.empty():
            flag = 0
            for i in range(q.qsize()):
                data = q.get()
                if data.left:
                    q.put(data.left)
                    hashmap[data.left] = data
                if data.right:
                    q.put(data.right)
                    hashmap[data.right] = data
                if data.val == x:
                    flag += 1
                    x_root = hashmap[data]
                if data.val == y:
                    flag += 1
                    y_root = hashmap[data]
                
            if flag == 2 and (x_root != y_root):
                return True
        return False