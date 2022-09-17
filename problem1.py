'''
199. Binary Tree Right Side View

APPROACH 1: DFS
TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(h)
LEETCODE: Yes
DIFFICULTIES: Nope. After the class

APPROACH 2: BFS
TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(N)
LEETCODE: Yes
DIFFICULTIES: Nope. After the class


'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        if root == None:
            return []
        if root.left == None and root.right == None:
            return [root.val]
        
        # DFS
        global dfs_res
        dfs_res = []
        def approach1(root, ht):
            global dfs_res
            
            if root == None:
                return 
            if len(dfs_res) == ht:
                dfs_res.append(root.val)
            elif len(dfs_res) > ht:
                dfs_res[ht] = root.val
            else:
                print('error')
            approach1(root.left, ht+1)
            approach1(root.right, ht+1)
            
        
        # BFS 
        def approach2(root):
            q = deque()
            q.append(root)
            bfs_res = []
            
            while len(q) != 0:
                q_size = len(q)
                for i in range(0, q_size):
                    node = q.popleft()
                    if node.left != None:
                        q.append(node.left)
                    if node.right != None:
                        q.append(node.right)
                    if q_size-1 == i:
                        bfs_res.append(node.val)
            return bfs_res
        
        # approach1(root, 0)
        # return dfs_res
        return approach2(root)
        
        
