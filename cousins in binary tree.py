# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import defaultdict
class Solution:

    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:

        # Queue for BFS
        queue = collections.deque([root])

        while queue:

            siblings = False
            cousins = False
            nodes_at_depth = len(queue)
            for _ in range(nodes_at_depth):

                # FIFO
                node = queue.popleft()     

                if node is None:
                    siblings = False
                else:
                    if node.val == x or node.val == y:
                
                        if not cousins:
                            siblings, cousins = True, True
                        else:

                            return not siblings

                    queue.append(node.left) if node.left else None
                    queue.append(node.right) if node.right else None
                    # Adding the null marker for the siblings
                    queue.append(None)
         
            if cousins:
                return False

        return False
# Time - O(N)
#Space - O(N)