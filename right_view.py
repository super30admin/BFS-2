# Time Complexity :O(N)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach



from collections import deque
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        right_view=[]
        q=deque([])
        path=None
        q.append(root)
        while(len(q)):
            s=len(q)
            for i in range(s):
                curr=q.popleft()
                if(curr):
                    path=curr.val
                    if(curr.left):
                        q.append(curr.left)
                    if(curr.right):
                        q.append(curr.right)
            
            if(path!=None ):
                right_view.append(path)
        return right_view