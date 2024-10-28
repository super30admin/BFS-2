
#Approach
# for every level find the length of the queue befor poping , thise length is th no of elements in the level
# Run the loop for size and add the children of those in queue and pop th epresent elemnet in queue is the level order
# In the level order add the last element in the result that is the right most element of each level

#Complexiities
#Time : O(n)
#Space : O(n)





# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from typing import Optional, List


class Solution:
    queue = []

    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        queue = []
        result = []

        if root is None:
            return []

        if root.left is None and root.right is None:
            return [root.val]

        queue.append(root)

        while queue:
            size = len(queue)
            val = 0
            for _ in range(size):
                curr = queue.pop(0)
                val = curr.val

                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            result.append(val)
        return result




