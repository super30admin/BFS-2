'''
993 Cousins in Binary Tree
https://leetcode.com/problems/cousins-in-binary-tree/

Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

Two nodes of a binary tree are cousins if they have the same depth with different parents.

Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false

Constraints:
The number of nodes in the tree is in the range [2, 100].
1 <= Node.val <= 100
Each node has a unique value.
x != y
x and y are exist in the tree.

Solution:
1. BFS
Use level order traversal. While enqueing nodes, enque both the node and its parent. At each level, check if both the target node values (x,y) were encountered at that level.
yes,
    check if their parents are different
        yes: they are cousins.
        no: not cousins
no:
    if only one of the targets was encountered, then it is guaranteed that the other target is at a different level or not present at all. Hencc, they cannot be cousins.

    if none of the target nodes were encountered, then go to the next level lower.
Time: O(N), Space: O(N) (more accurately, space = O(width))
https://youtu.be/NKzhoocKWAw?t=701


2. DFS
Time: O(N), Space: O(H)
https://youtu.be/NKzhoocKWAw?t=232

'''
from binary_tree import *
from collections import defaultdict

def is_cousins_bfs1(root, x, y):
    '''
    BFS
    '''
    if not root:
        return False
    q = deque()
    q.append(root)
    level = -1
    found_x, found_y = False, False
    while q:
        level += 1
        sz = len(q)
        for _ in range(sz):
            curr = q.popleft()

            # does this node have two valid children?
            if curr.left and curr.right:
                # check if the children are x and y. If yes,
                # x, y are not cousins
                if curr.left.val == x or curr.right.val == y:
                    return False
                if curr.left.val == y or curr.right.val == x:
                    return False

            # At this point we know for sure that
            # x and y do not have the same parent
            # Hence, check if x or y are at the same level
            if curr.val == x:
                found_x = True
            if curr.val == y:
                found_y = True

            # Add children to q
            if curr.left:
                q.append(curr.left)
            if curr.right:
                q.append(curr.right)

        # end for loop over level

        # x and y are at the same level but different parents
        # -> x, y are cousins
        if found_x and found_y:
            return True

        # x and y are at different levels -> x, y are not cousins
        if found_x or found_y:
            return False

    return False

def is_cousins_bfs2(root, x, y):
    '''
    BFS (easier to follow than BFS1)
    '''
    if not root:
        return False
    q = deque()
    q.append(root)
    level = -1
    p_x, p_y = -1, -1
    d_x, d_y = -1, -2
    while q:
        level += 1
        sz = len(q)
        for _ in range(sz):
            curr = q.popleft()

            if curr.left:
                if curr.left.val == x:
                    p_x, d_x = curr.val, level+1
                elif curr.left.val == y:
                    p_y, d_y = curr.val, level+1
                q.append(curr.left)

            if curr.right:
                if curr.right.val == x:
                    p_x, d_x = curr.val, level+1
                elif curr.right.val == y:
                    p_y, d_y = curr.val, level+1
                q.append(curr.right)

        # Early termination condition: x and y are at different levels
        if d_x >= 0 and d_y < 0:
            return False
        if d_x < 0 and d_y >= 0:
            return False

    return d_x == d_y and p_x != p_y


def is_cousins_dfs(root, x, y):
    '''
    DFS
    '''
    def dfs(root, depth, x, y, parent):
        nonlocal dep_x, dep_y, p_x, p_y
        if not root:
            return
        dfs(root.left, depth + 1, x, y, root)
        if root.val == x:
            dep_x = depth
            p_x = parent
        if root.val == y:
            dep_y = depth
            p_y = parent
        dfs(root.right, depth + 1, x, y, root)

    if not root:
        return False
    dep_x = -1
    dep_y = -2
    p_x = None
    p_y = None
    dfs(root, 0, x, y, None)
    return dep_x == dep_y and p_x != p_y


def run_tests():
    tests = [([1,2,3,4],4,3,False),
             ([1,2,3,None,4,None,5],5,4,True),
             ([1,2,3,None,4],2,3,False),
    ]

    for test in tests:
        root, x, y, ans = test[0], test[1], test[2], test[3]
        tree = build_tree_level_order(root)
        if tree: tree.display()
        print(f"root = {root}")
        for method in ['bfs1','bfs2','dfs']:
            if method == 'bfs1':
                flag = is_cousins_bfs1(tree,x,y)
            elif method == 'bfs2':
                flag = is_cousins_bfs2(tree,x,y)
            elif method == 'dfs':
                flag = is_cousins_dfs(tree,x,y)
            passed = (ans == flag)
            print(f"Method '{method}': {x} and {y} are cousins? {flag}")
            assert passed == True, f"Test case failed"
            print(f"Pass: {passed}")

    print(f"\nDONE")


run_tests()