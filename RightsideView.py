# Time Complexity : O(n) for each operation.
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to traverse level by level and print all the last noded by recursive approach starting right first.

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        q=deque()
        q.append(root)
        if(root==None):
            return
        res=[]
        while(len(q)!=0):
            n=len(q)
            for i in range(0,n):
                curr=q.popleft()
                if(i==0):
                    res.append(curr.val)
                if(curr.right!=None):
                    q.append(curr.right)
                if(curr.left!=None):
                    q.append(curr.left)
        return res