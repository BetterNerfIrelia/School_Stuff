package at.fhv.ssc.graphplotter;

import java.awt.*;
import java.awt.Graphics;
public class Graphpannel extends Panel{

    private int fnum = 10;
    Graph graph;

    public Graphpannel(int width, int height){

        setBackground(Color.white);
        setSize(width, height);
        graph = new Graph(width, height);

    }
    @Override
    public void paint(Graphics g){
        graph.draw(g);

    }

        public class Graph {

        private int _width;
        private int _height;
        private int _scaleWidth;
        private int _scaleHeight;
        private int _border;
        private int _maxX;
        private int _maxY;
        private int _sectionDis;
        private int _distanceDim;

        public Graph(int width, int height){
            _width = width;
            _height = height;
            _scaleWidth = width / 2;
            _scaleHeight = height / 2;
            _border = 100;
            _maxX = 100;
            _maxY = 100;
            _sectionDis = 10;
            _distanceDim = 30;

        }

        private void draw(Graphics g){
            g.drawLine(_scaleWidth, _border, _scaleHeight,_height - _border);
            g.drawLine(_border, _scaleWidth, _width - _border,_scaleWidth);

            for(int i=0; i<(_scaleHeight - _border)/_distanceDim; i++){
                g.drawLine(_scaleWidth - _sectionDis /2, _scaleHeight - _distanceDim - (i*_distanceDim), _scaleWidth + _sectionDis /2, _scaleHeight - _distanceDim - (i*_distanceDim));
                g.drawLine(_scaleWidth - _sectionDis /2, _scaleHeight + _distanceDim + (i*_distanceDim), _scaleWidth + _sectionDis /2, _scaleHeight + _distanceDim + (i*_distanceDim));
                g.drawLine(_scaleWidth - _distanceDim - (i*_distanceDim), _scaleHeight - _sectionDis /2, _scaleWidth - _distanceDim - (i*_distanceDim), _scaleHeight + _sectionDis /2);
                g.drawLine(_scaleWidth + _distanceDim + (i*_distanceDim), _scaleHeight - _sectionDis /2, _scaleWidth + _distanceDim + (i*_distanceDim), _scaleHeight + _sectionDis /2);
                g.drawString(String.valueOf(_distanceDim + i*_distanceDim),_scaleWidth + _sectionDis, _scaleHeight - _distanceDim -(i*_distanceDim) +5);
                g.drawString(String.valueOf(-(_distanceDim + i*_distanceDim)),_scaleWidth + _sectionDis, _scaleHeight + _distanceDim +(i*_distanceDim) +5);
                g.drawString(String.valueOf(-(_distanceDim + i*_distanceDim)),_scaleWidth - _distanceDim -(i*_distanceDim) -5, _scaleHeight + _sectionDis *2);
                g.drawString(String.valueOf(_distanceDim + i*_distanceDim),_scaleWidth + _distanceDim +(i*_distanceDim) -5, _scaleHeight + _sectionDis *2);


            }

        }



    }


}