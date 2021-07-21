# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Space:O(N)
#Time:O(N)
from collections import defaultdict
from collections import deque
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        list_val = []
        if not root:
            return []
        queue = deque()
        index = 1
        
        queue.append((root,index))
        while(queue):
            root,index = queue.popleft()
            print(root.val)
            if len(list_val)<index:
                list_val.append(root.val)
            else:
                list_val[index-1]=root.val
            # dict_map[index] = root
            if root.left:
                queue.append((root.left,index+1))
            if root.right:
                queue.append((root.right,index+1))
        return [val for val in list_val]