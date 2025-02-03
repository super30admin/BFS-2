# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    ### BFS SOLUTION ###
    # TC - O(n)
    # Sc - O(n)
    # def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
    #     ## null check case
    #     if root == None:
    #         return []
    #     ## DS
    #     queue = deque()
    #     result = []
    #     queue.append(root)
    #     while len(queue)!=0:
    #         size = len(queue)
    #         currentelement = None
    #         for i in range (size):
    #             currentelement = queue.popleft()
    #             if currentelement.left:
    #                 queue.append(currentelement.left)  
    #             if currentelement.right:
    #                 queue.append(currentelement.right)

    #             # if i == size-1:
    #         result.append(currentelement.val)
    #     return result 

    ## DFS APROACH ##
    def __init__(self):
        self.result = []
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]: 
        self.dfs(root,0)
        return self.result

    
    def dfs(self,root,depth) :
        ## base condition
        if root == None:
            return

        if depth == len(self.result):
            self.result.append(root.val)
        else:
            self.result[depth] = root.val       

        ## logic
        self.dfs(root.left,depth+1)
        self.dfs(root.right, depth+1)







        
