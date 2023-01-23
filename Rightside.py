# Time Complexity : O(N)
# Space Complexity : O{N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Create a queue and push the root .Also create a list called rightside to append the right side values
#while the queue is not empty ,iterate over the nodes in the level and push the children in the queue
#Append the result of the last node of each level to the list

def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        rightside=[]
        if not root:
            return rightside

        q=deque()
        q.append(root)

        while q:
            size=len(q)

            for i in range(size):
                node = q.popleft()

                if i==size-1:
                    rightside.append(node.val)

                if node.left:
                    q.append(node.left)

                if node.right:
                    q.append(node.right)
        
        return rightside