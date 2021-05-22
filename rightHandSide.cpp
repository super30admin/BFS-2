/*
Intuition: Can be done via level order traversal (BFS) going from right to left 
Can be done via DFS
///////////////////////////////
BFS Solution
Time Complexity: O(N), N = Number of Nodes
Space Complexity: O(N/2), N/2 = Max number of leaf nodes in a queue
///////////////////////////////
DFS Solution
Time Complexity: O(N), N = Number of Nodes
Space Complexity: O(H), H = Height of the tree


class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector <int> result;
        if (root == NULL) return result;
        vector <TreeNode*> queue;

        queue.push_back(root);
        
        while (queue.size() != 0){
        
            int size = queue.size();
            for (int i =0; i < size; i++){
                TreeNode* currentNode = queue.front();
                queue.erase(queue.begin());
                
                if ( i== 0 ){
                    result.push_back(currentNode->val);
                
                }
                if (currentNode->right != NULL) queue.push_back(currentNode->right);
                if (currentNode->left != NULL) queue.push_back(currentNode->left);
                
            }
        
        }
        return result;
        
    }
};

//BFS = Going from L - R
class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector <int> result;
        if (root == NULL) return result;
        vector <TreeNode*> queue;

        queue.push_back(root);
        
        while (queue.size() != 0){
        
            int size = queue.size();
            for (int i =0; i < size; i++){
                TreeNode* currentNode = queue.front();
                queue.erase(queue.begin());
                
                if ( i== size -1 ){
                    result.push_back(currentNode->val);
                
                }
                if (currentNode->left != NULL) queue.push_back(currentNode->left);

                if (currentNode->right != NULL) queue.push_back(currentNode->right);
                
            }
        
        }
        return result;
        
    }
};


///DFS - Going from Right to Left
class Solution {
public:
    vector <int> result;
    vector<int> rightSideView(TreeNode* root) {
        
        dfsHelper(root, 0);
        return result;
    }
    
    void dfsHelper(TreeNode* root,int level){
    
        //base
        if (root == NULL) return;
        
        //logic
        //Storing the element at a particular level if size matches it.
        if (result.size() == level){
            result.push_back(root->val);
        }
        dfsHelper(root->right, level +1);
        dfsHelper(root->left, level +1);
        
    
    }
};

//DFS - Going L to R
//Overwriting previous values.
class Solution {
public:
    vector <int> result;
    vector<int> rightSideView(TreeNode* root) {
        
        dfsHelper(root, 0);
        return result;
    }
    
    void dfsHelper(TreeNode* root,int level){
    
        //base
        if (root == NULL) return;
        
        //logic
        
        if (result.size() == level){
            result.push_back(root->val);
        }
        //Overwriting pervuious values.
        else{
            result[level] = root->val;
        }
        dfsHelper(root->left, level +1);
        dfsHelper(root->right, level +1);

    
    }
};