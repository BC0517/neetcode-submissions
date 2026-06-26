class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int l = 0;
        
        for (int r = 0; r < s.length(); r++){
            char c = s.charAt(r);

            if(map.containsKey(c)){
                l = Math.max(map.get(c) + 1, l);    //Update left pointer
            }

            map.put(c, r);                          //Add new character or update val of existing character
            res = Math.max(res, r - l + 1);         //Update max val if necessary
        }
        return res;
    }
}
