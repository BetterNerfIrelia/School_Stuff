package at.fhv.ssc.singleton;

public class InstantSingleton{

    private static InstantSingleton _singleton = new InstantSingleton();

    private InstantSingleton(){}

    public static InstantSingleton getInstance() {
        return _singleton;
    }
}
