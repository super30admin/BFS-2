
#Time Complexity O(N)
#Space Complexity O(N/2)
class Solution:
    def checklastelement(self,root,x1,y1):
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
                if curr.left != None and curr.right != None:
                    if curr.left.val == x1 and curr.right.val == y1:
                        return False
                    if curr.left.val == y1 and curr.right.val == x1:
                        return False
                if curr.left !=None:
                    q.append(curr.left)
                if curr.right !=None:
                    q.append(curr.right)
            if x1 in temp and y1 in temp:
                return True
            
        return False
    
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        return self.checklastelement(root,x,y)
        
        
        
        
        
        
