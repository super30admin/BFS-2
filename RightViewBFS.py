#Time Complexity: O(n)
#Space Complexity: O(n)
#At height will have all the children at that particular level and it is from left to right
#So I have taken size-1

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    global output
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.output=[]
        q=collections.deque()
        if root:
            q.append(root)
        while q:
            size=len(q)
            for i in range(size):
                temp=q.popleft()
                if i ==size-1:
                    self.output.append(temp.val)
                if(temp.left):
                    q.append(temp.left)
                if(temp.right):
                    q.append(temp.right)
        return self.output