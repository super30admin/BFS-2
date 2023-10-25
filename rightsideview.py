# Time Complexity : O(n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

# we are doing both right first dfs and left first bfs. In case of right first dfs- we always visit the rightmost child of a node ifit exists 
# and goes down the bath until leaf node. at each level we only keep the rightmost elem in that level in our list result. once an elem is entered into this result
# we dont mutate it at the same index / level. 
# in case of left-first bfs - we do the same but we keep editing the result list
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        # result=[]
        # q=[]
        # q.append(root)
        # while(len(q)>0):
        #     size=len(q)
        #     for i in range(size):
        #         curr=q.pop(0)
        #         if(i==size-1):
        #             if(curr is not None):
        #                 result.append(curr.val)
        #         if(curr is not None):
        #             q.append(curr.left)
        #         if(curr is not None):
        #             q.append(curr.left)
        # return result
        # O(n), O(n) - preorder with right first
        def dfs(root, level):
            if not root:
                return
            if(level==len(result)):
              result.append(root.val)
            else:
                result[level]=root.val
            
            # dfs(root.right, level+1)
            dfs(root.left, level+1)
            dfs(root.right, level+1)
        result=[]
        if not root:
            return result
        dfs(root, 0)
        return result

        # did both left first dfs and right first dfs