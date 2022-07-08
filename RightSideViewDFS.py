# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    '''Time Complexity: O(n)
    Space Complexity: O(h) --> recursive stack'''
    def __init__(self):
        self.result=[]
    def __dfs(self,root, level):
        #basecase
        if not root:
            return
        if level==len(self.result):
            self.result.append(root.val)
        else:
            '''if right first then don't replace'''
            self.result[level]=root.val
        '''Here we can also do right first and then we don't have to replace'''
        
        '''#right first
        self.__dfs(root.right, level+1)
        self.__dfs(root.left, level+1)'''
        
        #left dfs
        self.__dfs(root.left, level+1)
        #right dfs
        self.__dfs(root.right, level+1)
        
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        #DFS
        if not root:
            return None
        
        self.__dfs(root,0)
        return self.result
        
