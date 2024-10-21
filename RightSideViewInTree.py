#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        #Assign a result list for output and queue to process the nodes of tree
        res = []
        q =deque([root])
        #A loop running until the tree traverse through all nodes
        while(len(q)>0):
            #To store the right most node at each level
            rightSide = None
            #Get the updated length of queue after each level
            qlen = len(q)
            #Loop to traverse all nodes at a level
            for i in range(qlen):
                #At each level start from leftmost child, i.e, left node in the queue
                Node = q.popleft()
                #Codition to check for left and right nodes if the current node is not null
                if(Node!=None):
                    rightSide = Node
                    q.append(rightSide.left)
                    q.append(rightSide.right)
            #At the end of eacgh level append rightmost child to the result list
            if(rightSide!=None):
                res.append(rightSide.val)
        return res

            
        