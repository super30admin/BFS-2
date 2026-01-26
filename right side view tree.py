class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result=[]
        if root is None:
            return []
        q=[root]

        while q:
            s=len(q)

            for i in range(s):
                curr=q.pop(0)
                if i==s-1:
                    result.append(curr.val)

                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
        return result