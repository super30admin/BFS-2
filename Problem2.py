#Time Complexity : O(n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this :No

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        q = collections.deque([root])
        while q:
            parent = dict()
            qlen = len(q)  
            for i in range(qlen):
                node = q.popleft()
                for child in [node.left, node.right]:
                    if not child:
                        continue
                    q.append(child)
                    parent[child.val] = node
            if (x in parent) ^ (y in parent):
                return False
            if (x in parent) and (y in parent):
                if parent[x]== parent[y]:
                    return False
                else:
                    return True
        return False
