class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        # Finding LCA
        def helper( root, x , y  ):
            nonlocal lca 
            counter = 0 
            if root.left:
                counter += helper(root.left, x , y)
            if root.right:
                counter += helper(root.right , x , y)
            if root.val == x or root.val == y:
                counter += 1
            if counter == 2 and lca == None:
                lca = root
            return counter
        # finding Depth     
        def findDepth(root, x):
            # Base case
            if (root == None):
                return -1
            # Initialize distance as -1
            dist = -1
            # Check if x is current node=
            if (root.val == x):
                return dist + 1
            dist = findDepth(root.left, x)
            if dist >= 0:
                return dist + 1
            dist = findDepth(root.right, x)
            if dist >= 0:
                return dist + 1
            return dist
                
        lca = None 
        helper(root , x , y)
        depth_x = findDepth(lca, x) 
        depth_y = findDepth(lca, y) 
        # if depth of both the nodes are same and are greater than 1, return True else return False
        return (depth_x == depth_y) if lca and depth_x > 1 else False
