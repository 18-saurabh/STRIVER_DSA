public class _9JAN_2185_countWordsWithAGivenPrefix {

     public int prefixCount(String[] words, String pref) {
        int n = words.length;
        int cnt = 0;
        int len1 = pref.length();// prefix length
        for (int i = 0; i < n; i++) {
            int len2 = words[i].length();
            if (len2 < len1) {
                continue; // if String at words[i] length is smaler then the prefix then skip that part;
            }
            if (words[i].startsWith(pref)) {
                cnt++;
            }
        }
        return cnt;
    }
}