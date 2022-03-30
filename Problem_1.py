# Time Complexity:O(n)
# Space Complexity:O(d)
# Did it run on Leetcode: YES
# Did you have any problems: No
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        queue = [root]
        ans=[]
        while queue:
            temp=[]
            for i in range(len(queue)):
                x = queue.pop(0)
                if x is not None:
                    temp.append(x.val)
                    queue.append(x.left)
                    queue.append(x.right)
            if len(temp) !=0:
                ans.append(temp[-1])
        return ans
        