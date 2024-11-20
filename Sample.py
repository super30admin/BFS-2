#Problem1: Cousins in Binary Tree (BFS)

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

'''
Traversing the tree in a breadth first manner and checking if the mentioned elements are found or not
if elements are found found checking if the elements parent is same or not
if parents are same then return false else add the right and left elements in the queue
'''


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        if root is None:
            return False
        Queue = []
        Queue.append(root)
        
        while(Queue!= []):
            xfound = False
            yfound = False
            size = len(Queue)
            # print(size)
            for i in range(size):
                a = Queue.pop(0)
                # print(a)
                # checking for the elements to be found
                if (a.val == x): 
                    xfound = True
                if (a.val== y):
                    yfound = True

                    # Checking if the parents are same or not
                if(a.left!=None and a.right!=None):
                    if(a.left.val == x and a.right.val==y):
                        return False
                    if(a.right.val==x and a.left.val == y):
                        return False
                # adding the left and right elements in the queue
                if(a.right!= None):
                    Queue.append(a.right)
                if(a.left!= None):
                    Queue.append(a.left)
            if xfound == True and yfound == True:
                return True
        return False
####################################################################

#Problem1: Cousins in Binary Tree (DFS)

# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

'''
Traversing the tree in a depth first manner recursively
taking four pointers
two to check the breadth and two to find the elements
Checking if the parents of the elements found is not same and the found elements are at the same level
if yes then return true else false
'''


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    xparent = None
    yparent = None
    x_depth = 0
    y_depth = 0
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        # global xparent
        # global yparent
        # global x_depth
        # global y_depth
        self.dfs(root, x,y, 0, None)
        return (self.xparent!= self.yparent) and (self.x_depth==self.y_depth)
    
    
    def dfs(self, root,x, y, depth, parent):
        
        #base
        if(root is None):
            return
        
        
        
        
        #logic
        
        if(x==root.val): # finding the element and storing the value of the aprent and the depth at which the lement is found
            self.xparent = parent
            self.x_depth = depth
        if(y==root.val):  # finding the element and storing the value of the aprent and the depth at which the lement is found
            self.yparent = parent
            self.y_depth = depth
        # recursively calling the right and the left function
        self.dfs(root.right, x,y, depth+1, root)
        self.dfs(root.left, x,y, depth+1, root)

########################################################################################

#Problem 2: Rotten oranges

#Time Complexity : O(rows*columns)
# Space Complexity : O(rows*cols)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

'''
Considering all the rotten oranges together and adding them in a queue and taking a count for all fresh oranges
Poping each rotten orange one at a time and checking its neighbours
Checking for the neighbouring oranges if they are fresh or not
if fresh making them rotten and add the orange position in the queue
after performing if the fresh oranges exist then return -1
adding time after every breadth traversal
return time -1

'''

class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        row = len(grid)
        
        if(grid == None or row == 0):
            return 0
        col = len(grid[0])
        
        Queue = []
        fresh = 0
        dirs = [[0,1],[0,-1],[1,0],[-1,0]] # direction array to traverse to its neighbours
        time =  0
        
        for i in range(row):
            for j in range(col):
                if(grid[i][j] == 2): # checking for rotten oranges and adding it to the queue
                    Queue.append((i,j))
                if(grid[i][j] == 1): # taking a count of fresh oranges
                    fresh+=1
                    
        while(Queue!=[]):
            size = len(Queue)
            for i in range(size):
                rotten = Queue.pop(0) # poping the rotten orange position of the queue
                # print(rotten)
                for dir in dirs: #checking for the neighbouring oranges
                    r = dir[0] + rotten[0]
                    c=  dir[1] + rotten[1]
                    
                    if(r>=0 and r< row and c>=0 and c<col and grid[r][c] == 1): # if oranges are fresh then making them rotten
                        grid[r][c] = 2
                        # print(grid[r][c])
                        Queue.append((r,c)) # adding the position of the rotten orange to the queue
                        fresh -=1
                        
            time += 1
            # print(time)
        if(fresh> 0):
            return -1
        if(time> 0):
            return(time-1)
        else:
            return 0
        ######################################################################################
#Problem 3: Employee Importance(BFS)

#Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

'''
Taking a hash map with key having employee id and value cmprising of the entire object
Adding the given id in the queue
Poping the id off the queue. from the hash map getting its importance and adding to the sum.
then going to its subordinates and and adding their importance respectively

'''

"""
# Employee info
class Employee(object):
    def __init__(self, id, importance, subordinates):
    	#################
        :type id: int
        :type importance: int
        :type subordinates: List[int]
        #################
        # It's the unique id of each node.
        # unique id of this employee
        self.id = id
        # the importance value of this employee
        self.importance = importance
        # the id of direct subordinates
        self.subordinates = subordinates
"""
class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        if(employees is None or len(employees) == 0):
            return 0
        
        

        Queue = []
        
        Queue.append(id)
        
        emap = {e.id: e for e in employees} # maintaing the hash map
        result = 0
        while(Queue!=[]):
            emp = Queue.pop(0)
            eb = emap.get(emp) # geting the value for the particular id
            
            result = result + eb.importance # adding the importance to result
            # print(result)
            
            
            for subid in eb.subordinates: # traversing the subordinates and adding them in queue
                Queue.append(subid)
        return(result)

#Problem 3: Employee Importance(DFS)

#Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

'''
Taking a hash map with key having employee id and value comprising of the entire object
Recursively traversing in a depth first manner
from the hash map getting its importance and adding to the sum.
then going to its subordinates and and adding their importance respectively

'''

"""
# Employee info
class Employee(object):
    def __init__(self, id, importance, subordinates):
    	#################
        :type id: int
        :type importance: int
        :type subordinates: List[int]
        #################
        # It's the unique id of each node.
        # unique id of this employee
        self.id = id
        # the importance value of this employee
        self.importance = importance
        # the id of direct subordinates
        self.subordinates = subordinates
"""
class Solution(object):
    result = 0 # global variable
    def getImportance(self, employees, id):
        """
        :type employees: List[Employee]
        :type id: int
        :rtype: int
        """
        if(employees is None or len(employees) == 0):
            return 0
        
        
        emap = {e.id: e for e in employees} # hash map
        
        self.dfs(emap, id) 
        return self.result
    
    def dfs(self,emap, id): # recursive function to calculate the importance
        emp = emap.get(id)
        self.result+= emp.importance
        for subid in emp.subordinates:
            self.dfs(emap, subid)
            


