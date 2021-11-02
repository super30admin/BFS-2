# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        temp = []
        temp.append(root)
        while len(temp) != 0:
            new_temp = []
            parent_dict = {}
            for head in temp:
                if head.left is not None:
                    new_temp.append(head.left)
                    parent_dict[head.left.val] = head
                if head.right is not None:
                    new_temp.append(head.right)
                    parent_dict[head.right.val] = head
            vals = [head.val for head in new_temp]
            if (x in vals and y in vals) and parent_dict[x] is not parent_dict[y]:
                return True
            
            temp = new_temp
        return False