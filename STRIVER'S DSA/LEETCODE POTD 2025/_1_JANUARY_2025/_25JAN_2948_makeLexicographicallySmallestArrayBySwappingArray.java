import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _25JAN_2948_makeLexicographicallySmallestArrayBySwappingArray {
    class UnionFind {
        int[] parent, rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        // Step 1: Pair indices with their values and sort by values
        int[][] indexedNums = new int[n][2];
        for (int i = 0; i < n; i++) {
            indexedNums[i][0] = nums[i];
            indexedNums[i][1] = i;
        }
        Arrays.sort(indexedNums, Comparator.comparingInt(a -> a[0]));

        // Step 2: Initialize Union-Find
        UnionFind uf = new UnionFind(n);

        // Step 3: Merge indices if their absolute difference satisfies the limit
        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(indexedNums[i][0] - indexedNums[i + 1][0]) <= limit) {
                uf.union(indexedNums[i][1], indexedNums[i + 1][1]);
            }
        }

        // Step 4: Group indices by connected components
        Map<Integer, List<Integer>> components = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            components.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        // Step 5: Sort values within each connected component
        int[] result = new int[n];
        for (List<Integer> component : components.values()) {
            // Extract values, sort them, and place them back
            List<Integer> values = new ArrayList<>();
            for (int idx : component) {
                values.add(nums[idx]);
            }
            Collections.sort(values);
            Collections.sort(component);
            for (int i = 0; i < component.size(); i++) {
                result[component.get(i)] = values.get(i);
            }
        }

        return result;
    }
}
