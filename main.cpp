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
    vector<int> rightSideView(TreeNode* root) {
        vector<int> result;//1
        queue<TreeNode*> q;//
        if(root == NULL){
            return result;
        }
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            for(int i = 0; i< size; i++){
                TreeNode* temp = q.front();
                if(i == size -1 ){
                    result.push_back(temp->val);
                }
                q.pop();
                if(temp->left != NULL){
                    q.push(temp->left);
                }
                if(temp->right != NULL){
                    q.push(temp->right);
                }
            }
        }
        return result;
    }
};










int main() {
    string pattern = "abba";
    string s = "dog dog dog dog";
    wordPattern(pattern,s);
    return 0;
}
