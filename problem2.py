'''
993. Cousins in Binary Tree

APPROACH: DFS
TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(H)
LEETCODE: Yes
DIFFICULTY: A bit. After the class

APPROACH: BFS
TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(N)
LEETCODE: Yes
DIFFICULTY: A bit. After the class

'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root.left == None and root.right == None:
            return False
        
        # DFS
        def approach1(root,x,y):
            global xh, yh, res
            xh, yh = -1, -1
            res = None

            def dfs(root, x, y, h):
                global xh, yh, res

                # base
                if res != None or root == None:
                    return
                if root != None and root.left != None and root.right != None:
                    if (root.left.val == x and root.right.val == y) or (root.left.val == y and root.right.val == x):
                        res = False
                        return


                # logic
                if root.val == x:
                    xh = h
                elif root.val == y:
                    yh = h

                if xh == yh and xh != -1:
                    res = True

                dfs(root.left, x, y, h+1)
                dfs(root.right, x, y, h+1)

            dfs(root, x, y, 0)
            if res == None:
                return False
            else:
                return res
        
        
        # BFS
        def approach2(root, x, y):
            q = deque()
            q.append(root)
            
            while len(q) != 0:
                qs = len(q)
                sset = {-1}
                for i in range(0, qs):
                    node = q.popleft()
                    lf, rt = None, None
                    
                    if node.left != None:
                        lf = node.left.val
                        q.append(node.left)
                        sset.add(lf)
                    if node.right != None:
                        rt = node.right.val
                        q.append(node.right)
                        sset.add(rt)
                    
                    # same children check
                    if ((x == lf and y == rt) or (y == lf and x == rt)) and lf != None:
                        return False
                
                if x in sset and y in sset:
                    return True
            
            return False
                    
        
        # return approach1(root,x,y)
        return approach2(root, x, y)
        
