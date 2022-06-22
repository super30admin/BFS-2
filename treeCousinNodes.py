"""
Approach: DFS: Recursive

You start at the root, and do a DFS traversal, at each level you pass depth to helper function, initially at root its 0. 
Increase depth as you go down. If you find left or right child of the node to be x or y, add that to results along with its depth and parent.
If we found both the nodes near the top or mid of the tree, we end recursion there by using len of results as a guage, to prune the recursion.

TC : O(N), where N is the number of nodes in the binary tree. In the worst case, we might have to visit all the nodes of the binary tree.

Let's look into one such scenario. When both Node x and Node y are the leaf nodes and at the last level of the tree, the algorithm has no reasons to prune the recursion. It can only come to a conclusion once it visits both the nodes. If one of these nodes is the last node to be discovered the algorithm inevitably goes through each and every node in the tree.

SC O(N). This is because the maximum amount of space utilized by the recursion stack would be N, as the height of a skewed binary tree could be, at worst, N. 
For a left skewed or a right skewed binary tree, where the desired nodes are lying at the maximum depth possible, the algorithm would have to maintain a recursion stack of the height of the tree. 
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        # check few base conditions, such as:
        # root is not None,
        # root left is None and right is not None
        # root right is None and left is not None
        # or root value is one of the x or y values
        # in all these cases the result would be False
        if (not root or (root.left is None and root.right is not None) or
          (root.right is None and root.left is not None)) or root.val in (x,y):
            return False
        
        # create empty results list and pass it to the helper and depth is 0
        res = self.helper(root,x,y,[], 0)
        # once returned from recursion, result list should have 0th index in both tuples to be
        # not equal, meaning parents not same, but 1st index should be equal meaning they are at equal depth
        return res[0][0] != res[1][0] and res[0][1] == res[1][1]
            
    def helper(self, node, x, y, results, depth):
        # base
        if not node:
            return
        
        # logic
        # if left value is one of the x or y, add current node value and depth to results
        if node.left and node.left.val in (x,y):
            results.append((node.val, depth))
        # if right value is one of the x or y, add current node value and depth to results
        if node.right and node.right.val in (x,y):
            results.append((node.val, depth))
        # if we have already discovered both x and y values and added to results, then no need to go any further
        if len(results) < 2:
            self.helper(node.left, x, y, results, depth+1)
            self.helper(node.right, x, y, results, depth+1)
        
        return results


"""
Approach: BFS with Queue

TC: O(N) we may need to visit all nodes in the tree in the worst case
SC: O(N) we may go to bottom most level where we have N/2 nodes, and need to store that in queue
"""
from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        xflag, yflag = False, False
        if not root:
            return False
        
        q = deque()
        
        q.append(root)
        
        while q:
            size = len(q) # get size of the queue, this signifies no of nodes at current level as this is BFS
            for i in range(size): # iterate over all nodes at current level
                node = q.popleft()
                
                # handle case where x and y could be siblings
                if node and node.left and node.right:  # if both left and right exist then check
                    if node.left.val in (x,y) and node.right.val in (x,y):  # if the x and y can both be found in left and right nodes
                        return False   # if so, they are siblings, not cousins, return False

                if node.val == x: xflag = True    # if we find x, set xflag to true
                if node.val == y: yflag = True    # if we find y, set yflag to true
                # x and y are not siblings, so add them to the queue. This means that when we add nodes to the queue
                # at each level in the tree, if we find x and y there, they are surely not siblings, because we already checked it before
                # we added them to the queue.
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            # hence if we find both flags set to True after the `for` loop, we can confidently return True
            if xflag and yflag : return True
            if xflag or yflag: return False  # if only one was set then its a False
            

            

