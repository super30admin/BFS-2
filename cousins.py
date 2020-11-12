# As taught in class I used BFS to find cousin node in a binary tree
# Time Complexity: O(n)
# Space Complexity: O(n)
import queue
class Node:
    def __init__(self,val):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def cousins(self,root,x,y):
        bfsq = queue.Queue()
        bfsq.put(root)
        while(len(bfsq)!=0):
            size = len(bfsq)
            xf = False
            yf = False
            for i in range(len(bfsq)):
                current  = bfsq.get()
                if current.val == x:
                    xf =  True
                if current.val == y:
                    yf =  True
                if (current.left is None and current.right is None):
                    return False
                    if (current.right.val == x and current.left.val == y) or (current.left.val == x and current.right.val == y):
                        return False
                if current.left is not None:
                    bfsq.put(current.left)
                if current.right is not None:
                    bfsq.put(current.right)
            if xf and yf:
                return True
        return False


n1 = Node(1)
n2 = Node(2)
n3 = Node(3)
n4 = Node(4)
n1.left = n2
n1.right = n3
n2.left = n4
s = Solution()
s.cousins(n1)