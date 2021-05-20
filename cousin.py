# Definition for a binary tree node.
from collections import  deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:

        if root is None: return False
        levelqueue=deque()
        x_level,y_level=False,False
        levelqueue.append(root)

        while levelqueue.__len__()>0:
            size=levelqueue.__len__()
            for ids in range(size):
                node=levelqueue.popleft()
                if node.val==x: x_level=True
                if node.val==y: y_level=True
                if node.left is not None and node.right is not None:
                    if node.left.val==x and node.val.right==y: return False
                    if node.right.val==y and node.val.left==x: return False
                if node.left is not None: levelqueue.append(node.left)
                if node.right is not  None: levelqueue.append(node.right)
            if x_level and y_level: return True
            if x_level or y_level: return False
        return False









if __name__ == '__main__':
    print(Solution().isCousins(root = [1,2,3,4], x = 4, y = 3))
