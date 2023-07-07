# Time Complexity : O(n)
# Space Complexity : O(n)
# The code ran on LeetCode
# While adding elements to the queue, check if x and y belong to the same parent. If they dont have the same parent and the flags turn to true at the same level, they are cousins and we can return True

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        queue = deque()
        queue.append((root, -1))
        xFlag = False; yFlag = False
        while queue:
            size = len(queue)
            for _ in range(size):
                cur, parent = queue.popleft()
                if cur.val == x:
                    xFlag = True
                    x_parent = parent
                if cur.val == y:
                    yFlag = True
                    y_parent = parent
                if cur.left:
                    queue.append((cur.left, cur.val))
                if cur.right:
                    queue.append((cur.right, cur.val))
            if xFlag and yFlag:
                if x_parent != y_parent:
                    return True
                else:
                    return False
            if xFlag or yFlag:
                return False
        return True