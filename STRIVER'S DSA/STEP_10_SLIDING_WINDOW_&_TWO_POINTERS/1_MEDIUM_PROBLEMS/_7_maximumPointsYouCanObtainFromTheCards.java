public class _7_maximumPointsYouCanObtainFromTheCards {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        int rightSum = 0;
        int n = cardPoints.length;
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }
        int max_score = leftSum;
        for (int i = 1; i <= k; i++) {
            leftSum -= cardPoints[k - i];
            rightSum += cardPoints[n - i];
            max_score = Math.max(max_score, leftSum + rightSum);
        }
        return max_score;
    }
}
