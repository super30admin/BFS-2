from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result =[]
        self.helper(root,0,result)
        return result

    def helper(self,root,level,result):
        if root is None: return

        if level == len(result):
            result.append(root.val)
        else:
            result[level] = root.val
        self.helper(root.left,level+1,result)
        self.helper(root.right,level+1,result)

#BFS solution --------------------

from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []
        result =[]
        Qu = deque([root])

        while Qu:
            size = len(Qu)
            for i in range(size):
                curr = Qu.popleft()

                if i == size-1:
                    result.append(curr.val)
                if curr.left:
                    Qu.append(curr.left)
                if curr.right:
                    Qu.append(curr.right)
        return result

    
    


    

