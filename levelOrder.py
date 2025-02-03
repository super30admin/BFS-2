# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    ## BFS SOLUTION
    ## TC - O(n)
    ## Sc - O(n)
    # def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
    #     if root == None:
    #         return []
    #     queue = deque()
    #     queue.append(root)
    #     result = []
    #     while len(queue)!=0:
    #         size = len(queue)
    #         sublist = []
    #         for i in range(size):
    #             current = queue.popleft()
    #             if current.left:
    #                 queue.append(current.left)
    #             if current.right:
    #                 queue.append(current.right)
    #             sublist.append(current.val)
    #         result.append(sublist)
    #     return result

    ## DFS Solution
    # TC - O(n)
    # Sc - O(n)
    def __init__(self):
        self.result = []

    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root == None:
            return []
        self.dfs(root,0) 
        return self.result   
    
    def dfs(self,root,depth):
        if root == None:
            return

        if depth == len(self.result):
            self.result.append([root.val])
        else:
            self.result[depth].append(root.val)

        self.dfs(root.left,depth+1)
        self.dfs(root.right, depth+1)



        
