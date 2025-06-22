# Problem 1

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root == None:
            return []
        myres = []

        myq = deque()
        myq.append(root)

        while myq:
            n = len(myq)
            for i in range(n):
                elem = myq.popleft()
                if i == n-1:
                    myres.append(elem.val)
                if elem.left:
                    myq.append(elem.left)

                if elem.right:
                    myq.append(elem.right)
        return myres



# Problem 2

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:

        if root == None:
            return False
        myx = False
        myy = False

        myq = deque()
        myq.append([root,None])

        while myq:
            p1 = None
            p2 = None
            for i in range(len(myq)):
                elem = myq.popleft()

                if elem[0].val == x:
                    myx = True
                    p1 = elem[1]
                elif elem[0].val == y:
                    myy = True
                    p2 = elem[1]
                if elem[0].left: 
                    myq.append([elem[0].left,elem[0]])
                if elem[0].right:
                    myq.append([elem[0].right,elem[0]])
            if myx and myy:
                return True if p1 != p2 else False
            elif myx or myy:
                return False
        return False






        
            
