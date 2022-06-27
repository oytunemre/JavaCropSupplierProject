/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

import java.util.ArrayList;

/**
 *
 * @author oytunemreozmel
 *
 */
public class Fruit extends Crop implements Comparable<Fruit>, CropKeeper {

    protected String taste;
    protected double price;
    protected Crop Cropkeeper;
    protected String color;
    protected CropKeeper CropKeeper;

    String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    Fruit() {
        super();
    }

    Fruit(String taste, double price,String n,int w,String c) {
        super(n,w,c);
        this.taste = taste;
        this.price = price;

    }

    Fruit(String taste, double price, String name, double weight, String c) {

        super(name, weight, c);
        this.taste = taste;
        this.price = price;

    }

    @Override
    public String toString() {
        return "Fruit{" + "taste=" + taste + ", price=" + price + '}';
    }

    @Override
    protected String consumeIt() {
        return "Fruits are consumed raw";
    }

    protected boolean StoreIt(Crop f) throws CanNotBeStoredException {
        if (CropList.add((Fruit) f)) {
            return CropList.add((Fruit) f);
        } else {
            throw new CanNotBeStoredException("Can not be stored");
        }
    }

    @Override
    public int compareTo(Fruit o) {
        if (o.name.equalsIgnoreCase(this.name) && o.color.equals(this.color)) {
            return 0;
        } else {
            return (int) (getWeight() - this.weight);

        }
    }

    @Override
    public void HowToStore() {

        System.out.println("fruits in large refrigerated\n"
                + "cooler rooms");

    }

    void setName(String selectCrop) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
