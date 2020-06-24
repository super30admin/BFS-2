# Time Complexity :O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        #edge case
        if root == x or root == y:
            return False
        
        temp = [root]
        xparent = None
        xhight = 0
        yparent = None
        yhight = 0
        #hight of each level
        hight = 0
        while temp:
            hight+=1
            newtemp = []
            #for each node in temp
            for i in temp:
                #if left node == y or x update the hight and parent and append node
                if i.left:
                    if i.left.val == x:
                        xparent = i
                        xhight = hight
                    elif i.left.val == y:
                        yparent = i
                        yhight = hight
                    newtemp.append(i.left)
                #if right node == y or x update the hight and parent and append node
                if i.right:
                    if i.right.val == x:
                        xparent = i
                        xhight = hight
                    elif i.right.val == y:
                        yparent = i
                        yhight = hight
                    newtemp.append(i.right)
            temp = newtemp
        #check if hight is the same and parents are different
        return   xhight == yhight and xparent != yparent