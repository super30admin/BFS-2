
class TreeNode:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None


class Solution:

    # DFS Solution
    # time : O(N)
    # space : O(1) + Recursive call stack

    def cousinsTree(self, root, x, y):
        if x == None or y == None:
            return False

        self.x_depth = -1
        self.y_depth = -1
        self.x_parent = None
        self.y_parent = None
        self.helper(root, x, y, 0, None)

        if self.x_depth == self.y_depth and self.x_parent.key != self.y_parent.key:
            return True
        return False

    def helper(self, root, x, y, depth, parent):
        # BASE CASE
        if root != None:
            if root.key == x:
                self.x_depth = depth
                self.x_parent = parent
            if root.key == y:
                self.y_depth = depth
                self.y_parent = parent

        # LOGIC
        if root.left:
            self.helper(root.left, x, y, depth+1, root)
        if root.right:
            self.helper(root.right, x, y, depth+1, root)



    # BFS Solution
    # time : O(N)
    # space : O(2K), WORST CASE: q holds all the nodes in the last Level 

    def cousinsTree(self, root, x, y):
        if x == None or y == None or root == None:
            return False

        q = [root]
        while q != []:
            size = len(q)
            leveList = []                   # levelList : not necessary
            for i in range(size):
                root = q.pop(0)
                leveList.append(root.key)
                if root.left != None and root.right != None:
                    if root.left.key == x and root.right.key == y:
                        return False
                    if root.left.key == y and root.right.key == x:
                        return False
                
                if root.left != None:
                    q.append(root.left)
                if root.right != None:
                    q.append(root.right)
            if x in leveList and y in leveList:
                return True

    # =======================================================================
    # BFS Solution
    # time : O(N)
    # space : O(K), WORST CASE: q holds all the nodes in the last Level

    def cousinsTree(self, root, x, y):
        if x == None or y == None or root == None:
            return False

        q = [root]
        while q != []:
            size = len(q)
            x_isFound = False
            y_isFound = False              
            for i in range(size):
                root = q.pop(0)
                if root.key == x:
                    x_isFound = True
                if root.key == y:
                    y_isFound = True

                if root.left != None and root.right != None:
                    if root.left.key == x and root.right.key == y:
                        return False
                    if root.left.key == y and root.right.key == x:
                        return False
                
                if root.left != None:
                    q.append(root.left)                    
                if root.right != None:
                    q.append(root.right)

            if x_isFound and y_isFound:
                return True
        return False
                    


        
            
        




a = TreeNode(3)
a.left = TreeNode(9)
a.left.left = TreeNode(1)
a.left.right = TreeNode(0)
a.right = TreeNode(20)
a.right.left = TreeNode(15)
a.right.right = TreeNode(7)

obj = Solution()
print(obj.cousinsTree(root=a, x=1, y=7))