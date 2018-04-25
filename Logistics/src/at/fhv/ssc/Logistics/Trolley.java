package at.fhv.ssc.Logistics;
import java.util.ArrayList;

/**
 * Created by sebastian on 26.03.2017.
 * Die Klasse Trolley beschreibt Trolleya mit den Attributen Größe in Kubikzentimeter,
 * X- und Y-Position auf dem Field, einem Namen und einer ArrayList zum Laden der Produkte
 * und einer Kapazität.
 * Am Anfang werden die enums für die Himmelsrichtungen festgelegt, die der Trolley braucht,
 * um sich mit der Methode moveTrolley auf dem Field zu bewegen, hier ändern sich dann seine Koordinaten.
 * Danach kommen die Getter und Setter.
 * loadProduct lädt angegebene Produkte in den Trolley, wenn dieser nicht genug übrige Kapazität hat,
 * wird dies ausgegeben.
 * unloadProduct entlädt alle Produkte, die der Trolley geladen hat.
 * Durch den override von toString, werden alle Attribute des Trolleys und die seiner geladenen
 * Produkte ausgegeben.
 */
public class Trolley {

    public enum Direction {

        NORTH,
        SOUTH,
        WEST,
        EAST,
    }

    private int _cubicCentimeter;
    private int _posX;
    private int _posY;
    private String _name;
    private ArrayList<Product> _LoadedProducts;
    private int _capa;



    public Trolley(int cubicCentimeter, int posX, int posY, String name, int capa) {
        _cubicCentimeter = cubicCentimeter;
        _posX = posX;
        _posY = posY;
        _name = name;
        _capa = capa;
        ArrayList Listnew = new ArrayList<Product>();
        _LoadedProducts = Listnew;
    }



    public void MoveTrolley(Direction direction) {

        switch(direction){
            case NORTH:
                _posY = _posY+1;
                break;

            case SOUTH:
                _posY = _posY-1;
                break;

            case WEST:
                _posX = _posX-1;
                break;

            case EAST:
                _posX = _posX+1;
                break;

        }
    }

    public int getPosX() {
        return _posX;
    }

    public void setPosX(int posX) {
        _posX = posX;
    }

    public int getPosY() {
        return _posY;
    }

    public void setPosY(int posY) {
        _posY = posY;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public int get_cubicCentimeter() {
        return _cubicCentimeter;
    }

    public void set_cubicCentimeter(int space) {
        this._cubicCentimeter = space;
    }

    public ArrayList<Product> getLoadedProducts() {
        return _LoadedProducts;
    }

    public void setLoadedProducts(ArrayList<Product> loadedProducts) {
        _LoadedProducts = loadedProducts;
    }

    public Void loadProduct(Product Product) {
        if(_capa - Product.getCubicCentimeter() >= 0) {
            _LoadedProducts.add(Product);
            _capa = _capa - Product.getCubicCentimeter();
        }else{
            System.out.println("Trolley full, remaining capa:" + _capa);

        }
        return null;
    }

    public void unloadProduct(){
        _LoadedProducts.clear();
    }

    public int getCubicCentimeter() {
        return _cubicCentimeter;
    }

    public void setCubicCentimeter(int cubicCentimeter) {
        _cubicCentimeter = cubicCentimeter;
    }

    public int getCapa() {
        return _capa;
    }

    public void setCapa(int capa) {
        _capa = capa;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Product p : _LoadedProducts) {
            sb.append(p.toString());
            sb.append(" ### ");
        }

        return "Trolley{" +
                "_cubicCentimeter=" + _cubicCentimeter +
                ", _capa=" + _capa +
                ", _posX=" + _posX +
                ", _posY=" + _posY +
                ", _name='" + _name +
                ", _LoadedProducts=" + sb.toString() +
                '}';
    }
}

