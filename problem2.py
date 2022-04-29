#Cousins in binary tree

# // Time Complexity :O(N) - Going though every nodes
# // Space Complexity : O(H) as we are using a queue to store the nodes
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


def isCousins( root, x, y):
    if root==None: return False
    queue=[root]
    res=[]
    xval=False
    yval=False
    while(queue):                       #we're doing bfs
        size = len(queue)
        for i in range(size):                       
            root = queue.pop(0)  
            if(root.val==x):                        #if the current value is x or y, then change the boolean values
                xval=True
            if(root.val==y):
                yval=True
            if(root.left and root.right):              #if theres left and right, then make sure theyre not both x and y
                if((root.left.val==x and root.right.val==y) or (root.left.val==y and root.right.val==x)):
                    return False
            if(root.left):
                queue.append(root.left)
            if(root.right):
                queue.append(root.right)
        if (xval and yval):                             #after every level, if you already found x and y then just return true
            return True
        if(xval or yval):                               #if you only found either x or y, then return false
            return False
    return False