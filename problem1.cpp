//Time Complexity -O(N)
//Space Complexity - O(N)
class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int>v;
        if(!root)
            return v;
        queue<TreeNode*>q;
        q.push(root);
        while(!q.empty()){
            v.push_back(q.back()->val);
            int n=q.size();
            while(n>0){
                if(q.front()->left)
                    q.push(q.front()->left);
                if(q.front()->right)
                    q.push(q.front()->right);
                q.pop();
                n--;
            }
        }
        return v;
    }
};