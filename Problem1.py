# Time Complexity : O(n) time 
# Space Complexity : O(h) space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
    # 1) since we have to check some 2 random child nodes, we know that they have height as a property and its parent as another, 
    #    so, we need 4 variables to save the height and the parent node if that child node is found 
    # 2) call the function which will traverse the BT and sets the height & Parent variable if found.
    # 3) just check if they have different parent and have same height for being cousins.
    
class Node:
    def __init__(self,x):
        self.val = x 
        self.left = None 
        self.right = None 
    
class Solution:
    xHeight = 0 
    yHeight = 0 
    xParent = 0 
    yParent = 0
    def isCousins(self,root,x,y):
        if not root:
            return False 
        self.__find(root,x,y,0,None)
        if self.xHeight == self.yHeight and self.xParent != self.yParent:
            return True 
        return False           

    def __find(self,root,x,y,height,parent):
        # base
        if not root:
            return 
        
        # Logic 
        if root.val == x:
            self.xHeight = height 
            self.xParent = parent
            
        if root.val == y:
            self.yHeight = height 
            self.yParent = parent
            
        self.__find(root.left,x,y,height+1,root)
        self.__find(root.right,x,y,height+1,root)    
        

if __name__ == "__main__":
    s = Solution()
    n = Node(1)
    n.left = Node(2)
    n.right = Node(3)
    n.left.right = Node(4)
    n.right.right = Node(5)
    res = s.isCousins(n,5,4)
    print(res) 