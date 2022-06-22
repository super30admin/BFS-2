"""
Approach: Recursive traversal

Maintain a results list and for each recursion, check if it has len == level being passed in. If so append the node value.
If not, just use that level as index and overwrite current node value over previous value. when we reach end of the recursion, just return the levels.

TC O(N) since each node is processed exactly once
SC O(N) for output datastructure. We can argue it can be ignored, in that case O(1) and whatever stack space is used by the program
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
            #. we don'tt need to return anything here, see #NOTE below
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
Approach: Queue approach

TC O(N) each node processed once
SC O(N) for queue = at any point queue will have at most N/2 nodes for a complete BST
"""



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if not root:
            return []
        
        q = deque()
        # append root
        q.append(root)
        
        while q:
            size = len(q)  # use new size var for loop
            for i in range(size):
                node = q.popleft()
                if i == size -1:
                    # meaning in each for loop, we only want to append value that is last in the current part queue
                    # for example, if queue is processing [2,3] at 2nd level in the tree, we don't add 2 to the result
                    # and we only add 3. in this case i would be 2, for loop would go over i =[0,1] and when i=1
                    # it would be size(2) -1 = 1. If condition succeeds and we add it to the list
                    result.append(node.val)
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
        print(result)
        return result
                            