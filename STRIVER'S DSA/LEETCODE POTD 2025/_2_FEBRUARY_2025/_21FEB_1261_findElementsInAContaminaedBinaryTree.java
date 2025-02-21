import java.util.HashSet;

public class _21FEB_1261_findElementsInAContaminaedBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private HashSet<Integer> values;

    public _21FEB_1261_findElementsInAContaminaedBinaryTree(TreeNode root) {
        values = new HashSet<>();
        recoverTree(root, 0);
    }

    private void recoverTree(TreeNode node, int val) {
        if (node == null)
            return;

        node.val = val;
        values.add(val);

        recoverTree(node.left, 2 * val + 1);
        recoverTree(node.right, 2 * val + 2);
    }

    public boolean find(int target) {
        return values.contains(target);
    }
}
