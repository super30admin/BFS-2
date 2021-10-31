# TC-O(n)
# SC-O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        levelA = -1
        levelB = -1
        q = deque()
        q.append(root)
        level = 0
        parentA = -1
        parentB = -1
        while (q):
            sz = len(q)
            level += 1
            for i in range(sz):

                ele = q.popleft()
                if ele.left:
                    if ele.left.val == x:
                        levelA = level
                        parentA = ele.val
                    elif ele.left.val == y:
                        levelB = level
                        parentB = ele.val
                    q.append(ele.left)
                if ele.right:
                    if ele.right.val == x:
                        levelA = level
                        parentA = ele.val
                    elif ele.right.val == y:
                        levelB = level
                        parentB = ele.val
                    q.append(ele.right)
            print(levelA, levelB, parentA, parentB)
            if parentA != parentB:
                if levelA == levelB:
                    return True
        return False