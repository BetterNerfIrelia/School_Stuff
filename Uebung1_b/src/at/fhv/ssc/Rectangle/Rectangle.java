package at.fhv.ssc.Rectangle;

public class Rectangle {
	private Point 		_position;
	private int 		_width;
	private int 		_height;

	public Rectangle(Point position, int width, int heigth) {
		_width = width;
		_height = heigth;
		_position = position;
	}

	public Rectangle(int x, int y, int width, int heigth) {
		this (new Point(x,y),width,heigth);
	}

	public Point getPosition() {
		return _position;
	}

	public int getWidth() {
		return _width;
	}

	public int getHeight() {
		return _height;
	}

	public void setNewPos(Point newPos){
		_position = newPos;
	}

	public void changePosition(int byX, int byY) {
		_position.setX(_position.getX() + byX);
		_position.setY(_position.getY() + byY);
	}

	public boolean isSquare() {
		if (_width == _height) {
			return true;
		} else {
			return false;
		}
	}

	public int getPerimeter () {
		return 2*(_width+_height);
	}

	public void zoomAt (double factor) {
		if (factor != 0) {
			int newWidth = (int)(_width * factor); 
			int newHeigth = (int)(_height * factor);
			
			_position.setX(_position.getX() - ((newWidth - _width) /2));
			_position.setY(_position.getY() - ((newHeigth - _height) /2));
			
			_width = newWidth;
			_height = newHeigth;
		}
	}

	public Rectangle[] divideTo4() {
		Rectangle[] newRectangles = new Rectangle[4];
		newRectangles[0] = new Rectangle(new Point(_position.getX(),_position.getY()), _width/2, _height/2);
		newRectangles[1] = new Rectangle(new Point(_position.getX(),_position.getY() + _height/2), _width/2, _height/2);
		newRectangles[2] = new Rectangle(new Point(_position.getX()+ _width/2,_position.getY() + _height/2), _width/2, _height/2);
		newRectangles[3] = new Rectangle(new Point(_position.getX()+ _width/2,_position.getY()), _width/2, _height/2);
		return newRectangles;
	}
}