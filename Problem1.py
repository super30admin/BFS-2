#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
   
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        q = deque()
        if root == None:
            return []
        q.append(root)
    
        while q:
            length = len(q)
            for i in range(length):
                el = q.popleft()
                if i== length-1:
                    result.append(el.val)
                if el.left!= None:
                    q.append(el.left)
                if el.right!= None:
                    q.append(el.right)
        return result