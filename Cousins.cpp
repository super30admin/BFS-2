// TC: O(N), SC:O(2^H):

// BFS solution
class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) {
 
        queue<TreeNode*>q;
        q.push(root);

        while(!q.empty())
        {
            int s=q.size();
            bool xflag=false;
            bool yflag=false;
           
           
            for(int i=0;i<s;i++)
            {
                TreeNode* a=q.front();
                q.pop();
                // checking common parent conditions
                if((a->left && a->left->val==x)&&(a->right && a->right->val==y))
                {
                    return false;
                }

                if((a->left && a->left->val==y)&&(a->right && a->right->val==x))
                {
                    return false;
                }

                if(a->val==x)
                xflag=true;

                if(a->val==y )
                yflag=true;


                if(a->left!=nullptr)
                q.push(a->left);

                if(a->right!=nullptr)
                q.push(a->right);

         
            }
            if(xflag==true && yflag==true)
            return true;
            if(xflag==true || yflag==true)
            return false;
    
         
        }

        return true;
    }
};

TC:O(N)
SC:O(2^H)
// DFS solution

class Solution {
public:
    TreeNode* xpar;
    TreeNode* ypar;
    int xlvl,ylvl;
    bool isCousins(TreeNode* root, int x, int y) 
    {
        if(root==nullptr)
         return false;

        cousins(root,nullptr,x,y,0);

        if(xpar != ypar && xlvl == ylvl)
        {
           return true;
        }
        return false;
    }

    void cousins(TreeNode* root,TreeNode* par,int x,int y,int lvl)
    {
            if(root==nullptr)
                return;
            
            if(root->val==x)
            {
                xpar=par;
                xlvl=lvl;
            }

            if(root->val==y)
            {
                ypar=par;
                ylvl=lvl;
            }

            cousins(root->left,root,x,y,lvl+1);
            cousins(root->right,root,x,y,lvl+1);

         
    }
}
