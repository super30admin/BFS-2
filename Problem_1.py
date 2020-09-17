
# 993. Cousins in Binary Tree


# Code: BFS
# store all the node's depth and parent. Then check if depth of x and y are same with different parents or not.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root:
            return False
        
        q = collections.deque([(root, 0, 0)])
        
        nodes = collections.defaultdict(list)
        
        while q:
            curr, depth, parent = q.popleft()
            nodes[curr.val] = [depth, parent]
            if curr.left:
                q.append((curr.left, depth+1, curr.val))
            if curr.right:
                q.append((curr.right, depth+1, curr.val))
        
        
        if nodes[x][0]==nodes[y][0] and nodes[x][1]!=nodes[y][1]:
            return True
        
        return False

# Time Complexity: O(V+E)
# Space Complexity: O(V+E)
# Accepted on Leetcode: Yes.