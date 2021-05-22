/*

There are 2 things to be checked if 2 nodes have to checked if they are cousins.
1) Same depth - Can be checked by using level order traversal
2) Different parents - Can be checked by storing the parent node with the current node in the queue.

There are 2 approaches. We can check depth first and then parents or parent first and then depth.

Depth First Check
///////////////////////////////////////////
Time Complexity : O(N), Total number of nodes
Space Complexity : O(N/2) where N/2 = size of leaf nodes.
///////////////////////////////////////////


Parent First Check
///////////////////////////////////////////
Time Complexity : O(N), Total number of nodes
Space Complexity : O(N/2) where N/2 = size of leaf nodes.
///////////////////////////////////////////

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
        
        vector <pair<TreeNode*, TreeNode*> > queue;
        queue.push_back({root, NULL});
        pair<TreeNode*, TreeNode*> tempNode;
        while (queue.size()!= 0){
            
            int size = queue.size();
            bool foundFirstChild = false;
            for(int i =0; i <size; i++){
            
                pair<TreeNode*, TreeNode*> currentNode = queue.front();
                queue.erase(queue.begin());
                cout <<currentNode.first->val<<endl;
                if (currentNode.first->val == x or currentNode.first->val == y){
                    
                    if (foundFirstChild == false){
                        tempNode = currentNode;
                        foundFirstChild = true;
                    }
                    else if (foundFirstChild == true){
                        if( tempNode.second->val != currentNode.second->val){
                            return true;
                        }
                    }
                }
                if (currentNode.first->left != NULL){
                    queue.push_back({currentNode.first->left, currentNode.first});
                }
                if (currentNode.first->right != NULL){
                    queue.push_back({currentNode.first->right, currentNode.first});
                }
    
            }
            if(foundFirstChild == true){
                return false;
            }
        }
        return false;
        
    }
};


////Doing the parent check first
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
        
        vector<TreeNode*> queue;
        queue.push_back(root);
        while (queue.size()!= 0){
            
            int size = queue.size();
            bool foundX = false; bool foundY = false;
            for(int i =0; i <size; i++){
            
                TreeNode* currentNode = queue.front();
                queue.erase(queue.begin());
                
                if (currentNode->val == x){
                    foundX = true;    
                }
                if (currentNode->val == y){
                    foundY = true;    
                }
                if(currentNode->left != NULL and currentNode->right != NULL){
                    
                    if (currentNode->left->val == x and currentNode->right->val == y) return false;
                    if (currentNode->left->val == y and currentNode->right->val == x) return false;
                
                }
                    
                if (currentNode->left != NULL){
                    queue.push_back(currentNode->left);
                }
                if (currentNode->right != NULL){
                    queue.push_back(currentNode->right);
                }
    
            }
            if (foundY and foundX) return true;
            if (foundY or foundX) return false;
        }
        return false;
        
    }
};