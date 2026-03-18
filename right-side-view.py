# https://leetcode.com/problems/binary-tree-right-side-view/description/

# Time Complexity: O(n)
# Space Complexity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        q = deque()
        res = []

        if root is None:
            return []
        
        q.append(root)

        while q:
            size = len(q)
            print(size)

            for i in range(size):
                qroot = q.popleft()

                # if i == size - 1:
                #     res.append(qroot.val)
            
                if qroot.left is not None:
                    q.append(qroot.left)

                if qroot.right is not None:
                    q.append(qroot.right)

                if i == size - 1:
                    res.append(qroot.val)

        return res