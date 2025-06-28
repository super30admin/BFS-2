# approach using hashmap 

# approach using parallel queues

# approach using tuples 

# approach using parent filtering with BFS 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:

        queue = deque()

        if root:
            if root.left:
                queue.append((root, root.left))
            if root.right:
                queue.append((root, root.right))

        while queue:
            size = len(queue)
            level = []
            while size > 0:
                parent, node = queue.popleft()
                level.append((parent.val, node.val))
                if node.left:
                    queue.append((node, node.left))
                if node.right:
                    queue.append((node, node.right))
                size -= 1
            res = []
            for parent, node in level:
                if node == x or node == y:
                    res.append((parent, node))
            if len(res) == 2:
                if res[0][0] != res[1][0]:
                    return True

        return False
