#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        #Assing children as False and Parents as None
        x_found = False
        y_found = False
        x_parent = None
        y_parent = None
        #Queue to track child nodes in a level
        cq = deque([root])
        #Queue to track the parent of the above child nodes
        pq = deque([None])
        #Loop to check if the nodes are cousins after each level in the tree
        while(len(cq)>0):
            cqlen = len(cq)
            #Loop for each level in the tree
            for i in range(cqlen):
                #Current child node
                curr = cq.popleft()
                #Current parent node
                parent = pq.popleft()
                if(curr.val==x):
                    x_found = True
                    x_parent = parent
                if(curr.val==y):
                    y_found = True
                    y_parent = parent
                if(curr.left!=None):
                    cq.append(curr.left)
                    pq.append(curr)
                if(curr.right!=None):
                    cq.append(curr.right)
                    pq.append(curr)
            #If both x and y are found in same level with different parents, Return True
            if(x_found == True and y_found == True and x_parent!=y_parent):
                return True
            #If only one value is found in a level then they are not cousins, return False
            elif(x_found == True or y_found==True):
                return False

            


            

        