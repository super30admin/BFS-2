// Time Complexity : O(n) where n is the number of nodes
// Space Complexity : O(h) for DFS and O(n) for BFS
// Did this code successfully run on Leetcode : Yes 

// Approach 1: DFS

/*
Two conditions that need to satisfy: 
1. Parents are not the same 
2. Level is the same

In DFS, we can keep track of the level and the return the parent as well
so when we find the node, assign the x_parent and x_level and similar to y

After seeing all the nodes, compare levels and parents and resturn the result
*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    int x_level, y_level;
    //int works to track parent as the question specifies unique parents
    int x_parent, y_parent;
public:
    bool isCousins(TreeNode* root, int x, int y) {
        if(root == NULL) return false;
        // root, x, y, parent, level
        dfs(root, x, y, NULL, 0);
        // we know at what levels x and y are present and who the parents are
        return (x_level == y_level && x_parent != y_parent);

    }
    void dfs(TreeNode* root, int x, int y, int parent, int level){
        //base
        if(root == NULL) return;

        //logic
        //If we find the node, update the parent and the level
        if(root->val == x){
            x_parent = parent;
            x_level = level;
        }
        if(root->val == y){
            y_parent = parent;
            y_level = level;
        }

        dfs(root->left, x, y, root->val, level+1);
        dfs(root->right, x, y, root->val, level+1);
    }
};


//Approach 2: BFS

/*
We need to satisfy 2 conditions
1. They are in the same level 
2. The nodes are not siblings (which means they are cousins)

To process nodes in the same level, we use a for loop from 0 to the size of the queue at the beginning of each loop
The queue would have all the nodes in each level 

If one node is found, and the other is not -> return false

If both nodes are found, and they are not siblings, we return true

*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) {
        if(root == NULL) return false;

        queue<TreeNode*> q;
        q.push(root);

        while(!q.empty()){
            //this is initialied for every level
            int size = q.size();
            bool x_found = false;
            bool y_found = false;
            for(int i=0; i<size; i++){
                root = q.front();
                q.pop();

                //If we find the node in that level
                if(root->val == x)
                    x_found = true;
                if(root->val == y)
                    y_found = true;

                //if it has both children
                if(root->right && root->left){
                    //we check that it is not the 2 nodes x and y

                    if(root->left->val == x && root->right->val == y)
                        return false;
                    if(root->left->val == y && root->right->val == x)
                        return false;
                }

                //Add the childres to the queue
                if(root->left)
                    q.push(root->left);
                if(root->right)
                    q.push(root->right);
            }
            //after the 'for' loop runs, all the nodes at level n has completed processing
            //now we can check if both the nodes were found
            if (x_found && y_found)
                    return true;

            //we return false even if 1 node was found since the other node is clearly in a different level
            if (x_found || y_found)
                    return false;
        }
        
        return true;
    }
};

