import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class _23FEB_889_constructBinaryTreeFromPreorderAndPostorderTraversal {
    int preIndex = 0;
    HashMap<Integer, Integer> postMap = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // Store postorder indices in a HashMap for quick lookup
        for (int i = 0; i < postorder.length; i++) {
            postMap.put(postorder[i], i);
        }
        return construct(preorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int[] postorder, int postStart, int postEnd) {
        if (preIndex >= preorder.length || postStart > postEnd)
            return null;

        // Create the root node
        TreeNode root = new TreeNode(preorder[preIndex++]);

        // If there's only one node left, return it
        if (postStart == postEnd)
            return root;

        // Find the left subtree root in postorder
        int leftSubtreeRootIndex = postMap.get(preorder[preIndex]);

        // Recursively build left and right subtrees
        root.left = construct(preorder, postorder, postStart, leftSubtreeRootIndex);
        root.right = construct(preorder, postorder, leftSubtreeRootIndex + 1, postEnd - 1);

        return root;
    }
}
