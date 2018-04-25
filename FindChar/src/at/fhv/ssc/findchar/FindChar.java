package at.fhv.ssc.findchar;

public class FindChar {


    /**
     * looks for the first appearance of a char in a String either from left, right or a random position.
     * */

    public FindChar(){

    }


   /**
    * looks for the first appearance of a char in String from left, returns their index.
    * BEST CASE: char is on the first index of the String. O(1)
    * WORST CASE: char is on the last index of the String. O(n)
    * AVERAGE CASE: char is on a random index of the String. O(26)
    * */
    public int findCharLeft(String str, char ch){

        int index = 0;
        boolean found = false;
        int i = 0;

        while(i <str.length() && !found){

            if (str.charAt(i) == ch) {
                index = i;
                found = true;
            }
            i++;
        }
        return index;
    }

    /**
     * looks for the first appearance of a char in String from right, returns their index.
     * * BEST CASE: char is on the last index of the String. O(1)
     * WORST CASE: char is the first index of the String. O(n)
     * AVERAGE CASE: char is on a random index of the String. O(26)
     * */
    public int findCharRight(String str, char ch){

    int index = 0;
    boolean found = false;
    int i = str.length()-1;

        while(i >0 && !found ){

        if (str.charAt(i) == ch) {
            index = i;
            found = true;
        }
        i--;
    }
        return index;
    }

    /**
     * looks for the first appearance of a char in String from a random position, returns their index.
     * * BEST CASE: char is on the first random index of the String. O(1)
     * WORST CASE: char (random index) is never found in the String.
     * AVERAGE CASE: char is on a random index of the String.
     * */
    public int findCharRandom(String str, char ch){

        int index = 0;
        boolean found = false;

        while(!found ){

            int random;
            random = (int)(Math.random() * (str.length()));

            if (str.charAt(random) == ch) {
                index = random;
                found = true;
        }
    }
        return index;
    }
}