/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

/**
 *
 * @author oytunemreozmel
 */
public class Vegetable extends Crop implements Comparable<Vegetable>,CropKeeper {

    protected String cultivatedRegion;
    protected CropKeeper CropKeeper;

    Vegetable() {
        super();
    }

    public String getCultivatedRegion() {
        return cultivatedRegion;
    }

    Vegetable(String cultivatedSeason, String cultivatedRegion, String name, double weight) {
        super(name, weight, cultivatedSeason);
        this.cultivatedRegion = cultivatedRegion;

    }

    Vegetable(String cultivatedRegion) {
        this.cultivatedRegion = cultivatedRegion;
    }

    @Override
    public String toString() {
        return "Vegetable{" + "cultivatedRegion=" + cultivatedRegion + '}';
    }

    @Override
    protected String consumeIt() {
        return "Vegetables are cooked";
    }

    protected boolean StoreIt(Crop v) throws CanNotBeStoredException{
        if(CropList.add((Vegetable)v)){
             throw new CanNotBeStoredException("Can not be stored");
        }else
           return CropList.add((Crop)v);
     }

  

    @Override
    public int compareTo(Vegetable o) {
        if (o.name.equalsIgnoreCase(this.name)) {
            return 0;
        } else {
            return (int) (getWeight() - this.weight);
        }

    }

    @Override
    public void HowToStore() {
        
    }

}
