#// Time Complexity : O(n) 
# // Space Complexity : O(1)in dfs if not considering stack space o(n/2) in BFS i.e o(n)  
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : understanding the x_found and y_found and checking the parent node was a bot tricky.

# Definition for a binary tree node.
# class TreeNode:
#     def _init_(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:

# BFS Approach: 

# I am storing the curr node in queue and iterating over its current child in loop.
# After that checking for current node check if the children are x and y that means they share parent.Hence return False.
# Parent check if done.After each for loop we are done processing a particular level.
# If at the end we get both x found and y found flag True that means we are on same level and hence return True else return False.

        queue=deque()
        queue.append(root)

        while queue:
            xFlag=False
            yFlag=False
            size=len(queue)

            for i in range(size):
                curr=queue.popleft()
                if curr.val==x:
                    xFlag=True
                if curr.val==y:
                    yFlag=True
                if curr.left and curr.right: # for current node check if the children are x and y that means they share parent.
                                                # Hence return False
                    if curr.left.val==x and curr.right.val==y:
                        return False
                    if curr.left.val==y and curr.right.val==x:
                        return False
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            if xFlag and yFlag:
                return True
            if xFlag or yFlag:
                return False
        return True

 # DFS Approach:

 # For DFS approach I have maintain level and parent of current processing Node.
 # If the curr node value is x we set xparent to its parent and same for y. at this point we also update x and y level found.
 # at the end of DFS we check if xparent and yparent are different and levels found are same, return True.
 # Else return False.


        # if root is None:
        #     return False
        # xparent=TreeNode()
        # yparent=TreeNode()
        # xlevel=0
        # ylevel=0

        # def dfs(root,level,parent):
        #     nonlocal xparent
        #     nonlocal yparent
        #     nonlocal xlevel
        #     nonlocal ylevel
        #     if root is None:
        #         return
        #     if root.val==x:
        #         xparent=parent
        #         xlevel=level
        #     if root.val==y:
        #         yparent=parent
        #         ylevel=level
                
        #     dfs(root.left,level+1,root)
        #     dfs(root.right,level+1,root)

        # dfs(root,0,None)

        # return xparent!=yparent and xlevel==ylevel