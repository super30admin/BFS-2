/*
Time Complexity:
O(N) as we are traversing the tree only once.
*/

/*
Space Complexity:
O(H) where H is the height of the tree
*/

/*
Approach:
We are going for BFS. Same can be achieved with dfs too. But since cousins
are at the same level, preference to BFS makes more sense.

We are maintainig a queue and add root to it to start the traversal.
Now we maintain the condition that until our queue does not get empty
we have to keep going on with our logic.

The logic is we are maintaing two bool variables to check if 
x and ya re found or not. Then at each level we aadd the children of 
the node which is at the front of the queue provided they exist and
simultaneously keep on checking if we found the values of x and y or not.
IF we found the values of x and y, there are two possibilities.
First, the values of the left and the right child are either x or y which means
that they have same parent. So they are not cusions.
Second, when we are out of the particular level and we found x and y, and none of the
conditions in the firs possibility were true. It means both x and y are the children
of different parents. So, they are cousins.

There is a third possibility too that we found only x or only y which means that they
were not at the same level. Then I do not need to go any further. 
*/


// The code ran perfectly on leetcode



class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) {
        if(root ==NULL) return false;
        queue<TreeNode*> q;
        q.push(root);// adding root to the list to start the BFS
        while(q.empty()== false){
            int size = q.size(); // maintaing the size for the level as we have condition that they should be at same level
            bool x_found = false;
            bool y_found = false;
            for(int i =0; i<size; i++){
                TreeNode *curr = q.front(); 
                q.pop(); // removing the first element of the queue as we have to move to the next node in the same level
                if(curr->val == x) x_found = true;
                if(curr->val==y) y_found = true;
                if(curr->left && curr->right){
                if(curr->left->val == x && curr->right->val == y) return false;  // both have same parents
                if(curr->left->val == y && curr->right->val == x) return false;  // same as above
                }
                if(curr->left != NULL) q.push(curr->left); 
                if(curr->right != NULL) q.push(curr->right);
            }
            if(x_found && y_found) return true; // both are at the same level but with different parents
            if(x_found || y_found) return false; // only one of them was found at a particular level
            
        }
        return false; 
    }
};