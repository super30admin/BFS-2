"""
LC199 Binary Tree Right Side View
Approach 1 - We can do the BFS- Level order traversal and return the last element in each list
We will also need the size variable to distinguish the elements on different levels

Approach 2 -  DFS - for every new element, we check the len(result) and curr index
If size of result = level, it means there is no  element for that level in the result matrix, so we add the 

TC O(N) since each node is processed exactly once
SC O(N) recursive stack space
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
         return self.helper(root, 0, [])
        
    def helper(self, node, level, levels):
        #base 
        # if node reaches none, return levels
        if not node:
            # we don't need to return anything here, see #NOTE below
            return
        
        # if current level and len of levels arr is same, means that we need to append the new value
        if len(levels) == level:
                levels.append(node.val)
        # if we want right side view, we execute the else part to overwrite the values at each level with the rightmost value
        # if we comment this part out, we will get left side view of the tree
        else:
            # else just overwrite the value
            levels[level] = node.val
        
        # NOTE We are not caring about the return value as levels is passed by reference and whatever modifications
        # are made to levels during the recusion, will persist
        self.helper(node.left, level+1, levels)
    
        self.helper(node.right, level+1, levels)
        
        # we can safely return levels at the end because it was passed by reference, it would have all the results
        return levels

"""
APPROACH 2 :
Using a Queue
TC O(N) : each node processed once
SC O(N) for queue : at any point queue will have at most N/2 nodes for a complete BST
"""
from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root)-> list[int]:
        # we will keep on adding elements to the queue and will only add the last element in that level to the result

        result = []
        if not root:
            return result
        q = deque()

        q.append(root)

        while q:
            size = len(q) # use new size var for loop
            for i in range (size):
                node = q.popleft()
                if i == size-1:
                    # in each for loop, we only want to append value that is last in the current part queue
                    # for example, if queue is processing [2,3] at 2nd level in the tree, we don't add 2 to the result
                    # and we only add 3. in this case i would be 2, for loop would go over i =[0,1] and when i=1
                    # it would be size(2) -1 = 1. If condition succeeds and we add it to the list
                    result.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)

        return result



