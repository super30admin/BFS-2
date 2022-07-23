# Time Complexity : O(n) as visit every node 
# Space Complexity : O(D) diameter of the tree as BFS search do level order traversal
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:  
        
        q=collections.deque()        
        if not root:
            return []        
        q.append(root)  
        res=[]
        
        while q:         
            qlen=len(q)
            for i in range(qlen):
                node=q.popleft()
                if node:
                    right=node.val
                    if node.left:
                        q.append(node.left)
                    if node.right:
                        q.append(node.right)
            res.append(right)
        return res