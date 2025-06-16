# TC: O(n)
# SC: o(n)
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q=deque([])
        q.append(root)
        while q:
            size=len(q)
            level=[]
            for i in range(size):
                curr=q.popleft()
                if curr.left and curr.right:
                    if curr.left.val==x and curr.right.val==y or curr.left.val==y and curr.right.val==x:
                        return False
                
                if curr.left:
                    q.append(curr.left)
                    level.append(curr.left.val)
                if curr.right:
                    q.append(curr.right)
                    level.append(curr.right.val)
            
            if x in level and y in level:
                return True
            
            if x in level or y in level:
                return False