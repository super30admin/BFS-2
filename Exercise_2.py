#Time Complexity : O(N)), N being the number of nodes in the tree. 
#Space Complexity : O(N), N being the number of nodes in the tree. 
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Had to debug an error where I typed == instead of =. 
#Had to print a bunch of print statements. 
#Your code here along with comments explaining your approach in three sentences only
'''Using BFS, create a queue where each level is placed into the level. Then, after placing
each level into the queue, if x and y are in the level, check if they parent are the same. If not
return True. 
'''
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        #initialize queue and root. It is assume there must be a root. 
        queue = []
        queue.append(root)
        #main bfs 
        while(len(queue)>0):
            length = len(queue)
            x_found = False
            y_found = False
            for i in range(length):
                node = queue[0]
                queue.pop(0)
                #if x or y is found, switch on x_found or y_found. 
                if node.left!=None:
                    queue.append(node.left)
                    if node.left.val==x:
                        x_found=True
                    if node.left.val==y:
                        y_found=True
                if node.right!=None:
                    queue.append(node.right)
                    if node.right.val==x:
                        x_found=True
                    if node.right.val==y:
                        y_found=True
                #return false if x and y have same parent. 
                if node.left!=None and node.right!=None:
                    if node.left.val==x and node.right.val==y:
                        return False
                    if node.left.val==y and node.right.val==x:
                        return False
            #if both are found, return true, else return false. 
            if y_found==True and x_found==True:
                return True
        return False



