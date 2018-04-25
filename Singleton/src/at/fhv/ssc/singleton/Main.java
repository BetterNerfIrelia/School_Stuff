package at.fhv.ssc.singleton;

public class Main {

    public static void main(String[] args){

    InstantSingleton inst = InstantSingleton.getInstance();
    LazySingleton lazy = LazySingleton.getInstance();


    String eins = "Zeas";
    eins = "Hallo";

    if(eins == "Hallo"){
        System.out.println("== Hallo");
    }else{System.out.println("!= Hallo");}

        if (eins.equals("Hallo")) {
            System.out.println("equals Hallo");
        }else{System.out.println("!equals Hallo");}
        }



    }
