package at.fhv.ssc.singleton;

public class LazySingleton{

    private static LazySingleton _singleton;

    private LazySingleton(){}

    public static LazySingleton getInstance() {
        if(_singleton == null){
            _singleton = new LazySingleton();
        }
        return _singleton;
    }
}
