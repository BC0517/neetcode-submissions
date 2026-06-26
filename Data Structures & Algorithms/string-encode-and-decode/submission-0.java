class Solution {

    public String encode(List<String> strs) {
        //make the list of strings into 1 string
        //Add a delimiter (special character) to tell when words start
        //Save the length of each word and add it to the front of each word then convert to an int for simplicity

        String encoded = "";
        int len = 0;
        for(String word : strs){
            len = word.length();
            encoded += len + "#" + word;
            //4#neet + 4#code + 4#love + 3#you = 4#neet4#code4#love3#you
        }
        return encoded;
    }

    public List<String> decode(String str) {
        //convert the #'s in the string to int
        //start counting characters after '#' to find the words
        //return a list of Strings

        List<String> list = new ArrayList<>();
        int len = 0;
        String word = "";
        
        int i = 0;
        int j = 0;
        while (i < str.length()){
            j = i;
            while (str.charAt(j) != '#'){
                j++;
            }
            len = Integer.parseInt(str.substring(i, j));
            word = str.substring(j+1, j + 1 + len);
            list.add(word);
            i = j + 1 + len;
        }
        return list;
    }
}
