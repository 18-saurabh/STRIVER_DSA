import java.util.HashMap;
import java.util.Map;

public class _17FEB_1079_letterTilesPossibilities {
    public int numTilePossibilities(String tiles) {
               Map<Character, Integer> freqMap = new HashMap<>();
        
        // Count frequencies of each character
        for (char c : tiles.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        return backtrack(freqMap);
    }

    private int backtrack(Map<Character, Integer> freqMap) {
        int count = 0;
        
        for (char c : freqMap.keySet()) {
            if (freqMap.get(c) > 0) {
                // Use this character
                count++;
                freqMap.put(c, freqMap.get(c) - 1);
                
                // Recursively explore further possibilities
                count += backtrack(freqMap);
                
                // Restore the character for next iterations
                freqMap.put(c, freqMap.get(c) + 1);
            }
        }
        
        return count;
    }
}
