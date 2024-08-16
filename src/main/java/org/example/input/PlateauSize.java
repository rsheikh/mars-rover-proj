package org.example.input;

import java.util.ArrayList;

public class PlateauSize {
    private static PlateauSize instance;

    private int sizeX;
    private int sizeY;

    private ArrayList<Rover> rovers;

    public static PlateauSize getInstance() {
        return instance;
    }

    public static void setInstance(PlateauSize instance) {
        PlateauSize.instance = instance;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    private PlateauSize(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public static PlateauSize getInstance(int sizeX, int sizeY) {
        if(instance == null) {
            instance = new PlateauSize(sizeX, sizeY);
        }
        return instance;
    }

    public ArrayList<Rover> getRovers() {
        return rovers;
    }

    public void setRovers(ArrayList<Rover> rovers) {
        this.rovers = rovers;
    }

    //    public PlateauSize(int sizeX, int sizeY) {
//       if(sizeX <= 0 || sizeY <= 0)
//            throw new IllegalArgumentException("Values for the Plateau cannot be less than 0");
//
//       this.sizeX = sizeX;
//       this.sizeY = sizeY;
//    }
}
