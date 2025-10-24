import java.util.HashSet;
import java.util.Set;

public class _1_longestSubstringWithoutRepeatingCharacters {
     public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        int MAX_LEN=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            Set<Character>se=new HashSet<>();
            for(int j=i;j<s.length();j++){
                if(se.contains(s.charAt(j))){
                    break;
                }
                int len=j-i+1;
                MAX_LEN=Math.max(MAX_LEN,len);
                se.add(s.charAt(j));
            }
        }
        return MAX_LEN;
    }
}
