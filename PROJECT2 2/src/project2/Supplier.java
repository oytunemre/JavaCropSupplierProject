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
public class Supplier implements CropKeeper {

    protected String name;
    protected int ID = 10000;
    protected int budget;
    ArrayList<Crop> cropList;

    public void setID(int ID) {
        this.ID = ID;
    }

    public Supplier() {

    }

    public Supplier(String name, int ID, int budget, ArrayList<Crop> cropList) {
        super();
        this.name = name;
        this.ID = ID;
        this.budget = budget;
        cropList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public ArrayList<Crop> getCropList() {
        return cropList;
    }

    public void buyCrop(Crop crop, Store store) throws FruitNotFoundException, FruitNotAvailableException,
            SupplierHasNotEnoughMoneyException {

        boolean cropExist = false;
        int index = -1;
        int totalPrice = 0;

        for (int i = 0; i < store.getFruitList().size(); i++) {
            if (crop.getName() == store.getFruitList().get(i).getName()) {
                cropExist = true;
                index = i;

                totalPrice = (int) (store.getFruitList().get(i).getPrice() * store.getFruitList().get(i).getWeight());

                break;
            }

            if (budget >= totalPrice) {
                if (cropExist) {
                    budget -= totalPrice;
                    cropList.add(store.getFruitList().get(index));
                    store.exportCrop(store.getFruitList().get(index));
                } else {
                    throw new FruitNotAvailableException("Fruit Not Available Exception");
                }
            }
            throw new SupplierHasNotEnoughMoneyException("Supplier Has Not Enoug Money Exception");
        }

    }

    public void sellCrop(Crop crop, Store store) throws FruitNotFoundException, CapacityNotEnoughException {

        boolean cropExist = false;
        int index = -1;
        int totalPrice = 0;

        for (int i = 0; i < store.getFruitList().size(); i++) {
            if (crop.getName() == store.getFruitList().get(i).getName()) {
                cropExist = true;
                index = i;
                totalPrice = (int) (store.getFruitList().get(i).getPrice() * store.getFruitList().get(i).getWeight());

                break;
            }

            if (cropExist) {
                budget += totalPrice;
                cropList.remove(crop);
                store.importCrop((Fruit) crop);
            } else {
                throw new FruitNotFoundException("Fruit Not Found Exception");
            }
        }

    }

    @Override
    public String toString() {
        return "Supplier{" + "name=" + name + ", ID=" + ID + ", budget=" + budget + ", cropList=" + cropList + '}';
    }

    @Override
    public void HowToStore() {
        if (Supplier.class.equals(Fruit.class)) {
            System.out.println("fruits in big refrigerators");
        } else {
            System.out.println("vegetables in the field booths");
        }
    }

}
