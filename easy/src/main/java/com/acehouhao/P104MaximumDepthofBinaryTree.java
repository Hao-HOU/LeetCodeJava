package com.acehouhao;

/**
 * @author houhao
 * @email houhao118@163.com
 * @date 2018/5/14 15:12
 */
public class P104MaximumDepthofBinaryTree {

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
