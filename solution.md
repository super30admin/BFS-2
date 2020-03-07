# Problem 1
## Time Complexity :
O(n)

## Space Complexity :
O(1)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution 1: BFS.
        class Solution:
            def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
                def dfs(root: TreeNode, x, y, depth, parent: TreeNode):
                    if not root:
                        return False

                    if root.val==x:
                        self.x_depth=depth
                        self.x_parent=parent

                    if root.val==y:
                        self.y_depth=depth
                        self.y_parent=parent

                    dfs(root.left,x,y,depth+1,root)
                    dfs(root.right,x,y,depth+1,root)    
                self.x_depth,self.y_depth=0,0
                self.x_parent=TreeNode(0)
                self.y_parent=TreeNode(0)
                #Edge Case
                if not root:
                    return False
                dfs(root,x,y,0,None)
                return self.x_depth==self.y_depth and self.x_parent!=self.y_parent
        
