public class _2_celebrityProblem {
    public int celebrityIndex(int arr[][]) {
        int n = arr[0].length;
        int knowMe[] = new int[n];
        int iKnow[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    knowMe[j]++;
                    iKnow[i]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (knowMe[i] == n - 1 && iKnow[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
