package at.fhv.ssc.makearrayconsecutive;

/**
 * Created by sebastian on 30.04.2017.
 */
public class MakeArrayConsecutive {
    public MakeArrayConsecutive() {
    }

    int makeArrayConsecutive2(int[] statues) {  //Input: [6, 2, 3, 8]   Output: 3 (4,5,7)    2:  0,3
        int min = statues[0];
        int max = statues[0];
        int numbershould = 0;
        int numberis = statues.length;

        for(int i = 0; i < statues.length; i++){
            if(statues[i] > max){
                max = statues[i];
            }
            if(statues[i] < min){
                min = statues[i];
            }
        }
        numbershould = max -1;
        return numbershould-numberis;
    }

    int bugsAndBugfixes(String rules) {    //43     "Roll d6-3 and 4d4+3 to pick a weapon, and finish the boss with 3d7!"

        int value = 0;

        for (int i = 0; i < rules.length(); i++) {
            if (rules.charAt(i) >= '0' && rules.charAt(i) <= '9') {
                value = value + (rules.charAt(i) * rules.charAt(i + 2));
                i = i + 2;
            }
            if (rules.charAt(i) == '+') {
                value = value + rules.charAt(i + 1);
                i++;
            }
            if (rules.charAt(i) == '-') {
                value = value - rules.charAt(i + 1);
                i++;
            }



        }
        return value;
    }




}
