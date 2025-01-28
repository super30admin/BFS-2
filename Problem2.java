public class Problem2 {

    bfs{
        //T.c - >O(n)
        //S.c->O(n)
        boolean xFound, yFound;// these var will be use to determine if we found x and y
        public boolean isCousins(TreeNode root, int x, int y) {
            if(root == null){
                return false;
            }
            xFound = false;
            yFound = false;
            return bfs(root,x,y);
        }

        private boolean bfs(TreeNode root, int x, int y){
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int size = q.size();
                for(int i = 0;i<size;i++){
                    TreeNode curr = q.poll();
                    //1) check if we have valid left and right child and if their values are equal to x and y and return false as parent can't be same
                    if(curr.left != null && curr.right != null){
                        if(curr.left.val == x && curr.right.val == y){
                            return false;
                        }
                        if(curr.left.val == y && curr.right.val == x){
                            return false;
                        }
                    }
                    //2) check the curr node value equal to x /y
                    if(curr.val == x){
                        xFound = true;
                    }
                    if(curr.val == y){
                        yFound = true;
                    }
                    if(curr.left != null){
                        q.add(curr.left);
                    }
                    if(curr.right != null){
                        q.add(curr.right);
                    }
                }
                //if both we're found at the end of loop it means the level is same
                if(xFound && yFound){
                    return true;
                }
                //if any one is found at the end of loop it means the level is not gonna be same
                if(xFound || yFound){
                    return false;
                }
            }
            return false;
        }


        dfs{
            //T.c - >O(n)
            //S.c->O(H)
            TreeNode xParent, yParent; // this will hold the parent value at the time of recurssion
            int xLevel,yLevel;// this will hold the level value
            public boolean isCousins(TreeNode root, int x, int y) {
                if(root == null){
                    return false;
                }
                xParent = null;
                yParent = null;
                xLevel = -1;
                yLevel = -1;
                dfs(root,null,0,x,y);
                return ((xParent != yParent) && (xLevel == yLevel));//if both the parents are not equal and level are same return true or else false
            }

            private void dfs(TreeNode root,TreeNode parent, int level, int x, int y){
                //base
                if(root == null){
                    return;
                }
                //if we found x /y add the parent and level
                if(root.val == x){
                    xParent = parent;
                    xLevel = level;
                }
                if(root.val == y){
                    yParent = parent;
                    yLevel = level;
                }
                //recursive
                dfs(root.left,root,level+1,x,y);
                dfs(root.right,root,level+1,x,y);
            }
        }
    }
}
