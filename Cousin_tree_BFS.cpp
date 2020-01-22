Time Complexity-O(n)
Space Complexity-O(n)
Did the code run on Leetcode? yes

class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) {
        if(root==NULL)
        {
            return false;
        }
        queue<TreeNode*>m;
        m.push(root);
        int level=0;
        int level_x=-1;
        int level_y=-2;
        int parent_x=-1;
        int parent_y=-2;
        while(!m.empty())
        {
            int size=m.size();
            while(size!=0)
            {
                TreeNode*a=m.front();
                m.pop();
                if(a->left!=NULL && a->left->val==x || a->right!=NULL && a->right->val==x)
                {
                    level_x=level;
                    parent_x=a->val;
                }
                if(a->left!=NULL && a->left->val==y || a->right!=NULL && a->right->val==y)
                {
                    level_y=level;
                    parent_y=a->val;
                }
                if(a->left!=NULL)
                {
                    m.push(a->left);
                }
                if(a->right)
                {
                    m.push(a->right);
                }
                size--;
            }
            level++;
        }
        if(level_x==level_y && parent_x!=parent_y)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
};
