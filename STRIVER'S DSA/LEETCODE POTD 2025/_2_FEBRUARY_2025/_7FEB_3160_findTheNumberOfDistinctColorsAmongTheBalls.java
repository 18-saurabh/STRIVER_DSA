import java.util.HashMap;
import java.util.Map;

public class _7FEB_3160_findTheNumberOfDistinctColorsAmongTheBalls {
    public int[] countDistinctColors(int limit, int[][] queries) {
        Map<Integer, Integer> ballColorMap = new HashMap<>(); // Maps ball -> color
        Map<Integer, Integer> colorCountMap = new HashMap<>(); // Maps color -> count of balls with that color
        int[] result = new int[queries.length];
        int distinctColors = 0;

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            // Check if the ball already has a color
            if (ballColorMap.containsKey(ball)) {
                int oldColor = ballColorMap.get(ball);

                // Reduce count of the old color
                colorCountMap.put(oldColor, colorCountMap.get(oldColor) - 1);
                if (colorCountMap.get(oldColor) == 0) {
                    colorCountMap.remove(oldColor);
                    distinctColors--; // If no balls left with this color, reduce distinct count
                }
            }

            // Assign the new color
            ballColorMap.put(ball, color);
            colorCountMap.put(color, colorCountMap.getOrDefault(color, 0) + 1);

            // If the color was not present before, increase distinct count
            if (colorCountMap.get(color) == 1) {
                distinctColors++;
            }

            result[i] = distinctColors;
        }
        return result;
    }
}