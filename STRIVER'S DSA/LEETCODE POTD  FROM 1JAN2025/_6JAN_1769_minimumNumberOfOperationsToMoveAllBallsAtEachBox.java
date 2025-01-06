public class _6JAN_1769_minimumNumberOfOperationsToMoveAllBallsAtEachBox {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

        // Prefix pass (Left-to-Right)
        int count = 0, moves = 0;
        for (int i = 0; i < n; i++) {
            answer[i] += moves;
            count += boxes.charAt(i) - '0'; // Count the number of balls
            moves += count; // Add the number of balls to the moves
        }

        // Suffix pass (Right-to-Left)
        count = 0;
        moves = 0;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] += moves;
            count += boxes.charAt(i) - '0'; // Count the number of balls
            moves += count; // Add the number of balls to the moves
        }

        return answer;
    }
}
