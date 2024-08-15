package org.example.input;

public class PlateauSize {
    int sizeX;
    int sizeY;

    public PlateauSize(int sizeX, int sizeY) {
       if(sizeX <= 0 || sizeY <= 0)
            throw new IllegalArgumentException("Values for the Plateau cannot be less than 0");

       this.sizeX = sizeX;
       this.sizeY = sizeY;
    }
}
