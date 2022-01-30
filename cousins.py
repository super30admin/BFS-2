# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def find_node(self, level_nodes, x,y):
        nex = []
        while level_nodes:
            while level_nodes:
                node = level_nodes.pop()
                #print(node.val, "node val")
                if node.left:
                    #print(node.left.val, "left")
                    if node.left.val == x :
                        return level_nodes, y
                    elif node.left.val == y :
                        return level_nodes, x
                    nex.append(node.left)
                if node.right:
                    #print(node.right.val, "right")
                    if node.right.val == x :
                        return level_nodes, y
                    elif node.right.val == y :
                        return level_nodes, x
                    nex.append(node.right)
                    
            level_nodes = nex.copy()
        return [], None
        
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        level_nodes = [root]
        #find level nodes which child matches with left or right
        level_nodes,val = self.find_node(level_nodes, x,y)
        #print(len(level_nodes),"len")
        #print(val)
        while level_nodes:
            node = level_nodes.pop()
            #print(node.val)
            if node.right:
                if node.right.val == val :
                    return True
            elif node.left:
                if node.left.val == val :
                    return True

        
        return False
        
    
    #Time complexity - O(n)  check node only once
    # space complexity -O(2^h)    h is height of the tree 
        