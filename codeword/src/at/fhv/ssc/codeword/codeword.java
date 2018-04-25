package at.fhv.ssc.codeword;

import java.util.HashMap;



public class codeword {
    private HashMap<String, String> hashmap;
    private int _stringCodeLength;

    public codeword(int stringCodeLength) {
        hashmap = new HashMap<>();
        _stringCodeLength = stringCodeLength;
    }

    public String addNewStudent(String userName) {

        if(hashmap.containsKey(userName)){
            return null;
        }

        String generatedPassword = "";
        do {
            generatedPassword = generateRandomString();
        } while (hashmap.containsValue(generatedPassword));

        hashmap.put(userName, generatedPassword);

        return generatedPassword;
    }

    public String getPasswordOfStudent(String userName){
        return hashmap.get(userName);
    }

    private String generateRandomString() {

        StringBuilder stringbuilder = new StringBuilder(_stringCodeLength);
        for (int i = 0; i < _stringCodeLength; i++) {
            char ch = (char) (((int) (Math.random() * 26)) + 'a');
            stringbuilder.append(ch);
        }
        return stringbuilder.toString();
    }


}
