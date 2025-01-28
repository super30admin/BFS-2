############# Right side view of a binary tree

# Time Complexity :  O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# perform bfs and get the last element of the level this is the right most element.

def right_side_view(root):
        if not root:
            return []
        result = []
        q = []
        q.append(root)
        while q:
            len_q = len(q)
            v= None
            for j in range(len_q):
                v = q.pop(0)
                if v.left:
                    q.append(v.left)
                if v.right:
                    q.append(v.right)
            result.append(v.val)
        return result
        

