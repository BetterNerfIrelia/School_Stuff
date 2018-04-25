package at.fhv.ssc.cheesechecker;

public class Main {

    public static void main(String [] args){


        /**
         * compares cheeses. yes, really.
         * evaluates count of holes and scope of the biggest hole.
         * holes doesnt touch each other.
         * holes arent at the edge of the cheese.
         * holes are always consistent.


        System.out.println ("--------------------\n" +
                            "|    **            |\n" +
                            "|   *  *     *     |\n" +
                            "|   ***     * *    |\n" +
                            "|       **   *     |\n" +
                            "| *     **         |\n" +
                            "--------------------\n");

         */

        Cheese testcheese = new Cheese(3,3);
        CheeseChecker testchecker = new CheeseChecker();
        testchecker.setCheese(testcheese);
        testcheese.createTestCheeseOne();
        testcheese.printCheese();
        System.out.println("\n" + testchecker.checkCheese());






    }

}
