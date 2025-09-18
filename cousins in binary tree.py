# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

'''
Solution 1 - BFS 
2 checks:
    - Siblings vs cousins check:
        - when adding children of parent, see if those 2 children are x,y (target)
            - yes -> return False
            - no -> fine, continue
    - level check:
        - Maintain 'size' variable for iterating all parents at this level
        - if at this level, we find only ONE of x or y then x and y are not cousins.
Time Complexity: O(N)
Space complexity: O(N/2) = O(N), N/2=leaf nodes for perfect binary tree.
'''
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        bfs_queue = deque()
        bfs_queue.append(root)

        found_x = False
        found_y = False
        while (len(bfs_queue)!=0):
            size = len(bfs_queue)

            for i in range(size):
                curr_parent = bfs_queue.popleft()
                
                # same parent check
                if curr_parent.left!=None and curr_parent.right!=None:
                    if curr_parent.left.val==x and curr_parent.right.val==y:
                        return False # siblings, same parent
                    if curr_parent.left.val==y and curr_parent.right.val==x:
                        return False # siblings, same parent
                
                if curr_parent.left!=None:
                    if curr_parent.left.val == x:
                        found_x = True
                    if curr_parent.left.val == y:
                        found_y = True
                    bfs_queue.append(curr_parent.left)

                if curr_parent.right!=None:
                    if curr_parent.right.val == x:
                        found_x = True
                    if curr_parent.right.val == y:
                        found_y = True
                    bfs_queue.append(curr_parent.right)

                if found_x and found_y:
                    return True
            
            # if at this level, we found only one, then level changes and we don't have siblings
            if (found_x and not found_y) or (not found_x and found_y):
                return False

        return False 
                    
'''
Solution 2 - DFS 
2 checks:
    - Siblings vs cousins check:
    - level check:
        
Time Complexity: O(N)
Space complexity: O(h) = O(N), h=height of tree.
'''
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.level_found_node = -1
        return self.helper(root,0,x,y) # parent, level, x, y

    def helper(self,parent,level,x,y):
        # base
        if parent==None:
            return True

        # logic
        # same level check
        if parent.val == x or parent.val == y:
            # check if we had found previously any one of the nodes
            if self.level_found_node!=-1:
                if level==self.level_found_node:
                    return True
                else:
                    return False
            else:
                self.level_found_node = level                

        # siblings check
        if parent.left!=None and parent.right!=None:
            if parent.left.val==x and parent.right.val==y:
                return False

            if parent.left.val==y and parent.right.val==x:
                return False
        
        left_check = self.helper(parent.left,level+1,x,y)
        right_check = self.helper(parent.right,level+1,x,y)

        return left_check and right_check
        
                