class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();

        int r = 1;
        int l = 0;
        int result = 0;

        while (r < s.length()){
            String sub = s.substring(l,r + 1);
            if (sub.indexOf(s.charAt(r)) != sub.lastIndexOf(s.charAt(r))){
                l++;
            } else {
                result = Math.max(result, sub.length());
                r++;
            }
        }
        return result;
    }
}
