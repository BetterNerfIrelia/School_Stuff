package at.fhv.ssc.Logistics;

/**
 * Created by sebastian on 26.03.2017.
 */
public class Field {
    private int _width;
    private int _height;

    public Field (int width, int height) {
        if ((width > 0) && (height > 0)) {
            _width = width;
            _height = height;
        }
    }
    public int getHomeX () {
        return (_width / 2);

    }

    public int getHomeY () {
        return (_height / 2);
    }

    public int getHeight() {
        return _height;
    }

    public void setHeight(int height) {
        _height = height;
    }

    public int getWidth() {
        return _width;
    }

    public void setWidth(int _width) {
        this._width = _width;
    }
}


