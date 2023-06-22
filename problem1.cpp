#include<iostream>
#include<vector>
#include<queue>

using namespace std;

typedef struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode():val(0),left(nullptr),right(nullptr){}
    TreeNode(int x):val(x),left(nullptr),right(nullptr){}
    TreeNode(int x, TreeNode* left, TreeNode* right):val(x),left(left),right(right){}
}TreeNode;

//dfs soulution

// this is a solution to right hand side view. 
// if you do it with node->left it will become left hand side view.

/*

// Time Complexity : O(N) all the nodes
// Space Complexity : O(H) height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
First go to the right subtree and check if the level exist in the result 
if doesnt then create that level in the vector and store the value else traverse the tree

*/

class Solution {
    void dfs(TreeNode* node,int level){
        if(node == NULL) return;
        if(level>res.size()) res.push_back(node->val);
        dfs(node->right,1+level);
        dfs(node->left,1+level);
    }
public:
    vector<int> res;
    vector<int> rightSideView(TreeNode* root) {
        if (root == NULL) return res;
        dfs(root,1);
        return res;
    }
};

//BFS Solution

//change q.back with q front for the given left right to chagne from right view to left view.

/*

// Time Complexity : O(N) all the nodes
// Space Complexity : O(N/2) all the leaves of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
First go through each level and store the nodes in the queue
Take the value of the last element in the queue and store its value in the result array
Traverse through all the elements present in the queue to store their children.
Repeat until all levels are done or queue is empty.

*/

class Solution {
public:
    vector<int> res;
    vector<int> rightSideView(TreeNode* root) {
        if(root == NULL) return res;
        queue<TreeNode* > q;
        q.push(root);
        while(!q.empty()){
            int sz = q.size();
            res.push_back(q.back()->val);
            for(int i{};i<sz;++i){
                if(q.front()->left) q.push(q.front()->left);
                if(q.front()->right) q.push(q.front()->right);
                q.pop();
            }
        }
        return res;
    }
};




