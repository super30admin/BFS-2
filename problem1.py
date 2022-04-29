#Binary Tree Right Side View 
# // Time Complexity :O(N) - Going though every nodes
# // Space Complexity : O(H) as we are using a queue to store the nodes
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no





def rightSideView( root):
    if root==None or root==[]: return []
    queue=[root]
    res=[]
    while(queue):
        size = len(queue)
        for i in range(size):                           #doing BFS 
            root = queue.pop(0)                         #for each level, only add the node that equals to the size of nodes in that level
            if(i==size-1):
                res.append(root.val)
            if(root.left):                                 #add left node if it exists
                queue.append(root.left)
            if(root.right):                                 #add right node if it exists
                queue.append(root.right)
    return res