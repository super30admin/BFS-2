#Time Complexity : O(n)
#Space Complexity : O(n)
#Any problem you faced while coding this : -

#The approach is a standard level-order traversal using a queue to process each level of the binary tree. The nodes at a particular level are determined based on the size of the queue. The last node of each level(rightmost) is fetched.


from collections import deque

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = list()

        if not root:
            return result

        q = deque()
        q.append(root)

        while len(q) != 0:
            level_size = len(q)
            
            for i in range(level_size):
                curr = q.popleft()

                if i == level_size - 1:
                    result.append(curr.val)
                
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)

        return result