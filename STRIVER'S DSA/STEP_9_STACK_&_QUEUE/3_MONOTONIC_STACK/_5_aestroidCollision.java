import java.util.ArrayList;
import java.util.List;

public class _5_aestroidCollision {
    public int [] asteroidCollision(int[] asteroids) {
        List<Integer> stack = new ArrayList<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stack.add(asteroids[i]);
            } else {
                while (!stack.isEmpty() && stack.get(stack.size() - 1) > 0
                        && stack.get(stack.size() - 1) < Math.abs(asteroids[i])) {
                    stack.remove(stack.size() - 1);
                }
                if (!stack.isEmpty() && stack.get(stack.size() - 1) == Math.abs(asteroids[i])) {
                    stack.remove(stack.size() - 1);
                } else if (stack.isEmpty() || stack.get(stack.size() - 1) < 0) {
                    stack.add(asteroids[i]);
                }
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}
