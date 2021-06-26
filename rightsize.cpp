
/**

Tried solving using BFS and DFS both 
BFS-
Time Complexity O(n)
Space Complexity O(n)

DFS-
Time Complexity O(n)
Space Complexity O(n)
 */
class Solution {
public:
     
        vector<int> temp;
    vector<int> rightSideView(TreeNode* root) {
        if(root==nullptr)
            return temp;
        
        dfs(root,0);
        return temp;
    }
    
    void dfs(TreeNode* node, int level)
    {
        
        if(node==nullptr)
            return;
        if(temp.size()==level)
            temp.push_back(node->val);  
       
        dfs(node->right, level+1); //start from the right side
         dfs(node->left,level+1);
            
    }
    /*void bfs(TreeNode* node) //BFS
    {
        queue<TreeNode*> q;
        q.push(node);
        
        while(!q.empty())
        {
            int len=q.size(); //how many nodes to process at each level
            for(int i=0;i<len;i++)
            {
                TreeNode* n=q.front(); //get the front from the queue
                q.pop();
                
                if(n->left!=nullptr)
                    q.push(n->left);
                if(n->right!=nullptr)
                    q.push(n->right);
                if(i==len-1)
                    temp.push_back(n->val);
            }
            
        }
    }*/
};
