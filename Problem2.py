# Time Complexity : O(n)
# Space Complexity : O(h) for recursive stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Traverse the tree and find the two elements, and store their parent and depth.
# We keep track of parents and depth in the recursion itself.
# We can then check if the found nodes are cousins directly
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        foundX = None
        foundY = None
        
        def parentAndLevel(root, targetX, targetY, parent, depth):
            nonlocal foundX, foundY
            if not root:
                return
            if root.val == targetX:
                foundX = [parent, depth]
            if root.val == targetY:
                foundY = [parent, depth]
        
            parentAndLevel(root.left, targetX, targetY, root, depth+1)
            parentAndLevel(root.right, targetX, targetY, root, depth+1)
            

        parentAndLevel(root, x, y, None, 0)
        return foundX[0] != foundY[0] and foundX[1] == foundY[1]