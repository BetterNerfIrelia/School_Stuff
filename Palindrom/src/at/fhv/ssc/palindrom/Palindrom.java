package at.fhv.ssc.palindrom;
/**
 * Created by sebastian on 28.04.2017.
 */
public class Palindrom {

    public Palindrom() {
    }

    boolean checkPalindrome(String inputString) {
        int i = 0;
        int j = inputString.length() - 1;

        while(i <= (inputString.length())/2){
            if(inputString.charAt(i) == inputString.charAt(j)){
                i++;
                j--;
            }else{return false;}
        }
        return true;
    }




}

