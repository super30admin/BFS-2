#include <iostream>
#include <vector>
#include <map>
#include <set>
#include <string>

using namespace std;
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
    int X_value;
    int Y_value;
    int X_level;
    int Y_level;
    int X_parent;
    int Y_parent;
    void dfs(TreeNode * root,int parent , int level){
        if(root == NULL){
            return;
        }
        if(root->val == X_value){
            X_level = level;
            X_parent = parent;
        }
        if(root->val == Y_value){
            Y_level = level;
            Y_parent = parent;
        }
        dfs(root->left,root->val,level+1);
        dfs(root->right,root->val,level+1);
    }

    bool isCousins(TreeNode* root, int x, int y) {
        X_value = x;
        Y_value = y;
        dfs(root,0,0);
        if(X_level == Y_level && X_parent != Y_parent){
            return true;
        }
        return false;
    }
};







int main() {
    string pattern = "abba";
    string s = "dog dog dog dog";
    wordPattern(pattern,s);
    return 0;
}
