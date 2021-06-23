

// Time - O(N)
// Space - O(N)


class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {

        // create a queue
        Queue<TreeNode> queue = new LinkedList<>();

        //add the first root value
        queue.add(root);



        while(!queue.isEmpty()) {

            // initialize sibling & cousin value to false
            boolean sibling = false;
            boolean cousin = false;

            //calculate the size of the first node inserted
            int depth = queue.size();

            for(int i = 0; i < depth; i++) {

                // remove the first node from the queue
                TreeNode node = queue.remove();

                //check if the node is null then initialize sibling to false


                // set the marker, siblings should beset to falseas we are crossing the boundary
                if(node == null) {

                    sibling = false;

                }

                else {

                    if(node.val == x || node.val == y) {

                        // set the first node in that level by setting cousin & sibling to true
                        if(!cousin){
                            sibling = cousin = true;
                        }

                        else {

                            // if the siblings flag remains true for the next node then we are in the siblings boundary

                            return !sibling;


                        }

                    }

                    if(node.left != null) queue.add(node.left); // add the left child to the queue
                    if(node.right != null)  queue.add(node.right); // add right child to the queue
                    queue.add(null); // add the marker

                }


            }


            // if the value we found is at different level

            if(cousin) return false;


        }

        // if not found
        return false;


    }
}