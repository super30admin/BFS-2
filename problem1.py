#Time Complexity O(N)
#Space Complexity O(N/2)

class Solution:
    def checklastelement(self,root):
        result = []
        if root == None:
            return result,0
        q = []
        q.append(root)
        depth = 0
        
        while len(q)>0:
            #To know how many elements to be processed
            size = len(q)
            temp = []
            for x in range(size):
                curr = q.pop(0)
                temp.append(curr.val)
                if curr.left !=None:
                    q.append(curr.left)
                if curr.right !=None:
                    q.append(curr.right)
            result.append(temp[-1])
            
        return result
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root ==None:
            return root
        return self.checklastelement(root)
        
