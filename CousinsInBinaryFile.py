# SC : O(1)
# TC : O(n)
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
         
        res_1, res_2  = None, None
        def search(root, depth, parent, search_num):
            nonlocal res_1
            nonlocal res_2
            if root is None:
                return [depth, parent]
            if root.val==search_num:
                # print(depth, par÷ent,  root.val, parent.val)
                res_1, res_2 = depth, parent
                return [res_1, res_2]
            search(root.left, depth+1, root, search_num)
            # print("just done with s=left search")
            search(root.right, depth+1, root, search_num)
            # print("just done with rigft search")
            return [res_1, res_2]
        k = search(root, 0, None, x)
        l = search(root, 0, None, y)
        # print(k,l)
        if k[0]==l[0] and k[1]!=l[1]:
            return True
        return False
