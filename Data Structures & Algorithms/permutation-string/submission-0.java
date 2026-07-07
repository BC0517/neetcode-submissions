class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> target = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();

        int l = 0;
        
        for(int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            target.put(c, target.getOrDefault(c, 0) + 1);
        }

        System.out.println(target);

        for(int r = 0; r < s2.length(); r++){
            char curr = s2.charAt(r);
            window.put(curr, window.getOrDefault(curr, 0) + 1);

            System.out.println(window);

            while (r - l + 1 > s1.length()){
                char left = s2.charAt(l);
                window.put(left, window.get(left) - 1);
                window.remove(left,0);
                l++;
            }

            if (window.equals(target)){
                return true;
            }
        }

        return false;
    }
}