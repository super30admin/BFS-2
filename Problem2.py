"""
I implemented this using BFS with two parallel queues — one to keep track of nodes and another for their parents. At each level, I check if both x and y are present. If they're found and have different parents, it means they're cousins, so I return True.
If only one is found, they're on different levels, so I return False.
Time Complexity: O(n)
Space Compelxity: O(n)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return []
        queue = deque([root])
        parentQueue = deque([None])
        while queue:
            size = len(queue)
            xFound = False
            yFound = False
            xParent = None
            yParent = None
            for i in range(size):
                curr = queue.popleft()
                parentCurr = parentQueue.popleft()
                if curr.val == x:
                    xFound = True
                    xParent = parentCurr
                if curr.val == y:
                    yFound = True
                    yParent = parentCurr
                if curr.left:
                    queue.append(curr.left)
                    parentQueue.append(curr)
                if curr.right:
                    queue.append(curr.right)
                    parentQueue.append(curr)
            if xFound and yFound:
                return xParent != yParent
            if xFound or yFound:
                return False
        return False