# TC-O(n)
# SC-O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root==None:
            return []
        q=deque()
        result=[]
        q.append(root)
        while(q):
            sz=len(q)
            for i in range(sz):
                ele=q.popleft()
                if ele.left:
                    q.append(ele.left)
                if ele.right:
                    q.append(ele.right)
            result.append(ele.val)
        return result