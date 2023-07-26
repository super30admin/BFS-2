# Time Complexity : O(n)
# Space Complexity : O(H)
# In Method 1 - BFS, we do lvel order traversal and keep track of parents and at end of each level if both x and y are found and parents are different return true, if same return True and if only 1 of them is found in current level, return False
# In Method 2 - BFS, we do lvel order traversal but not keep track of parents. When we are about to go right and left children of current element, we just check if they are x and y, if they are then they are siblings and not cousins -> return False. At end of each level if both x and y are found, return True and if only 1 of them is found in current level, return False. 
# In Method 3 - DFS, we keep track of parents and level.In the end if depth is same and parents are different return True

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        #Method 1 - BFS keeping track of the parents 
        # q=deque()
        # xflag=False
        # yflag=False
        # q.append((root,None))

        # while q:
        #     size=len(q)
        #     for _ in range(size):
        #         curr,parent=q.popleft()
        #         if curr.val==x:
        #             xflag=True
        #             x_parent=parent
        #         if curr.val==y:
        #             yflag=True
        #             y_parent=parent
        #         if curr.left:
        #             q.append((curr.left,curr))
        #         if curr.right:
        #             q.append((curr.right,curr))
        #     if xflag and yflag:
        #         return x_parent!=y_parent
        #     if xflag or yflag:
        #         return False
        # return False

        #Method 2 - BFS without keeping track of the parents
        # q=deque()
        # xflag=False
        # yflag=False
        # q.append(root)

        # while q:
        #     size=len(q)
        #     for _ in range(size):
        #         curr=q.popleft()
        #         if curr.val==x:
        #             xflag=True
        #         if curr.val==y:
        #             yflag=True
        #         if curr.left and curr.right: #idea is at current element, check if left and right exists, if they do check if left and right child are the x and y values, if they arem then they are siblings and not cousins -> return False
        #             if curr.left.val==x and curr.right.val==y: return False
        #             if curr.left.val==y and curr.right.val==x: return False
        #         if curr.left:
        #             q.append(curr.left)
        #         if curr.right:
        #             q.append(curr.right)
        #     if xflag and yflag:
        #         return True
        #     if xflag or yflag:
        #         return False
        # return False

        #Method 3 - DFS keeping track of level, parent
        if not root: return []
        depth_y=depth_x=0
        parent_x=parent_y=None
        def dfs(root,x,y,depth,parent):
            nonlocal depth_y,depth_x,parent_x,parent_y #use global variables, else it'll wrongfully get overwritten
            if not root: return

            if root.val==x:
                depth_x=depth
                parent_x=parent
            if root.val==y:
                depth_y=depth
                parent_y=parent
            if not parent_y or not parent_x: #once we found both of them, no need to further iterate the tree. So, we explore the tree further only if both, x and y are not found yet.
                dfs(root.left,x,y,depth+1,root)
            if not parent_y or not parent_x:
                dfs(root.right,x,y,depth+1,root)
        dfs(root,x,y,0,None)
        return depth_x==depth_y and parent_x!=parent_y
