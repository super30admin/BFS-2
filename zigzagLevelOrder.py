# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque

class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        # Idea: Traverse the Tree using BFS. In even levels, reverse the output to have right to left node values and In odd levels, add the level output without changing
        
        # Time Complexity: O(N)
        # Space Complexity: O(2^HeightOf Tree) Last level nodes ie. leaf nodes
        if root is None:
            return []
        is_odd = True
        output = []
        queue = deque()
        queue.append(root)
        while len(queue) > 0:
            qsize = len(queue)
            temp = []
            for i in range(qsize):
                popped_val = queue.popleft()
                temp.append(popped_val.val)
                if popped_val.left is not None:
                    queue.append(popped_val.left)
                if popped_val.right is not None:
                    queue.append(popped_val.right)
            if is_odd:
                output.append(temp)
            else:
                output.append(temp[::-1])
            is_odd = not is_odd
        return output
                    
        
        
        
        
