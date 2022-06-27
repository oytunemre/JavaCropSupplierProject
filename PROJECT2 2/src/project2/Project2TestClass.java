/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2;

import java.io.*;
import java.util.*;

/**
 *
 * @author oytunemreozmel
 */
public class Project2TestClass {

    static ArrayList<String> Stores = new ArrayList<>();
    static ArrayList<String> Suppliers = new ArrayList<>();
    static ArrayList<String> Crops = new ArrayList<>();
    static Fruit fruit = new Fruit();
    static Vegetable vegetable = new Vegetable();
    static Store store = new Store();
    static Supplier supplier = new Supplier();
    static int storeID = 1;
    static int supplierID = 1;

    public static void main(String[] args) throws FruitNotAvailableException,
            SupplierHasNotEnoughMoneyException, FruitNotFoundException,
            CapacityNotEnoughException, FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("(Press 1) Display all suppliers");
            System.out.println("(Press 2) Display all stores");
            System.out.println("(Press 3) Buy a fruit crop");
            System.out.println("(Press 4) Sell a fruit crop");
            System.out.println("(Press 5) Remove a fruit from a store");
            System.out.println("(Press 6) Remove a crop from a supplier");
            System.out.println("(Press 7) Add crop");
            System.out.println("(Press 8) Show remaining budget");
            System.out.println("(Press 9) Show remaining capacity");
            System.out.println("(Press 0) Quit");

            System.out.print("Enter option:");
            int option = scanner.nextInt();

            switch (option) {
                case 0:
                    System.exit(1);
                    System.out.println("GOODBYE!");
                case 1:
                    DisplayAllSuppliers();
                    break;
                case 2:
                    DisplayAllStores();
                    break;
                case 3:
                    BuyFruitCrop();
                    break;
                case 4:
                    SellFruitCrop();
                    break;
                case 5:
                    RemoveFruitFromStore();
                    break;
                case 6:
                    RemoveCropFromSupplier();
                    break;
                case 7:
                    AddCrop();
                    break;
                case 8:
                    ShowRemainingBudget();
                    break;
                case 9:
                    ShowRemainingCapacity();
                    break;
                default:
                    System.out.println("Invalid input try again!");
            }
        }

    }

    public static void DisplayAllSuppliers() throws FileNotFoundException {
        System.out.println("---------Supplier's---------");
        readSupplierFile();
        System.out.println("--------------------");
    }

    public static void DisplayAllStores() throws FileNotFoundException {
        System.out.println("-----Store's--------:");
        readStoreFiles();
        System.out.println("-------------------");

    }

    public static void BuyFruitCrop() throws FruitNotAvailableException,
            SupplierHasNotEnoughMoneyException, FruitNotFoundException,
            FileNotFoundException {
        store = null;
        supplier = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Supplier ID: ");
        Scanner scn = new Scanner(System.in);
        supplierID = scanner.nextInt();

        System.out.println("Enter Store ID: ");
        storeID = scanner.nextInt();
        while (storeID < 1000) {
            System.out.println("Invalid store id!");
        }

        readSupplierFile();
        readStoreFiles();

        Crop crop = null;
        System.out.println("F : Fruit , V: Vegetable");
        String s = scanner.next();
        if (s.equals("F")) {
            crop = new Fruit();
            System.out.println("Enter name: ");
            String name = scanner.next();
            System.out.println("Enter weight: ");
            double weight = scanner.nextDouble();
            System.out.println("Enter cultivatedSeason: ");
            String cultivatedSeason = scanner.next();
            System.out.println("Enter taste: ");
            String taste = scanner.next();
            System.out.println("Enter price: ");
            double price = scanner.nextDouble();
        } else if (s.equals("V")) {
            crop = new Vegetable();
            System.out.println("Enter name: ");
            String name = scanner.next();
            System.out.println("Enter weight: ");
            double weight = scanner.nextDouble();
            System.out.println("Enter cultivatedSeason: ");
            String cultivatedSeason = scanner.next();
            System.out.println("Enter cultivatedRegion: ");
            String cultivatedRegion = scanner.next();
        } else {
            return;
        }

        supplier.buyCrop(crop, store);

    }

    public static void SellFruitCrop() throws FruitNotAvailableException,
            SupplierHasNotEnoughMoneyException, FruitNotFoundException,
            CapacityNotEnoughException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        store = null;
        supplier = null;

        System.out.println("Enter Supplier ID: ");

        supplierID = scanner.nextInt();

        System.out.println("Enter Store ID: ");

        storeID = scanner.nextInt();

        readSupplierFile();
        readStoreFiles();

        int i = 0;
        for (Crop crop : supplier.cropList) {
            System.out.println(i + ": " + crop.name);
            i++;
        }

        System.out.println("Enter Crop Index");
        int cropIndex = scanner.nextInt();

        Crop crop = supplier.cropList.get(cropIndex);

        supplier.sellCrop(crop, store);

    }

    public static void RemoveFruitFromStore() throws FruitNotFoundException,
            FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        store = null;

        System.out.println("Enter Store ID: ");

        storeID = scanner.nextInt();
        readStoreFiles();

        int i = 0;
        for (Fruit f : store.getFruitList()) {
            System.out.println(i + ": " + f.toString());
            i++;
        }

        System.out.println("Enter Fruit Index: ");
        int fruitIndex = scanner.nextInt();

        Fruit f = store.fruitList.get(i);

        store.fruitList.remove(f);
    }

    public static void RemoveCropFromSupplier() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        supplier = null;

        System.out.println("Enter Store ID: ");
        storeID = scanner.nextInt();
        readSupplierFile();

        int i = 0;
        for (Crop c : supplier.cropList) {
            System.out.println(i + ": " + c.toString());
            i++;
        }

        System.out.println("Enter Fruit Index: ");
        int cropIndex = scanner.nextInt();

        Crop c = supplier.cropList.get(i);

        supplier.cropList.remove(c);
    }

    public static void AddCrop() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        supplier = null;
        System.out.println("Enter Store ID: ");
        storeID = scanner.nextInt();
        readSupplierFile();
        Crop crop = null;
        System.out.println("F : Fruit , V: Vegetable");
        String s = scanner.next();
        if (s.equals("F")) {
            crop = new Fruit();
            System.out.println("Enter name: ");
            String name = scanner.next();
            System.out.println("Enter weight: ");
            double weight = scanner.nextDouble();
            System.out.println("Enter cultivatedSeason: ");
            String cultivatedSeason = scanner.next();
            System.out.println("Enter taste: ");
            String taste = scanner.next();
            System.out.println("Enter price: ");
            double price = scanner.nextDouble();
        } else if (s.equals("V")) {
            crop = new Vegetable();
            System.out.println("Enter name: ");
            String name = scanner.next();
            System.out.println("Enter weight: ");
            double weight = scanner.nextDouble();
            System.out.println("Enter cultivatedSeason: ");
            String cultivatedSeason = scanner.next();
            System.out.println("Enter cultivatedRegion: ");
            String cultivatedRegion = scanner.next();
        }

        supplier.cropList.add(crop);
    }

    public static void ShowRemainingBudget() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Supplier selectedSupplier = null;
        System.out.println("Enter Store ID: ");
        storeID = scanner.nextInt();
        readSupplierFile();

        System.out.println("Supplier Remaining Budget : " + selectedSupplier.budget);

    }

    public static void ShowRemainingCapacity() throws FileNotFoundException {
        store = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Store ID: ");
        storeID = scanner.nextInt();
        readStoreFiles();
        double remainingCapcity = store.getMaxCapacityArea() - store.getUsedCapcaityArea();
        System.out.println("Store Remaining Capacity : " + remainingCapcity);

    }

    public static void createFiles() {

        try {
            File myObj = new File("Stores.txt");
            if (!myObj.createNewFile()) {
                System.out.println("File already exists.");
            } else {
                System.out.println("File created: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");

        }

        try {
            File myObj = new File("Suppliers.txt");
            if (!myObj.createNewFile()) {
                System.out.println("File already exists.");
            } else {
                System.out.println("File created: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");

        }

        try {
            File myObj = new File("Crop.txt");
            if (!myObj.createNewFile()) {
                System.out.println("File already exists.");
            } else {
                System.out.println("File created: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static void fillTheFiles() {

        try {
            PrintWriter myWriter = new PrintWriter("Stores.txt");
            myWriter.write("Migros, 5343, 1000, 12\n"
                    + "File, 5967, 1200, 10");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {

        }

        try {
            PrintWriter myWriter = new PrintWriter("Suppliers.txt");
            myWriter.write("ArazMeyve, 1133, 1000\n"
                    + "AylarTarim, 1298, 1500\n"
                    + "HasanBey, 1322, 200\n"
                    + "ZehraCiftci, 1429, 12500");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {

        }

        try {
            PrintWriter myWriter = new  PrintWriter("Crop.txt");
            myWriter.write("RedApple, fruit, 45, winter, sweet, 3, 1133 Orange, fruit,"
                    + " 50, autumn, sour, 4, 5967 Kiwi, fruit, 10, autumn, sour, 10, 1133"
                    + " Parsley , vegetable, 25, Samsun, 1429\n"
                    + "Mint, vegetable, 15, Adana, 1429 GreenApple, fruit, 25, "
                    + "winter, sweet, 6, 1133 Orange, fruit, 20, autumn, sour, 4, "
                    + "1322 GreenApple, fruit, 5, winter, sweet, 6, 5343 GreenBeans,"
                    + " vegetable, 22, Bursa, 1322 Banana, fruit, 63, summer, sweet, 12, 5343");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {

        }

    }

    public static void readStoreFiles() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        File StoresFile = new File("/Users/oytunemreozmel/NetbeansProjects/PROJECT2/Stores.txt");
        scanner = new Scanner(StoresFile);

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    public static void readSupplierFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        File SupplierFile = new File("/Users/oytunemreozmel/NetbeansProjects/PROJECT2/Suppliers.txt");
        scanner = new Scanner(SupplierFile);

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

    public static void readCropFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        File CropFile = new File("/Users/oytunemreozmel/NetbeansProjects/PROJECT2/Crop.txt");
        scanner = new Scanner(CropFile);

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }

}
