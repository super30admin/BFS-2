#199. Binary Tree Right Side View
"""
Time Complexity : O(n)
Space Complexity : O(n)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        #null
        if root == None:
            return []
        
        #logic
        q = deque()
        q.append(root)
        result = []
        
        while q :
            size = len(q)
            #print(size)
            for i in range(0, size) :
                n = q.popleft()
                
                if i == size - 1: #just checking for last node in queue
                    result.append(n.val)
                    
                if n.left != None :
                    q.append(n.left)
                
                if n.right != None :
                    q.append(n.right)
                    
        #print(result)
        return result
