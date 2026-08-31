# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

"""
APPROACH:
1. Use BFS to traverse the tree, tracking each node's parent and level (depth) as we go.
2. When node x or node y is found, save its parent and level.
3. Once both x and y have been found, compare their levels and parents.
4. They are cousins only if they are on the same level but have different parents.
5. Return the result as soon as both nodes are found, no need to keep traversing.

PATTERN:
Tree BFS / Level Order Traversal (tracking parent + depth)

TIME COMPLEXITY:
O(n) - in the worst case every node is visited once before both targets are found

SPACE COMPLEXITY:
O(n) - queue can hold up to one full level of nodes in the worst case

EXAMPLE:
Input:
        1
       / \
      2   3
     /     \
    4       5
x = 4, y = 5

Output: True
Why: both 4 and 5 are at level 2, but their parents (2 and 3) are different
"""

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:

        x_parent, x_level = None, None  # will store parent node and depth of x
        y_parent, y_level = None, None  # will store parent node and depth of y

        q = collections.deque()  # queue used for BFS
        q.append((root, None, 0))  # start with root, no parent, level 0

        while q:

            current_node, parent_node, level = q.popleft()  # process next node

            # if this node is x, save its parent and level
            if current_node.val == x:
                x_parent, x_level = parent_node, level
            
            # if this node is y, save its parent and level
            if current_node.val == y:
                y_parent, y_level = parent_node, level

            # once both x and y are found, decide the answer
            if x_level is not None and y_level is not None:
                if x_level != y_level:
                    return False  # different levels, cannot be cousins
                if x_parent == y_parent:
                    return False  # same parent means siblings, not cousins
                return True  # same level, different parents, they are cousins


            # add children to queue so they get processed in next level
            if current_node.left:
                q.append((current_node.left, current_node, level + 1))

            if current_node.right:
                q.append((current_node.right, current_node, level + 1))