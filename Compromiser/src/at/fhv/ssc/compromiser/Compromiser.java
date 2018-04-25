package at.fhv.ssc.compromiser;

/**
 * Created by sebastian on 10.10.2017.
 */
public class Compromiser {

    /**
     * Compromises/decompromises a string: repetitive chars >= 3 are compromised like: AAA = 3$A, BBBB = 4$B, AAAB = 3$AB.
     */

    public Compromiser() {


    }

    /**
     * Gets a plain-string and compromises into a cipher-string.
     */

    public String compromise(String plain) {

        StringBuilder str = new StringBuilder();
        int counter = 1;                                                    // to check if we have > 2 repetitive chars

        for (int i = 0; i < plain.length(); i++) {

            if (i == plain.length() - 1) {                                  //if we are at the last char of the String.

                if (counter < 2)                                            //appends last single char to String-Builder.
                {
                    str.append(plain.charAt(i));
                }

                if (counter == 2) {                                         //OR appends last double char to String-Builder.
                    str.append("" + plain.charAt(i) + plain.charAt(i));

                }
                if(counter > 2) {                                           //OR (if last char is repetitive) appends compromised repetitive chars to StringBuilder.
                    str.append("§" + counter + "§" + plain.charAt(i));
                }
                return str.toString();
            }

            if (plain.charAt(i) == plain.charAt(i + 1)) {                   // checks for repetitive chars.
                counter++;
            } else {
                if (counter > 2) {                                      //appends compromised repetitive chars to String-Builder.
                    str.append("§" + counter + "§" + plain.charAt(i));
                    counter = 1;
                } else {
                    if (counter == 2) {                                     // appends double chars to String-Builder.
                        str.append("" + plain.charAt(i) + plain.charAt(i));
                        counter = 1;
                    } else {                                                // appends single chars to String-Builder.
                        str.append(plain.charAt(i));
                    }
                }
            }
        }
        return str.toString();
    }


    /**
     * Gets a cipher-string and decompromises into a plain-string.
     */

    public String decompromise(String cipher) {

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < cipher.length(); i++) {

            if (cipher.charAt(i) == '§') {                                          //checks if next chars are compromised.
                int count = 0;
                int t = i;

                if (cipher.charAt(t + 2) != '§') {                                  //if compromise-int is multi-digit, calculates count.
                    count = Character.getNumericValue(cipher.charAt(t + 1));
                    while (Character.isDigit(cipher.charAt(t + 2))) {
                        count = count * 10 + Character.getNumericValue(cipher.charAt(t + 2));
                        t++;
                    }
                    i = t + 2;


                } else {                                                             //if compromise-int is single-digit, calculates count.
                    count = Character.getNumericValue(cipher.charAt(t + 1));
                    i = i + 2;
                }
                for (int j = count; j > 1; j--) {
                    str.append(cipher.charAt(i+1));                                  //appends chars, based on count.
                }



            } else {
                str.append(cipher.charAt(i));                                       //appends single chars.
            }


        }
        return str.toString();
    }
}



