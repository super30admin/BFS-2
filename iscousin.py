def iscousin(root,x,y):
  tree_dict = {}
  tree = deque()
  tree.append((root,0,0))
  while len(tree)>0:
    node,parent,depth = tree.popleft()
    if node is not None:
      tree_dict[node.val] = (parent, depth) 
			tree.append((node.left, node.val, depth+1))
			tree.append((node.right, node.val, depth+1))
  return tree_dict[x][1] == tree_dict[y][1] and tree_dict[x][0]!=tree_dict[y][0]
    #tc sc is linear if x and y are at last level we will be traversing each node and tc will be o(n), we are using a queue and dictionary so sc in o(n) + o(n) === o(n)
