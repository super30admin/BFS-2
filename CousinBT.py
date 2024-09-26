"""
The approach here is to keep two hashmap and keep a track of each nodes depth and it parent node in the
hashmap, and finally once we have traversed all nodes we check if the depth are same and if the parents
are not equal.
"""
def CousinBT(self,root,x,y):
    parents = {}
    depth = {}
    def dfs(curr,par=None):
        if curr:
            depth[curr.val] = 1 + depth[par.val] if par else 0
        parents[curr.val] = par
        dfs(curr.left,curr)
        dfs(curr.right,curr)
    dfs(root)
    return depth[x] == depth[y] and parents[x] != parents[y]
