'''
Time Complexity: O(n)
Space Complexity: O(n)
'''
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        s = deque([])
        xfound = False
        yfound = False
        if(root):
            s.append(root)
        while(len(s)>0):
            temp = deque([])
            while(len(s)>0):
                val = s.popleft()
                #print(val.val)
                if(val.val == x):
                    xfound = True
                if(val.val == y):
                    yfound = True
                if(val.left and val.right and ((val.left.val == x and val.right.val == y) or (val.left.val == y and val.right.val == x))):
                    return False
                if(val.left):
                    temp.append(val.left)
                if(val.right):
                    temp.append(val.right)
            # print(xfound)
            # print(yfound)
            # print("______________")
            s = temp
            if(xfound != yfound):
                return False
        return True

        