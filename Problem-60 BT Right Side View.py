# 199. Binary Tree Right Side View
# https://leetcode.com/problems/binary-tree-right-side-view/

# Time Complexiety: O(n)
# Space Complexiety: O(n)

# Logic: We will use a queue to traverse the BT in level-order. 
# Add each element along with the level in the queue. 
# We update the result array everytime we see an element for a level. 
# We do so because we only need the last element of a particular level in the answer.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        # Base Case
        if not root:
            return []
        
        q = [(root,0)]
        res = []
        
        while q:
            node,lvl = q.pop(0)
            
            if len(res) <= lvl:
                res.append(node.val)
            else:
                res[lvl] = node.val
            
            if node.left:
                q.append((node.left,lvl+1))
            
            if node.right:
                q.append((node.right,lvl+1))

        return res