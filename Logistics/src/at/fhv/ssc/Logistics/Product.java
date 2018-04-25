package at.fhv.ssc.Logistics;

/**
 * Created by sebastian on 26.03.2017.
 * Die Klasse Product beschreibt Produkte mit den Attributen Größe in Kubikzentimeter,
 * einem Namen und einer ID.
 * Danach kommen die Getter und Setter.
 * Durch den override von toString, werden alle Attribute des Produktes ausgegeben.
 */
public class Product {
    private int _cubicCentimeter;
    private String _name;
    private int _id;

    public Product (String name, int id, int cubicCentimeter) {
        _name = name;
        _id = id;
        _cubicCentimeter = cubicCentimeter;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    public int getCubicCentimeter() {
        return _cubicCentimeter;
    }

    public void setCubicCentimeter(int cubicCentimeter) {
        _cubicCentimeter = cubicCentimeter;
    }

    @Override
    public String toString() {
        return "Product{" +
                "_cubicCentimeter=" + _cubicCentimeter +
                ", _name='" + _name + '\'' +
                ", _id=" + _id +
                '}';
    }
}
