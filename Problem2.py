# LEETCODE PROBLEM 993 COUSINS IN BINARY TREE
# TIME COMPLEXITY: O(N) where N is the number of nodes present 
# SPACE COMPLEXITY: O(N) due to the queue and parent dictionary holding nodes level by level



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q=deque()
        q.append(root)
        while q:
            parent={}
            n=len(q)
            for _ in range(n):
                node=q.popleft()
                if node:
                    if node.left:
                        parent[node.left.val]=node
                        q.append(node.left)
                    if node.right:
                        parent[node.right.val]=node
                        q.append(node.right)
            if x in parent and y in parent:
                if parent[x]!=parent[y]:
                    return True
                else:
                    return False
        return False