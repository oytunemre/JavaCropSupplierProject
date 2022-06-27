/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

import java.util.ArrayList;

/**
 *
 * @author oytunemreozmel
 */
     public abstract class Crop {

     java.util.ArrayList<Crop> CropList;
    protected String name;
    protected double weight;
    protected String cultivatedSeason;
    
    
    
    public ArrayList<Crop> getCropList() {
        return CropList;
    }

    public void setCropList(ArrayList<Crop> CropList) {
        this.CropList = CropList;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public String getCultivatedSeason() {
        return cultivatedSeason;
    }

    Crop() {

    }

    Crop(String n, double w, String c) {
        name = n;
        weight = w;
        cultivatedSeason = c;
    }

    protected abstract String consumeIt();
        
    protected abstract boolean StoreIt(Crop c)throws CanNotBeStoredException;
            
    
    public abstract String toString();
        
}
