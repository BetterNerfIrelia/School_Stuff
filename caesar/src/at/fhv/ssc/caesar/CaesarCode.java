package at.fhv.ssc.caesar;
/**In der Methode encode wird ein StringBuilder mit der Laenge des inputStrings erstellt.
 * Die Werte werden an den outputString übergeben.
 * Wenn der angegebene Offset > 26 ist, wird eine Fehlermeldung ausgegeben.
 * Wenn nicht, wird der String (zuerst auf Gross- dann auf Kleinbuchstaben) durchsucht.
 * Alle gefundenen Buchstaben werden in der Ascii-Tabelle um den angegebenen Offset verschoben.
 * Sollte durch das Verschieben das Ende des Alphabets erreicht werden, springt es zum Anfang dessen.
 * Am Ende wird der outputString als String ausgegeben.
 * Die Methode decode funktioniert genau umgekehrt, wobei der Offset * -1 genommen wird.**/
public class CaesarCode {

    public static String encode(String inputString, int offset) {

        StringBuilder outputString = new StringBuilder(inputString.length());
        outputString.append(inputString);

        if (offset > 26){return "offset > 26";}
        for (int i = 0; i < inputString.length(); i++) {
            char ch = outputString.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                    ch = (char) (ch + offset);
                    if (ch > 'Z') {
                        ch = (char) (ch - 26);
                }
                outputString.setCharAt(i, ch);
            }

            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch + offset);
                if (ch > 'z') {
                    ch = (char) (ch - 26);
                }
                outputString.setCharAt(i, ch);
            }

        }
        return outputString.toString();
    }

    public static String decode(String inputString, int offset) {

        StringBuilder outputString = new StringBuilder(inputString.length());
        outputString.append(inputString);
        offset = offset*(-1);

        if (offset < -26){return "offset > 26";}
        for (int i = 0; i < inputString.length(); i++) {
            char ch = outputString.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + offset);
                if (ch < 'A') {
                    ch = (char) (ch + 26);
                }
                outputString.setCharAt(i, ch);
            }

            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch + offset);
                if (ch < 'a') {
                    ch = (char) (ch + 26);
                }
                outputString.setCharAt(i, ch);
            }

        }
        return outputString.toString();
    }
}











