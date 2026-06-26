class Solution {
    public boolean isPalindrome(String s) {
        //brute force approach: 2 pointer
        if(s.length() == 0 || s.length() == 1){
            return true;
        }
        int r = s.length() - 1;
        int l = 0;
        s = s.toLowerCase();
        
        while (l < r){ //stops when they meet in the middle
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))){ //if a letter or num isn't found it's skipped
                l++;
            }
            while(r > l && !Character.isLetterOrDigit(s.charAt(r))){ //if a letter or num isn't found it's skipped
                r--;
            }
            if(s.charAt(l) != s.charAt(r)){ //If the characters don't match it's not a palindrome
                return false;
            }
            //Increment and decrement to move to the next characters
            l++;
            r--;
        }
        
        return true;
    }
}
