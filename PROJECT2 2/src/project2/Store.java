/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

import java.util.*;

/**
 *
 * @author oytunemreozmel
 */
public class Store implements CropKeeper {

    private static int ID = 1;
    private String name;
    private double maxCapacityArea;
    private double usedCapacityArea;
    private int KGperSquareArea = 10;
    static ArrayList<Fruit> fruitList = new ArrayList();

    public static void setID(int ID) {
        Store.ID = ID;
    }

    public Store(String name, double maxCapacityArea, double usedCapacityArea) {
        this.name = name;
        this.maxCapacityArea = maxCapacityArea;
        this.usedCapacityArea = usedCapacityArea;
    }

    public Store() {

    }

    public static int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxCapacityArea() {
        return maxCapacityArea;
    }

    public void setMaxCapacityArea(double maxCapacityArea) {
        this.maxCapacityArea = maxCapacityArea;
    }

    public double getUsedCapcaityArea() {
        return usedCapacityArea;
    }

    public void setUsedCapcaityArea(double usedCapcaityArea) {
        this.usedCapacityArea = usedCapcaityArea;
    }

    public int getKGperSquareArea() {
        return KGperSquareArea;
    }

    public void setKGperSquareArea(int KGperSquareArea) {
        this.KGperSquareArea = KGperSquareArea;
    }

    public ArrayList<Fruit> getFruitList() {
        return fruitList;
    }

    public void setFruitList(ArrayList<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    public double avaibleCapacity() {
        return maxCapacityArea - usedCapacityArea;
    }

    public boolean canBeStored(Fruit f) {
        if (avaibleCapacity() > (f.getWeight() / KGperSquareArea)) {
            return true;
        } else {
            return false;
        }

    }

    public void importCrop(Fruit f) throws CapacityNotEnoughException {
        if (canBeStored(f)) {
            usedCapacityArea += (f.getWeight() / KGperSquareArea);
        } else {
            throw new CapacityNotEnoughException("Capacity Not Enough Exception");
        }
    }

    public void exportCrop(Fruit f) throws FruitNotFoundException {
        Fruit selectedFruit;
        boolean iExist = false;
        for (Fruit fruit : this.fruitList) {
            if (fruit.getName() == f.getName()) {

                selectedFruit = fruit;
                usedCapacityArea -= (selectedFruit.getWeight() / KGperSquareArea);
                this.fruitList.remove(selectedFruit);
                iExist = true;
                break;
            }

        }

        if (!iExist) {
            throw new FruitNotFoundException("Fruit Not Found Exception");
        }

    }

    @Override
    public String toString() {
        return "Store{" + "name=" + name + ", maxCapacityArea="
                + maxCapacityArea + ", usedCapacityArea=" + usedCapacityArea + ", "
                + "KGperSquareArea=" + KGperSquareArea + ", fruitList=" + fruitList + '}';
    }

    @Override
    public void HowToStore() {
        if (Store.class.equals(Fruit.class)) {
            System.out.println("fruits in large refrigerated\n"
                    + "cooler rooms");
        } else {
            System.out.println("vegetables in sheds, not listed");
        }

    }

}
