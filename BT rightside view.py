# // Time Complexity : O(n)
# // Space Complexity : O(D) where D is the tree diameter
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


import collections
class Solution:
    def rightSideView(self, root):
        res = []
        q = collections.deque([root])
        
        # iterates through current level
        while q:
            rightSide = None
            qLen = len(q)
            
            for i in range(qLen):
                node = q.popleft() # pop nodes from current level
                if node:
                    rightSide = node # store right node
                    
                    # add the children nodes
                    q.append(node.left)
                    q.append(node.right)
                    
            if rightSide:
                res.append(rightSide.val)
        
        return res