'''
    Time Complexity: O(n)
    Space Complexity: O(n/2)
    Approach: BFS and check for conditions: Same level, different parents.
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        queue = deque()
        queue.append((root, None))
        size = len(queue)
        xFound = yFound = False
        xParent = yParent = None

        while len(queue):
            for i in range(size):
                node = queue.popleft()
                child = node[0]
                parent = node[1]

                if child.val == x:
                    xFound = True
                    xParent = parent

                elif child.val == y:
                    yFound = True
                    yParent = parent

                if child.left:
                    queue.append((child.left, child))

                if child.right:
                    queue.append((child.right, child))

            size = len(queue)    
            if xFound and yFound:
                if xParent != yParent:
                    return True
                else:
                    return False
            elif xFound or yFound:
                return False

        return False

        