package org.example.input;

public class PlateauSize {
    private static PlateauSize instance;

    private int sizeX;
    private int sizeY;

    private PlateauSize(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public static PlateauSize getInstance(int sizeX, int sizeY) {
        if(instance == null) {
            instance = new PlateauSize(sizeX, sizeX);
        }
        return instance;
    }

//    public PlateauSize(int sizeX, int sizeY) {
//       if(sizeX <= 0 || sizeY <= 0)
//            throw new IllegalArgumentException("Values for the Plateau cannot be less than 0");
//
//       this.sizeX = sizeX;
//       this.sizeY = sizeY;
//    }
}
