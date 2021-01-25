#Time Complexity :O(n)
#Space Complexity :O(m) m-maximum elements at any level
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : tried running sum.
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        #BFS
        queue=collections.deque()
        queue.append(root)
        while(len(queue)!=0):
            size=len(queue)
            x_found=False
            y_found=False
            for i in range(size):
                curr=queue.popleft()
                if(curr.val==x):
                    x_found=True
                if(curr.val==y):
                    y_found=True
                if(curr.left!=None and curr.right!=None):
                    if(x==curr.left.val and y==curr.right.val):
                        return False
                    if(y==curr.left.val and x==curr.right.val):
                        return False
                
                if(curr.left!=None):
                    queue.append(curr.left)
                if(curr.right!=None):
                    queue.append(curr.right)
            if(x_found and y_found):
                return True
        return False
                
                
        