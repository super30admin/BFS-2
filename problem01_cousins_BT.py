# https://leetcode.com/problems/cousins-in-binary-tree/submissions/838819958/

# Approach 1: BFS
# Time Complexity : O(n)
# Space Complexity : O(2n) = O(n) (since storing node and its parent)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import collections
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        result = []
        if root == None:
            return result

        q = collections.deque()
        q.append([root, 0])
        while(len(q) != 0):
            temp = []
            size = len(q)
            while(size>0):
                lst = q.popleft()
                node = lst[0]
                parent = lst[1]
                if(node.left != None):
                    q.append([node.left, node.val])
                if(node.right != None):
                    q.append([node.right, node.val])
                size-=1
                temp.append((node.val, parent))
            result.append(temp)
        
        l_x, l_y, p_x, p_y = 0, 0, 0, 0
        for i, level in enumerate(result):
            for tup in level:
                if tup[0] == x:
                    p_x = tup[1]
                    l_x = i
                elif tup[0] == y:
                    p_y = tup[1]
                    l_y = i
            if(p_y!=0 and p_x!= 0):
                break

        if l_x == l_y and p_x != p_y:
            return True
        else:
            return False


#approach 2: DFS
# Time Complexity : O(n) (since traversing each node in worst case)
# Space Complexity : O(n) (since creating a recursion can lead to visiting each node once)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.xparent = None
        self.yparent = None
        self.xlevel = None
        self.ylevel = None
    def dfs(self, node, level, parent, x, y):
        if(node == None):
            return
        
        if(node.val == x):
            self.xparent = parent
            self.xlevel = level
            return
        if(node.val == y):
            self.yparent = parent
            self.ylevel = level

        if(self.xparent != None and self.yparent != None):
            return
        
        self.dfs(node.left, level+1, node.val, x, y)
        self.dfs(node.right, level+1, node.val, x, y)
    
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if(root == None):
            return False
        
        self.dfs(root, 0, 0, x, y)
        print(self.xparent, self.xlevel)
        print(self.yparent, self.ylevel)

        if(self.xparent != None and self.yparent != None) and (self.xlevel == self.ylevel and self.xparent != self.yparent):
            return True
        else:
            return False
