# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time/Space Complexity - O(n)
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        x_depth = y_depth = None
        x_parent = y_parent = None
        def helper(root, parent, depth, x, y):
            if not root: return False

            if root.val == x:
                x_depth = depth
                x_parent = parent
            
            if root.val == y:
                y_depth = depth
                y_parent = parent

            helper(root.left, root, depth+1, x, y)
            helper(root.right, root, depth+1, x, y)
        helper(root, None, 0, x, y)
        return (x_depth == y_depth) and (x_parent != y_parent)



        # if not root: return False
        # queue = deque([(root,None)])
        # x_found = y_found = False
        # # x_parent = y_parent = None
        # while queue:
        #     for _ in range(len(queue)):
        #         child,parent = queue.popleft()
        #         # sibling check
        #         if child.left and child.right:
        #             if child.left.val == x and child.right.val == y: return False
        #             if child.left.val == y and child.right.val == x: return False
        #         if child.val == x:
        #             x_found = True
        #             # x_parent = parent
        #         if child.val == y:
        #             y_found = True
        #             # y_parent = parent
        #         if child.left:
        #             queue.append((child.left, child))
        #         if child.right:
        #             queue.append((child.right, child))
        #     if x_found and y_found: return True
        #     if x_found or y_found: return False
        # return False
       
       
       
        # queue = deque([root])

        # val = 0
        # while queue:
        #     for _ in range(len(queue)):
        #         node = queue.popleft()
        #         if node.val == x or node.val == y:
        #             val += 1

        #         if node.left and node.right:
        #             if node.left.val in [x, y] and node.right.val in [x, y]:
        #                 return False
                        
        #         node.left and queue.append(node.left)
        #         node.right and queue.append(node.right)
            
        #     if val == 1:
        #         return False
        #     if val == 2:
        #         return True
        
