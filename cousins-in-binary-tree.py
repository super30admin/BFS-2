#------------ Solution 1 : BFS - Maintaining Parent Queue--------
''' Time Complexity : O(n) 
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

'''
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        xfound,yfound = False, False
        xparent, yparent = 0, 0
        q = deque()
        pq = deque()
        q.append(root)
        pq.append(root)
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                currp = pq.popleft()
                if curr.val == x:
                    xfound = True
                    xparent = currp
                if curr.val == y:
                    yfound = True
                    yparent = currp
                
                if xfound and yfound:
                    if xparent != yparent:
                        return True

                if curr.left:
                    q.append(curr.left)
                    pq.append(curr)
                if curr.right:
                    q.append(curr.right)
                    pq.append(curr)

            if xfound or yfound:
                return False

#------------ Solution 1 : BFS - No Parent queue - Checking if sibling--------
''' Time Complexity : O(n) 
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        xfound , yfound = False, False
        q = deque()
        q.append(root)
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()

                if curr.left is not None and curr.right is not None:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.left.val == y and curr.right.val == x:
                        return False
                
                if curr.val == x:
                    xfound = True
                if curr.val == y:
                    yfound = True
                
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            
            if xfound and yfound:
                return True
            if xfound or yfound:
                return False



#---------Soultion 3 : DFS : Maintain global level and Check siblings -------
''' Time Complexity : O(n) 
    Space Complexity : O(h) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

'''
class Solution:
    def __init__(self):
        self.xfound , self.yfound = False, False
        self.xlevel , self.ylevel = -1, -1
        self.result = True

    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        def helper(root, level):
            #base
            if root is None:
                return 
            #logic
            if root.left is not None and root.right is not None:
                if root.left.val == x and root.right.val == y:
                    self.result = False
                if root.left.val == y and root.right.val == x:
                    self.result = False
            
            if root.val == x :
                self.xfound = True
                self.xlevel = level
            if root.val == y :
                self.yfound = True
                self.ylevel = level

            helper(root.left,level+1)
            helper(root.right,level+1)

            if self.xfound and self.yfound:
                if self.xlevel != self.ylevel:
                    self.result = False

        helper(root, 0)
        return self.result

            


        



        