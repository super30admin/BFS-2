/* Problem Statement:
Verified on leetcode

Cousins in binary tree
https://leetcode.com/problems/cousins-in-binary-tree/

In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 *
 * Time Complexity : O(n) where n is total elements in the tree
 * Space Complexity : O(1)
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

typedef struct info {
    struct TreeNode* parent;
    int depth;
    int val;
}info_t;

void isCousins_helper(struct TreeNode* root, int depth, struct TreeNode* parent, info_t *x, info_t *y) {
    
    if (root == NULL) {
        return;
    }
    /* Update x details if it is equal to root*/
    if (root->val == x->val) {
        x->parent = parent;
        x->depth = depth;
    }
    /* upate y details if it is equal to root */
    if (root->val == y->val) {
        y->parent = parent;
        y->depth = depth;
    }
    /* call for left and right subtrees */
    isCousins_helper(root->left,depth + 1, root,x,y);
    isCousins_helper(root->right,depth + 1, root,x,y);
}

bool isCousins(struct TreeNode* root, int x, int y){

    info_t xt;
    info_t yt;
    xt.parent = NULL;xt.depth = -1;xt.val = x;
    yt.parent = NULL;yt.depth = -2;yt.val = y;
    
    isCousins_helper(root, 0, NULL, &xt, &yt);
    /* condition check and return the result */
    return (xt.depth == yt.depth) && (xt.parent != yt.parent);
}



/* Execute it on LeetCode platform*/

