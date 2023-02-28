# TC : O(n)
# SC : O(n) 
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        print("ok")
        if root is None:
            return []
        qu = []
        next_level = [root]
        def find_the_q(self, next_level, qu):
            if not next_level:
                return qu
            curr_level = next_level
            next_level = []
            for i in curr_level:
                if i.left:
                    next_level.append(i.left)
                    qu.append(i.left.val)
                if i.right:
                    next_level.append(i.right)
                    qu.append(i.right.val)
            qu.append(None)
            # print(qu)
            return find_the_q(self, next_level, qu)
        x = find_the_q(self, [root], [root.val, None])
        # print(x)
        res = []
        for i in range(1, len(x)):
            if x[i]==None and x[i-1]!=None:
                res.append(x[i-1])
        return res
                
