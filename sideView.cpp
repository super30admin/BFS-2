// Time Complexity : O(n) where n is the number of nodes
// Space Complexity : O(n) for BFS and O(h) for DFS
// Did this code successfully run on Leetcode : Yes 

 //Approach 1: BFS
 /*
 We add the (queue_size-1) node from the queue to the result at every level
 the n-1 node which is the last node in the queue before adding the children would be the last node in that level 
 Ex: We would have added 2 and 3
 size = 2
 we add 3 to the result at i = size -1 = 1
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
    vector<int> rightSideView(TreeNode* root) {
        if(root == NULL) return vector<int>();
        queue <TreeNode*> q;
        vector<int> result;
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                root = q.front();
                q.pop();
                if(i==size-1)  
                    result.push_back(root->val);
                if(root->left)
                    q.push(root->left);
                if(root->right)
                    q.push(root->right);
            }
        }
        return result;
    }
};



// Approach 2: DFS

/*
Do a preorder traversal 
Root Right Left 

In DFS, we can keep track of the level of the nodes, so when the level is equal to the size of the result, add the node
This works because the first node we see in each node would be the right most node
Iteration of the example:

1. L0 result.size = 0
	we add the node 1
2. L1 result.size = 1
	we add the node 3
3. L2 size = 2
	we add the node 4
.
.
.
All the null childres are processed
When it goes to 2, the level is L1 but the result size is 3. Do nothing
.
.
.

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
    vector<int> result;
    vector<int> rightSideView(TreeNode* root) {
        if(root == NULL) return vector<int>();
        dfs(root, 0);
        return result;
    }
    void dfs(TreeNode* root, int level){
        //base
        if(root == NULL) return;
        if(level == result.size())
            result.push_back(root->val);
        
        //Important to process right node first 
        //This is why we get right view of the tree
        dfs(root->right, level+1);
        dfs(root->left, level+1);

    }
};

//Approach 3: Preorder traversal 
//Root Left Right 

/*
We do the same as the preorder traversal, but keep replacing the vaule in the result if that index already present
*/

class Solution {
public:
    vector<int> result;
    vector<int> rightSideView(TreeNode* root) {
        if(root == NULL) return result;
        dfs(root, 0);
        return result;
    }
    void dfs(TreeNode* root, int level){
        //base
        if(root == NULL) return;

        //logic
        if(level == result.size())
            result.push_back(root->val);
        else
            result[level] = root->val;

        //recurse
        dfs(root->left, level+1);
        dfs(root->right, level+1);
    }
};
