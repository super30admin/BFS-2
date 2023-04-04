# Time Complexity : O(n)
# Space Complexity : O(N). In the worst case, we need to store all the nodes of the last level in the queue. The last level of a binary tree can have a maximum of N/2 nodes. Not to forget we would also need space for N/4 null markers, one for each pair of siblings. That results in a space complexity of O(3N/4) = O(N)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = []
        q.append(root)
        xfound = False
        yfound = False
        parent = []
        parent.append(None)
        while(len(q) > 0):
            size = len(q)
            for i in range(size):
                temp = q.pop(0)
                p = parent.pop(0)
                if temp.val == x:
                    xfound = True
                    px = p
                elif temp.val == y:
                    yfound = True
                    py = p

                if temp.left != None:
                    q.append(temp.left)
                    parent.append(temp)
                if temp.right != None:
                    q.append(temp.right)
                    parent.append(temp)
            if xfound == True and yfound == True and px != py:
                return True
            elif xfound == True or yfound == True:
                return False
            
        return False
