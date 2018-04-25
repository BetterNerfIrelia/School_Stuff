package at.fhv.ssc.cheesechecker2;

public class Main {

    public static void main(String [] args){


        /**
         * compares cheeses. yes, really.
         * evaluates count of holes and scope of the biggest hole.
         * holes doesnt touch each other.
         * holes arent at the edge of the cheese.
         * holes are always consistent.
         */

        Cheese testcheese = new Cheese(4,4);
        CheeseChecker testchecker = new CheeseChecker();
        // testcheese.createTestCheeseOne();
        testcheese.createTestCheeseTwo();
        testcheese.printCheese();
        testchecker.setCheese(testcheese);

        System.out.println(testchecker.checkCheese());




    }

}
