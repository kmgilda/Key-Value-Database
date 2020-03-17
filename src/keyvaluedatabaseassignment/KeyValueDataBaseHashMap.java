/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyvaluedatabaseassignment;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Kshiteej
 */
public class KeyValueDataBaseHashMap {

private HashMap<Integer,String> database;
    
    public KeyValueDataBaseHashMap() {
        database = new HashMap();
    }
    
    public String insert(int key, String data) {
        return database.put(key, data);
        
    }
    
    public String read(int key) {
        return database.get(key);
    }
    
    public void update(int key, String newData) {
        database.put(key, newData);
    }
    
    public void delete(int key) {
        database.remove(key);
    }
    
    public void displayAllRecords() {
        System.out.println("The current data in the datanase is as follows : " + database + "\n");
    }
    
    public void writeToFile() {
        try {
            FileWriter fw = new FileWriter("data.txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.print(database + "\n");
            pw.close();
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        KeyValueDataBaseHashMap database = new KeyValueDataBaseHashMap();
        while (true) {
            System.out.println("Welcome to a basic CRUD Key - Value Pair database.\n Press 1 to insert a new entry \n Press 2 to search for a specific record based on its key \n Press 3 to update a record \n Press 4 to delete a record \n Press 5 to display all records. \n Press 6 to exit \n Press 7 to print to file.");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch (option) {
                case 1 :    System.out.println("Type in new key and data for new record.");
                            int key = sc.nextInt();
                            String data = sc.next();
                            database.insert(key, data);
                            break;
                case 2 :    System.out.println("Type in the key for the record you wish to search for.");
                            key = sc.nextInt();
                            System.out.println(database.read(key) + "\n");
                            break;
                case 3 :    System.out.println("Please enter the key and the new data entry for the record you wish to update");
                            key = sc.nextInt();
                            data = sc.next();
                            database.update(key, data);
                            break;
                case 4  :   System.out.println("Please enter the key of the record you wish to delete.");
                            key = sc.nextInt();
                            database.delete(key);
                            break;
                case 5  :   database.displayAllRecords();
                            break;
                case 6  :   System.exit(0);
                            break;
                case 7  :   database.writeToFile();
            }
             
        
        }
    
    
    
    }
}
