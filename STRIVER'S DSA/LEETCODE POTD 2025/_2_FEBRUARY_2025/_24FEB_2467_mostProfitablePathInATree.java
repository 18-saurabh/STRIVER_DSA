import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _24FEB_2467_mostProfitablePathInATree {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++)
            tree.add(new ArrayList<>());

        // Build the adjacency list representation of the tree
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        // Step 1: Find Bob's path from bob to 0
        int[] bobTime = new int[n];
        Arrays.fill(bobTime, Integer.MAX_VALUE);
        findBobPath(bob, 0, 0, -1, tree, bobTime);

        // Step 2: DFS for Alice to find max net income
        return dfsAlice(0, 0, -1, tree, bobTime, amount);
    }

    private boolean findBobPath(int node, int time, int target, int parent, List<List<Integer>> tree, int[] bobTime) {
        if (node == target) { // Reached node 0
            bobTime[node] = time;
            return true;
        }
        for (int neighbor : tree.get(node)) {
            if (neighbor == parent)
                continue;
            if (findBobPath(neighbor, time + 1, target, node, tree, bobTime)) {
                bobTime[node] = time;
                return true;
            }
        }
        return false;
    }

    private int dfsAlice(int node, int time, int parent, List<List<Integer>> tree, int[] bobTime, int[] amount) {
        int currentIncome;
        if (time < bobTime[node]) {
            currentIncome = amount[node]; // Alice alone
        } else if (time == bobTime[node]) {
            currentIncome = amount[node] / 2; // Alice and Bob split
        } else {
            currentIncome = 0; // Bob already opened it
        }

        int maxIncome = Integer.MIN_VALUE;
        boolean isLeaf = true;
        for (int neighbor : tree.get(node)) {
            if (neighbor == parent)
                continue;
            isLeaf = false;
            maxIncome = Math.max(maxIncome, dfsAlice(neighbor, time + 1, node, tree, bobTime, amount));
        }

        return currentIncome + (isLeaf ? 0 : maxIncome);
    }
}
