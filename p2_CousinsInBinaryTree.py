# 993. Cousins in Binary Tree


# // Time Complexity : O(n)
# // Space Complexity : O(W) # width of binary tree
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        # using level order traversal
        q = [root]
        level = 0
        parentQ = [root]
        while q:
            temp =[]
            tempx,tempy = False,False # reset temp x,y for new level
            for i in range(len(q)):
                root = q.pop(0)
                curP = parentQ.pop(0)
                if root.left:
                    q.append(root.left)
                    parentQ.append(root)
                    print(curP.val)
                if root.right:
                    q.append(root.right)
                    parentQ.append(root)
                if root.val == x: # found x
                    tempx = True
                    parentX = curP
                if root.val == y:  # found y
                    tempy = True
                    parentY = curP
            if tempx and tempy and parentX != parentY: # if both exisit in same level  nad parent !=
                return True
        return False