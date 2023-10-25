# Time Complexity : O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

# we are going to addthe values into a queue at each level. we keep a size var to keep track of number of elems in each level
# if x and y are foun in the same level and their parent nodes are not same - we return true , else false
class Solution(object):
    def isCousins(self, root, x, y):
   
        q=[]
        # pq=[]
        q.append(root)
        # pq.append(None)
        while(len(q)>0):
            size=len(q)
            bool_x, bool_y = False, False
            # parentx, parenty = None, None
            for i in range(size):
                curr=q.pop(0)
                # currpar=pq.pop(0)
                if(curr.val==x):
                    bool_x = True
                    # parentx = currpar
                if(curr.val==y):
                    bool_y=True
                    # parenty = currpar
                if(curr.left != None and curr.right != None):
                    if((curr.left.val==x and curr.right.val==y) or (curr.left.val==y and curr.right.val==x)):
                        return False
                if(curr.left != None):
                    q.append(curr.left)
                    # pq.apend(curr)
                if(curr.right != None):
                    q.append(curr.right)
                    # pq.apend(curr)
            if(bool_x and bool_y):
                return True
            if(bool_x or bool_y):
                return False
        return False