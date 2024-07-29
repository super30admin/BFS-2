#######199. Binary Tree Right Side View####################################################################################################################
// Time Complexity : n
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no problem

// Your code here along with comments explaining your approach in three sentences only
I have sued BFS approach but first I will select right child and put it in queue, so for each level the first child is the right most child which will give right view, now to append it in list I made sure only 1st element is inserted in list and rest are ignored


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return
        res=[]
        q=collections.deque()
        lvl=0
        q.append(root)
        #res.append(root.val)
        while len(q)>0:
            lvl+=1
            for i in range(len(q)):
                curr=q.popleft()
                if i==0:
                    res.append(curr.val)
                if curr.right:
                    q.append(curr.right)
                if curr.left:
                    q.append(curr.left)
            #res.append(q.)
        return res
            
        
        
        
        

######993. Cousins in Binary Tree#############################################################################################################


// Time Complexity : n
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA

// Your code here along with comments explaining your approach in three sentences only
Here also we have used BFS where before inserting we are checking if they are sibling if that is the case than return False. Next we check if they are presenting in same level and do not have same parents than true or else return false as they will be on different level.


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    '''def __init__(self):
        self.xparent = None
        self.yparent = None
        self.xlvl = None
        self.ylvl = None'''

    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        valx,valy=False,False
        q1=collections.deque()
        q1.append(root)
        while len(q1)>0:
            len1=len(q1)
            #print('while: ',q1)
            for i in range(len1):
                curr=q1.popleft()
                #print('for: ',curr)
                if curr and curr.val==x:
                    valx=True
                elif curr and curr.val==y:
                    valy=True
                if curr.left and curr.left.val==x and curr.right and curr.right.val==y:
                    return False
                if curr.left and curr.left.val==y and curr.right and curr.right.val==x:
                    return False
                if curr.left:
                    q1.append(curr.left)
                if curr.right:
                    q1.append(curr.right)
            #print(valx,valy)
            if valx==True and valy==True:
                return True
            if valx==True and valy==False:
                return False
            if valx==False and valy==True:
                return False
        return False
        