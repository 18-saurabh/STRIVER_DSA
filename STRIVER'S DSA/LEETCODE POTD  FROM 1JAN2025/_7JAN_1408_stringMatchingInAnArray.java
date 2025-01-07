import java.util.ArrayList;
import java.util.List;

public class _7JAN_1408_stringMatchingInAnArray {
public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // Avoid duplicates in the result
                }
            }
        }
        return result;

    }
    
}